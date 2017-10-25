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
        initView();

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.arraySpinnerBill,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnBill.setAdapter(arrayAdapter);

        initListener();
    }
    private void initView(){
        mSpnBill = (Spinner) findViewById(R.id.bill_spinner);
        mBtnCalculate = (Button) findViewById(R.id.calculate_Button);
        mEdtBill = (EditText) findViewById(R.id.bill_EditText);
        mTxtTotal = (TextView) findViewById(R.id.total_TextView);
    }

    private void initListener(){
        mBtnCalculate.setOnClickListener(this);
        mEdtBill.setOnClickListener(this);
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
