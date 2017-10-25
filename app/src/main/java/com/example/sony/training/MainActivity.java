package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button calculatorButton;
    private TextView totalTextView;
    private Spinner spinnerBill;
    private EditText mEditAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_widgets_bill);

        calculatorButton = (Button) findViewById(R.id.calculateButton);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        mEditAmount = (EditText) findViewById(R.id.editAmount);


        //set the listeners
//        calculatorButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Click vao total AAAAAA", Toast.LENGTH_LONG).show();
//            }
//        });
        calculatorButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calculateButton:
                //get the bill amount
                String input = (mEditAmount.getText().toString());
                int so = Integer.parseInt(input);
                int result = so/2;
                totalTextView.setText("$"+result);
                Toast.makeText(this, "Click vao button calculator", Toast.LENGTH_LONG).show();
                break;
            case R.id.totalTextView:
                Toast.makeText(this, "Click vao total textview", Toast.LENGTH_LONG).show();
        }
    }
}
