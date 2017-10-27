package com.example.sony.training;

import java.text.NumberFormat;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class MainActivity extends Activity
        implements OnEditorActionListener, OnSeekBarChangeListener,
        OnCheckedChangeListener, OnItemSelectedListener, OnKeyListener {

    private EditText billAmountEditText;
    private TextView percentTextView;
    private SeekBar percentSeekBar;
    private TextView tipTextView;
    private TextView totalTextView;
    private RadioGroup roundingRadioGroup;
    private RadioButton roundNoneRadioButton;
    private RadioButton roundTipRadioButton;
    private RadioButton roundTotalRadioButton;
    private Spinner splitSpinner;
    private TextView perPersonLabel;
    private TextView perPersonTextView;

    private SharedPreferences savedValues;

    private final int ROUND_NONE = 0;
    private final int ROUND_TIP = 1;
    private final int ROUND_TOTAL = 2;

    private String billAmountString = "";
    private float tipPercent = .15f;
    private int rounding = ROUND_NONE;
    private int split = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billAmountEditText = (EditText) findViewById(R.id.billAmountEditText);
        percentTextView = (TextView) findViewById(R.id.percentTextView);
        percentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);
        tipTextView = (TextView) findViewById(R.id.tipTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        roundingRadioGroup = (RadioGroup) findViewById(R.id.roundingRadioGroup);
        roundNoneRadioButton = (RadioButton) findViewById(R.id.roundNoneRadioButton);
        roundTipRadioButton = (RadioButton) findViewById(R.id.roundTipRadioButton);
        roundTotalRadioButton = (RadioButton) findViewById(R.id.roundTotalRadioButton);
        splitSpinner = (Spinner) findViewById(R.id.splitSpinner);
        perPersonLabel = (TextView) findViewById(R.id.perPersonLabel);
        perPersonTextView = (TextView) findViewById(R.id.perPersonTextView);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.split_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        splitSpinner.setAdapter(adapter);

        billAmountEditText.setOnEditorActionListener(this);
        billAmountEditText.setOnKeyListener(this);
        percentSeekBar.setOnSeekBarChangeListener(this);
        percentSeekBar.setOnKeyListener(this);
        roundingRadioGroup.setOnCheckedChangeListener(this);
        roundingRadioGroup.setOnKeyListener(this);
        splitSpinner.setOnItemSelectedListener(this);

        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    @Override
    public void onPause() {
        Editor editor = savedValues.edit();
        editor.putString("billAmountString", billAmountString);
        editor.putFloat("tipPercent", tipPercent);
        editor.putInt("rounding", rounding);
        editor.putInt("split", split);
        editor.commit();

        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

        billAmountString = savedValues.getString("billAmountString", "");
        tipPercent = savedValues.getFloat("tipPercent", 0.15f);
        rounding = savedValues.getInt("rounding", ROUND_NONE);
        split = savedValues.getInt("split", 1);

        billAmountEditText.setText(billAmountString);

        int progress = Math.round(tipPercent * 100);
        percentSeekBar.setProgress(progress);

        if (rounding == ROUND_NONE) {
            roundNoneRadioButton.setChecked(true);
        }
        else if (rounding == ROUND_TIP) {
            roundTipRadioButton.setChecked(true);
        }
        else if (rounding == ROUND_TIP) {
            roundTotalRadioButton.setChecked(true);
        }

        int position = split - 1;
        splitSpinner.setSelection(position);
    }

    public void calculateAndDisplay() {
        billAmountString = billAmountEditText.getText().toString();
        float billAmount;
        if (billAmountString.equals("")) {
            billAmount = 0;
        }
        else {
            billAmount = Float.parseFloat(billAmountString);
        }

        int progress = percentSeekBar.getProgress();
        tipPercent = (float) progress / 100;

        float tipAmount = 0;
        float totalAmount = 0;
        if (rounding == ROUND_NONE) {
            tipAmount = billAmount * tipPercent;
            totalAmount = billAmount + tipAmount;
        }
        else if (rounding == ROUND_TIP) {
            tipAmount = StrictMath.round(billAmount * tipPercent);
            totalAmount = billAmount + tipAmount;
            tipPercent = tipAmount / billAmount;
        }
        else if (rounding == ROUND_TOTAL) {
            float tipNotRounded = billAmount * tipPercent;
            totalAmount = StrictMath.round(billAmount + tipNotRounded);
            tipAmount = totalAmount - billAmount;
            tipPercent = tipAmount / billAmount;
        }

        float splitAmount = 0;
        splitAmount = totalAmount / split;

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        tipTextView.setText(currency.format(tipAmount));
        totalTextView.setText(currency.format(totalAmount));
        perPersonTextView.setText(currency.format(splitAmount));

        NumberFormat percent = NumberFormat.getPercentInstance();
        percentTextView.setText(percent.format(tipPercent));
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            calculateAndDisplay();
        }
        return false;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        percentTextView.setText(progress + "%");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        calculateAndDisplay();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.roundNoneRadioButton:
                rounding = ROUND_NONE;
                break;
            case R.id.roundTipRadioButton:
                rounding = ROUND_TIP;
                break;
            case R.id.roundTotalRadioButton:
                rounding = ROUND_TOTAL;
                break;
        }
        calculateAndDisplay();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position,
                               long id) {
        split = position + 1;
        calculateAndDisplay();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public boolean onKey(View view, int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_ENTER:
            case KeyEvent.KEYCODE_DPAD_CENTER:

                calculateAndDisplay();

                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(
                        billAmountEditText.getWindowToken(), 0);

                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (view.getId() == R.id.percentSeekBar) {
                    calculateAndDisplay();
                }
                break;
        }
        return false;
    }
}