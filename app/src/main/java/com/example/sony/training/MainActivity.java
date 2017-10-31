package com.example.sony.training;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener,
        RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener,
        SeekBar.OnSeekBarChangeListener, TextView.OnEditorActionListener {
    private Button calculatorButton;
    private TextView totalTextView;
    private TextView percentTextView;
    private TextView tipTextView;
    private TextView perPersonLabel;
    private TextView perPersonTextView;
    private RadioGroup roundingRadioGroup;
    private RadioButton roundNoneRadioButton;
    private RadioButton roundTipRadioButton;
    private RadioButton roundTotalRadioButton;
    private EditText mEditAmount;
    private EditText billAmountEditText;
    private SeekBar percentSeekBar;
    private Spinner sPlitSpinner;
    private Spinner sPinnerBill;
    private SharedPreferences savedValues;
    private static final int ROUND_NONE = 0;
    private static final int ROUND_TIP = 1;
    private static final int ROUND_TOTAL = 2;
    private String billAmountString = "";
    private float tipPercent = .15f;
    private int mRounding = ROUND_NONE;
    private int mSplit = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_widgets_bill);
        initViews();
        setEventClickViews();
    }

    private void initViews() {
        // get references to the widgets
        billAmountEditText = (EditText) findViewById(R.id.editAmount);

        percentTextView = (TextView) findViewById(R.id.percentTextView);
        tipTextView = (TextView) findViewById(R.id.tipTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        perPersonLabel = (TextView) findViewById(R.id.percentLabel);
        perPersonTextView = (TextView) findViewById(R.id.percentTextView);

        roundingRadioGroup = (RadioGroup)
                findViewById(R.id.roundingRadioGroup);
        roundNoneRadioButton = (RadioButton)
                findViewById(R.id.radioBtnNone);
        roundTipRadioButton = (RadioButton)
                findViewById(R.id.radioBtnTip);
        roundTotalRadioButton = (RadioButton)
                findViewById(R.id.radioBtnTotal);

        sPlitSpinner = (Spinner) findViewById(R.id.spinnerBill);
        percentSeekBar = (SeekBar) findViewById(R.id.seekBarPercent);

        // set array adapter for spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.split_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        sPlitSpinner.setAdapter(adapter);
    }

    public void setEventClickViews() {
        // set the listeners
        billAmountEditText.setOnEditorActionListener(this);
        billAmountEditText.setOnKeyListener(this);
        percentSeekBar.setOnSeekBarChangeListener(this);
        percentSeekBar.setOnKeyListener(this);
        roundingRadioGroup.setOnCheckedChangeListener(this);
        roundingRadioGroup.setOnKeyListener(this);
        sPlitSpinner.setOnItemSelectedListener(this);

        // get SharedPreferences object
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calculateButton:
                //get the bill amount
                String input = mEditAmount.getText().toString();
                int so = Integer.parseInt(input);
                int result = so / 2;
                totalTextView.setText(result);
                break;

        }
    }

    @Override
    public void onResume() {
        super.onResume();

        // get the instance variables
        billAmountString = savedValues.getString("billAmountString", "");
        tipPercent = savedValues.getFloat("tipPercent", 0.15f);
        mRounding = savedValues.getInt("rounding", ROUND_NONE);
        mSplit = savedValues.getInt("mSplit", 1);

        // set the bill amount on its widget
        billAmountEditText.setText(billAmountString);

        // set the tip percent on its widget
        int progress = Math.round(tipPercent * 100);
        percentSeekBar.setProgress(progress);

        // set rounding on radio buttons
        // NOTE: this executes the onCheckedChanged method,
        // which executes the calculateAndDisplay method
        if (mRounding == ROUND_NONE) {
            roundNoneRadioButton.setChecked(true);
        } else if (mRounding == ROUND_TIP) {
            roundTipRadioButton.setChecked(true);
        } else if (mRounding == ROUND_TIP) {
            roundTotalRadioButton.setChecked(true);
        }

        // set split on spinner
        // NOTE: this executes the onItemSelected method,
        // which executes the calculateAndDisplay method
        int position = mSplit - 1;
        sPlitSpinner.setSelection(position);
    }

    public void calculateAndDisplay() {
        // get the bill amount
        billAmountString = billAmountEditText.getText().toString();
        float billAmount;
        if (billAmountString.equals("")) {
            billAmount = 0;
        } else {
            billAmount = Float.parseFloat(billAmountString);
        }

        // get tip percent
        int progress = percentSeekBar.getProgress();
        tipPercent = (float) progress / 100;

        // calculate tip and total
        float tipAmount = 0;
        float totalAmount = 0;
        if (mRounding == ROUND_NONE) {
            tipAmount = billAmount * tipPercent;
            totalAmount = billAmount + tipAmount;
        } else if (mRounding == ROUND_TIP) {
            tipAmount = StrictMath.round(billAmount * tipPercent);
            totalAmount = billAmount + tipAmount;
            tipPercent = tipAmount / billAmount;
        } else if (mRounding == ROUND_TOTAL) {
            float tipNotRounded = billAmount * tipPercent;
            totalAmount = StrictMath.round(billAmount + tipNotRounded);
            tipAmount = totalAmount - billAmount;
            tipPercent = tipAmount / billAmount;
        }

        // calculate split amount and show/hide split amount widgets
        float splitAmount = 0;
        // split - calculate amount and show widgets
        splitAmount = totalAmount / mSplit;

        // display the results with formatting
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        tipTextView.setText(currency.format(tipAmount));
        totalTextView.setText(currency.format(totalAmount));
        perPersonTextView.setText(currency.format(splitAmount));

        NumberFormat percent = NumberFormat.getPercentInstance();
        percentTextView.setText(percent.format(tipPercent));
    }

    //*****************************************************
    // Event handler for the EditText
    //*****************************************************
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

    //*****************************************************
    // Event handler for the RadioGroup
    //*****************************************************
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radioBtnNone:
                mRounding = ROUND_NONE;
                break;
            case R.id.radioBtnTip:
                mRounding = ROUND_TIP;
                break;
            case R.id.radioBtnTotal:
                mRounding = ROUND_TOTAL;
                break;
        }
        calculateAndDisplay();
    }

    //*****************************************************
    // Event handler for the Spinner
    //*****************************************************
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position,
                               long id) {
        mSplit = position + 1;
        calculateAndDisplay();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }

    //*****************************************************
    // Event handler for the keyboard and DPad
    //*****************************************************
    @Override
    public boolean onKey(View view, int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_ENTER:
            case KeyEvent.KEYCODE_DPAD_CENTER:

                calculateAndDisplay();

                // hide the soft keyboard
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(
                        billAmountEditText.getWindowToken(), 0);

                // consume the event
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (view.getId() == R.id.seekBarPercent) {
                    calculateAndDisplay();
                }
                break;
        }
        // don't consume the event
        return false;
    }


}
