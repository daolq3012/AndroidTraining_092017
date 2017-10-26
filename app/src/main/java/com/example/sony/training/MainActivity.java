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

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,TextView.OnEditorActionListener,
        SeekBar.OnSeekBarChangeListener,RadioGroup.OnCheckedChangeListener,AdapterView.OnItemSelectedListener,View.OnKeyListener{

    private Spinner mSpnSplit;
    private Button mBtnCalculate;
    private TextView mTxtTotal;
    private EditText mEdtBill;
    private TextView mTxtPercent;
    private SeekBar mSbPercent;
    private TextView mTxtTip;
    private RadioGroup mRground;
    private RadioButton mRbNone;
    private RadioButton mRbTip;
    private RadioButton mRbTotal;
    private TextView mTxtPerPerson;
    private SharedPreferences savedValues;
    private final int ROUND_NONE = 0;
    private final int ROUND_TIP = 1;
    private final int ROUND_TOTAL = 2;
    private String billAmountString = "";
    private float tipPercent = .15f;
    private int rounding = ROUND_NONE;
    private int split = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bill);
        initView();

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.arraySpinnerBill,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnSplit.setAdapter(arrayAdapter);

        initListener();
    }
    private void initView(){
        mSpnSplit = (Spinner) findViewById(R.id.split_spinner);
        mBtnCalculate = (Button) findViewById(R.id.calculate_Button);
        mEdtBill = (EditText) findViewById(R.id.bill_EditText);
        mTxtTotal = (TextView) findViewById(R.id.total_TextView);
        mTxtTip = (TextView) findViewById(R.id.tip_TextView);
        mRbTotal = (RadioButton) findViewById(R.id.total_RadioButton);
        mRbNone = (RadioButton) findViewById(R.id.none_RadioButton);
        mRbTip = (RadioButton) findViewById(R.id.tip_RadioButton);
        mRground = (RadioGroup) findViewById(R.id.round_RadioGroup);
        mSbPercent = (SeekBar) findViewById(R.id.percent_Seekbar);
        mTxtPercent = (TextView) findViewById(R.id.percent_TextView);
        mTxtPerPerson = (TextView) findViewById(R.id.perPerson_TextView);
    }

    private void initListener(){

        mBtnCalculate.setOnClickListener(this);
        mEdtBill.setOnClickListener(this);
        mEdtBill.setOnEditorActionListener(this);
        mSbPercent.setOnSeekBarChangeListener(this);
        mSbPercent.setOnKeyListener(this);
        mRground.setOnCheckedChangeListener(this);
        mRground.setOnKeyListener(this);
        mSpnSplit.setOnItemSelectedListener(this);

        // get SharedPreferences object
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    @Override
    protected void onPause() {
        // save the instance variables
        SharedPreferences.Editor editor = savedValues.edit();
        editor.putString("billAmountString", billAmountString);
        editor.putFloat("tipPercent", tipPercent);
        editor.putInt("rounding", rounding);
        editor.putInt("split", split);
        editor.commit();
        super.onPause();
    }

    @Override
    protected void onResume() {
        // get the instance variables
        billAmountString = savedValues.getString("billAmountString", "");
        tipPercent = savedValues.getFloat("tipPercent", .15f);
        rounding = savedValues.getInt("rounding", ROUND_NONE );
        split = savedValues.getInt("split", 1);

        // set the bill amount on its widget
        mEdtBill.setText(billAmountString);

        // set the tip percent on its widget
        int progress = Math.round(tipPercent * 100);
        mSbPercent.setProgress(progress);

        // set rounding on radio buttons
        // NOTE: this executes the onCheckedChanged method,
        // which executes the calculateAndDisplay method
        if (rounding == ROUND_NONE){
            mRbNone.setChecked(true);
        }else if (rounding == ROUND_TIP){
            mRbTip.setChecked(true);
        }else if (rounding == ROUND_TOTAL){
            mRbTotal.setChecked(true);
        }
        // set split on spinner
        // NOTE: this executes the onItemSelected method,
        // which executes the calculateAndDisplay method
        int position = split - 1;
        mSpnSplit.setSelection(position);

        super.onResume();
    }

    public void calculateAndDisplay(){
        // get the bill amount
        billAmountString = mEdtBill.getText().toString();
        float billAmount;
        if (billAmountString.equals("")){
            billAmount = 0;
        }else {
            billAmount = Float.parseFloat(billAmountString);
        }

        // get tip percent
        int progress = mSbPercent.getProgress();
        tipPercent = (float) progress/100;

        // calculate tip and total
        float tipAmount = 0 ;
        float totalAmount = 0;
        if (rounding == ROUND_NONE){
            tipAmount = billAmount * tipPercent;
            totalAmount = billAmount + tipAmount;
        }else if (rounding == ROUND_TIP){
            tipAmount = StrictMath.round(billAmount * tipPercent);
            totalAmount = billAmount + tipAmount;
            tipPercent = tipAmount / billAmount;
        }else if (rounding == ROUND_TOTAL){
            float tipNotRounded = billAmount * tipPercent;
            totalAmount = StrictMath.round(billAmount + tipAmount);
            tipAmount = totalAmount - billAmount;
            tipPercent = tipAmount / billAmount;
        }

        // calculate split amount and show/hide split amount widgets
        float splitAmount = 0;
        // split - calculate amount and show widgets
        splitAmount = totalAmount / split;

        // display the results with formatting
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        mTxtTip.setText(currency.format(tipAmount));
        mTxtTotal.setText(currency.format(totalAmount));
        mTxtPerPerson.setText(currency.format(splitAmount));

        NumberFormat percent = NumberFormat.getPercentInstance();
        mTxtPercent.setText(percent.format(tipPercent));

    }

    //*****************************************************
    // Event handler for the EditText
    //*****************************************************
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED){
            calculateAndDisplay();
        }

        return false;
    }

    //*****************************************************
    // Event handler for the SeekBar
    //*****************************************************
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mTxtPercent.setText(progress + "%");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

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
        switch (checkedId){
            case R.id.none_RadioButton:
                rounding = ROUND_NONE;
                break;
            case R.id.tip_RadioButton:
                rounding = ROUND_TIP;
                break;
            case R.id.total_RadioButton:
                rounding = ROUND_TOTAL;
                break;
        }
        calculateAndDisplay();
    }

    //*****************************************************
    // Event handler for the Spinner
    //*****************************************************
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        split = position + 1;
        calculateAndDisplay();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //*****************************************************
    // Event handler for the Spinner
    //*****************************************************
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_ENTER:
            case KeyEvent.KEYCODE_DPAD_CENTER:
                calculateAndDisplay();

                // hide the soft keyboard
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mEdtBill.getWindowToken(),0);

                // consume the event
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (v.getId() == R.id.percent_Seekbar){
                    calculateAndDisplay();
                }
                break;
        }
        // don't consume the event
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.calculate_Button:
                String strbill = mEdtBill.getText().toString();
                float floatbill = Float.parseFloat(strbill);
                mTxtTotal.setText("đ " + (floatbill/2));
                break;
            case R.id.bill_EditText:
                mTxtTotal.setText("đ " + 0);
                break;
        }
    }
}
