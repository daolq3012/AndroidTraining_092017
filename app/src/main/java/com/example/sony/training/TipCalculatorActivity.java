package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class TipCalculatorActivity extends AppCompatActivity implements TextView.OnEditorActionListener, View.OnClickListener {

    private EditText billAmountEditText;
    private TextView tipTextView;
    private TextView totalTextView;
    private float tipPerSent = .15f;
    private Button percentUpButton;
    private Button percentDownButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator2);


        billAmountEditText = (EditText) findViewById(R.id.billAmountEditText);
        tipTextView = (TextView) findViewById(R.id.tipTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        percentUpButton = (Button) findViewById(R.id.percentUpButton);
        percentDownButton = (Button) findViewById(R.id.percentDownButton);
        billAmountEditText.setOnEditorActionListener(this);
        percentUpButton.setOnClickListener(this);
        percentDownButton.setOnClickListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            calculatorAndDisplay();

        }
        return false;
    }

    public void calculatorAndDisplay() {

        //get the bill amount
        String billAmountString = billAmountEditText.getText().toString();
        float billAmount;
        if (billAmountString.equals("")) {
            billAmount = 0;
        } else {
            billAmount = Float.parseFloat(billAmountString);
        }

        //calculate tip and total

        float tipAmount = billAmount * tipPerSent;
        float totalAmount = billAmount + tipAmount;

        //display the results with formatting
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        tipTextView.setText(currency.format(tipAmount));
        totalTextView.setText(currency.format(totalAmount));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.percentDownButton:
                tipPerSent = tipPerSent - 0.01f;;
                calculatorAndDisplay();
                break;
            case R.id.percentUpButton:
                tipPerSent = tipPerSent + 0.01f;
                calculatorAndDisplay();
                break;
        }

    }
}
