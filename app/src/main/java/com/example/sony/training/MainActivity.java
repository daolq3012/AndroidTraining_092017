package com.example.sony.training;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
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

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener,
                                 RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener,
                                  SeekBar.OnSeekBarChangeListener, TextView.OnEditorActionListener {
    private Button calculatorButton;
    private TextView totalTextView;
    private Spinner spinnerBill;
    private EditText mEditAmount;
    private EditText billAmountEditText;
    private TextView percentTextView;
    private SeekBar percentSeekBar;
    private TextView tipTextView;
    private RadioGroup roundingRadioGroup;
    private RadioButton roundNoneRadioButton;
    private RadioButton roundTipRadioButton;
    private RadioButton roundTotalRadioButton;
    private Spinner splitSpinner;
    private TextView perPersonLabel;
    private TextView perPersonTextView;

    // xác định đối tượng SharedPreferences
    private SharedPreferences savedValues;

    // định nghĩa các hằng số làm tròn
    private final int ROUND_NONE = 0;
    private final int ROUND_TIP = 1;
    private final int ROUND_TOTAL = 2;

    // xác định các biến
    private String billAmountString = "";
    private float tipPercent = .15f;
    private int rounding = ROUND_NONE;
    private int split = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_widgets_bill);

        // get references to the widgets
        billAmountEditText = (EditText) findViewById(R.id.editAmount);
        percentTextView = (TextView) findViewById(R.id.percentTextView);
        percentSeekBar = (SeekBar) findViewById(R.id.seekBarPercent);
        tipTextView = (TextView) findViewById(R.id.tipTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        roundingRadioGroup = (RadioGroup)
                findViewById(R.id.roundingRadioGroup);
        roundNoneRadioButton = (RadioButton)
                findViewById(R.id.radioBtnNone);
        roundTipRadioButton = (RadioButton)
                findViewById(R.id.radioBtnTip);
        roundTotalRadioButton = (RadioButton)
                findViewById(R.id.radioBtnTotal);
        splitSpinner = (Spinner) findViewById(R.id.spinnerBill);
        perPersonLabel = (TextView) findViewById(R.id.percentLabel);
        perPersonTextView = (TextView) findViewById(R.id.percentTextView);

        // set array adapter for spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.split_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        splitSpinner.setAdapter(adapter);

        // set the listeners
        billAmountEditText.setOnEditorActionListener(this);
        billAmountEditText.setOnKeyListener(this);
        percentSeekBar.setOnSeekBarChangeListener(this);
        percentSeekBar.setOnKeyListener(this);
        roundingRadioGroup.setOnCheckedChangeListener(this);
        roundingRadioGroup.setOnKeyListener(this);
        splitSpinner.setOnItemSelectedListener(this);

        // get SharedPreferences object
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calculateButton:
                //get the bill amount
                String input = (mEditAmount.getText().toString());
                int so = Integer.parseInt(input);
                int result = so / 2;
                totalTextView.setText("$" + result);
                Toast.makeText(this, "Click vao button calculator", Toast.LENGTH_LONG).show();
                break;
            case R.id.totalTextView:
                Toast.makeText(this, "Click vao total textview", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        // get the instance variables
        billAmountString = savedValues.getString("billAmountString", "");
        tipPercent = savedValues.getFloat("tipPercent", 0.15f);
        rounding = savedValues.getInt("rounding", ROUND_NONE);
        split = savedValues.getInt("split", 1);

        // set the bill amount on its widget
        billAmountEditText.setText(billAmountString);

        // set the tip percent on its widget
        int progress = Math.round(tipPercent * 100);
        percentSeekBar.setProgress(progress);

        // set rounding on radio buttons
        // NOTE: this executes the onCheckedChanged method,
        // which executes the calculateAndDisplay method
        if (rounding == ROUND_NONE) {
            roundNoneRadioButton.setChecked(true);
        } else if (rounding == ROUND_TIP) {
            roundTipRadioButton.setChecked(true);
        } else if (rounding == ROUND_TIP) {
            roundTotalRadioButton.setChecked(true);
        }

        // set split on spinner
        // NOTE: this executes the onItemSelected method,
        // which executes the calculateAndDisplay method
        int position = split - 1;
        splitSpinner.setSelection(position);
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
        if (rounding == ROUND_NONE) {
            tipAmount = billAmount * tipPercent;
            totalAmount = billAmount + tipAmount;
        } else if (rounding == ROUND_TIP) {
            tipAmount = StrictMath.round(billAmount * tipPercent);
            totalAmount = billAmount + tipAmount;
            tipPercent = tipAmount / billAmount;
        } else if (rounding == ROUND_TOTAL) {
            float tipNotRounded = billAmount * tipPercent;
            totalAmount = StrictMath.round(billAmount + tipNotRounded);
            tipAmount = totalAmount - billAmount;
            tipPercent = tipAmount / billAmount;
        }

        // calculate split amount and show/hide split amount widgets
        float splitAmount = 0;
        // split - calculate amount and show widgets
        splitAmount = totalAmount / split;

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
                rounding = ROUND_NONE;
                break;
            case R.id.radioBtnTip:
                rounding = ROUND_TIP;
                break;
            case R.id.radioBtnTotal:
                rounding = ROUND_TOTAL;
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
        split = position + 1;
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
