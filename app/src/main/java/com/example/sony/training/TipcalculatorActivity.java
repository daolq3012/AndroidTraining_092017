package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import java.text.NumberFormat;

public class TipcalculatorActivity extends AppCompatActivity implements OnEditorActionListener, View.OnClickListener {
    private EditText billAmountEditText;
    private TextView tipTextview;
    private TextView totalTextview;
    float tipPercent = 0.1f;
    Button percentUpButton;
    Button percentDownButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipcalculator);

        billAmountEditText = (EditText) findViewById(R.id.billAmountEditText);
        tipTextview = (TextView) findViewById(R.id.tipTextView);
        totalTextview = (TextView) findViewById(R.id.totalTextView);
        percentUpButton = (Button) findViewById(R.id.percentUpButton);
        percentDownButton = (Button) findViewById(R.id.percentDownButton);
        billAmountEditText.setOnEditorActionListener(this);
        percentUpButton.setOnClickListener(this);
        percentDownButton.setOnClickListener(this);


    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            calculatorAndDissplay();
        }
        return false;
    }

    public void calculatorAndDissplay() {
        String billAmountString = billAmountEditText.getText().toString();
        float billAmount = 10;
        if (billAmountString.equals("")) {
            billAmount = 0;
        } else {
            billAmount = Float.parseFloat(billAmountString);

            float tipAmount = billAmount * tipPercent;
            float totalAmount = billAmount + tipAmount;
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            tipTextview.setText(currency.format(tipAmount));
            totalTextview.setText(currency.format(totalAmount));

        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.percentDownButton:
                tipPercent = tipPercent - 0.01f;
                calculatorAndDissplay();
                break;
            case R.id.percentUpButton:
                tipPercent = tipPercent + 0.01f;
                calculatorAndDissplay();
                break;
        }
    }
}
