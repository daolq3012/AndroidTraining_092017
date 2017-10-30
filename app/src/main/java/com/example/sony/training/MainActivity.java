package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Spinner mSpnBill;
    private Button mBtnCalculate;
    private TextView mTxtTotal;
    private EditText mEdtBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bill);
        initViews();

        initListeners();
    }
    private void initViews(){
        mSpnBill = (Spinner) findViewById(R.id.bill_spinner);
        mBtnCalculate = (Button) findViewById(R.id.calculate_Button);
        mEdtBill = (EditText) findViewById(R.id.bill_EditText);
        mTxtTotal = (TextView) findViewById(R.id.total_TextView);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.arraySpinnerBill,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnBill.setAdapter(arrayAdapter);
    }

    private void initListeners(){
        mBtnCalculate.setOnClickListener(this);
        mEdtBill.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.calculate_Button:
                String strbill = mEdtBill.getText().toString();
                float floatbill = Float.parseFloat(strbill);
                mTxtTotal.setText(getString(R.string.vietnam_currency) + (floatbill/2));
                break;
            case R.id.bill_EditText:
                mTxtTotal.setText(R.string.vietnam_currency + 0);
                break;
        }
    }
}
