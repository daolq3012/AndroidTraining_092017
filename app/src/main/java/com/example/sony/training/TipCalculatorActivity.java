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
    private Button percentDownButton;
    private Button percentUpButton;

    private float tipPercent = 0.1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        billAmountEditText = (EditText) findViewById(R.id.billAmountEditText);
        tipTextView = (TextView) findViewById(R.id.tipTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        percentDownButton = (Button) findViewById(R.id.percentDownButton);
        percentUpButton = (Button) findViewById(R.id.percentUpButton);

        billAmountEditText.setOnEditorActionListener(this);
        percentDownButton.setOnClickListener(this);
        percentUpButton.setOnClickListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            calculateAndDisplay();
        }
        return false;
    }

    public void calculateAndDisplay() {
        String billAmountString = billAmountEditText.getText().toString();
        float billAmount;
        if (billAmountString.equals("")) {
            billAmount = 0;
        } else {
            billAmount = Float.parseFloat(billAmountString);
        }


        float tipAmount = billAmount * tipPercent;
        float totalAmount = billAmount + tipAmount;

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        tipTextView.setText(currency.format(tipAmount));
        totalTextView.setText(currency.format(totalAmount));
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()) {
           case R.id.percentDownButton:
               tipPercent = tipPercent - 0.01f;
               calculateAndDisplay();
               break;
           case R.id.percentUpButton:
               tipPercent = tipPercent + 0.01f;
               calculateAndDisplay();
               break;
       }
    }
}
