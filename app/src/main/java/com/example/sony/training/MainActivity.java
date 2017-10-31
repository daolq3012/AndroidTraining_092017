package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mCalculatorButton;
    private TextView mEditTotal;
    private EditText mEditbill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buoi4);

        mCalculatorButton = (Button) findViewById(R.id.calculatorButton);
        mEditTotal = (TextView) findViewById(R.id.mEditTotal);
        mEditbill = (EditText) findViewById(R.id.mEditbill);

        mCalculatorButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.calculatorButton:
                String input = mEditbill.getText().toString();
                int so = Integer.parseInt(input)/2;
                mEditTotal.setText(so);
                break;
            case R.id.mTotal:
                Toast.makeText(this,"Click vao total textview",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
