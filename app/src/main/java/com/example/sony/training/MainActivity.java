package com.example.sony.training;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
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

import org.xml.sax.Parser;

import java.text.NumberFormat;

public class MainActivity extends Activity implements View.OnClickListener, TextView.OnEditorActionListener, SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener, View.OnKeyListener {

    private Spinner mSpinner;
    private Button mCalculate;
    private TextView mTotal;
    private EditText mBill;
    private TextView mPt;
    private SeekBar mSeek;
    private TextView mTip;
    private RadioGroup mRadioGr;
    private RadioButton mRNone;
    private RadioButton mRTip;
    private RadioButton mRTotal;
    private TextView mPerson;
    private TextView mPersonLB;

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
        setContentView(R.layout.layout);

        //widget
        mCalculate = (Button) findViewById(R.id.btnCalculate);
        mSpinner = (Spinner) findViewById(R.id.Spn);
        mTotal = (TextView) findViewById(R.id.txtTotal1);
        mBill = (EditText) findViewById(R.id.edtBill);
        mPt = (TextView) findViewById(R.id.txtpt);
        mSeek = (SeekBar) findViewById(R.id.seekPercent);
        mTip = (TextView) findViewById(R.id.txtTip1);
        mRadioGr = (RadioGroup) findViewById(R.id.radiogr);
        mRNone = (RadioButton) findViewById(R.id.rdNone);
        mRTip = (RadioButton) findViewById(R.id.rdTip);
        mRTotal = (RadioButton) findViewById(R.id.rdTotal);
        mPersonLB = (TextView) findViewById(R.id.txtPer);
        mPerson = (TextView) findViewById(R.id.txtPer1);

        //Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        //Listen
        mBill.setOnClickListener(this);
        mBill.setOnKeyListener(this);
        mSeek.setOnSeekBarChangeListener(this);
        mSeek.setOnKeyListener(this);
        mRadioGr.setOnCheckedChangeListener(this);
        mRadioGr.setOnKeyListener(this);
        mSpinner.setOnItemSelectedListener(this);

        //Shared
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);
    }

    @Override
    protected void onPause() {
        //save
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
        super.onResume();

        //get
        billAmountString = savedValues.getString("billAmountString", "");
        tipPercent = savedValues.getFloat("tipPercent", .15f);
        rounding = savedValues.getInt("rounding", ROUND_NONE);
        split = savedValues.getInt("split", 1);

        //set bill
        mBill.setText(billAmountString);

        //set tip
        int progress = Math.round(tipPercent * 100);
        mSeek.setProgress(progress);

        //set radio
        if (rounding == ROUND_NONE) {
            mRNone.setChecked(true);
        } else if (rounding == ROUND_TIP) {
            mRTip.setChecked(true);
        } else if (rounding == ROUND_TOTAL) {
            mRTotal.setChecked(true);
        }

        //set split
        int position = split - 1;
        mSpinner.setSelection(position);
    }

    public void calculateAndDisplay() {
        //get bill
        billAmountString = mBill.getText().toString();
        float billAmount;
        if (billAmountString.equals("")) {
            billAmount = 0;
        } else {
            billAmount = Float.parseFloat(billAmountString);
        }

        //get tip
        int progress = mSeek.getProgress();
        tipPercent = (float) progress / 100;

        //calculate tip&total
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

        //calculate split
        float splitAmount = 0;

        splitAmount = totalAmount / split;

        NumberFormat percent = NumberFormat.getPercentInstance();
        mPt.setText(percent.format(tipPercent));
    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_ENTER:
            case KeyEvent.KEYCODE_DPAD_CENTER:

                calculateAndDisplay();

                //hide keyboard
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mBill.getWindowToken(),0);

                //consume the event
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            case  KeyEvent.KEYCODE_DPAD_LEFT:
                if (v.getId() == R.id.seekPercent) {
                    calculateAndDisplay();
                }
                break;
        }
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        split = position + 1;
        calculateAndDisplay();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rdNone:
                rounding = ROUND_NONE;
                break;
            case R.id.rdTip:
                rounding = ROUND_TIP;
                break;
            case R.id.rdTotal:
                rounding = ROUND_TOTAL;
                break;
        }
        calculateAndDisplay();

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mPt.setText(progress + "%");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        calculateAndDisplay();

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
    public void onClick(View v) {

    }
}
