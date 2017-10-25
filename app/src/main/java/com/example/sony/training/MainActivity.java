package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.xml.sax.Parser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner mSpinner;
    private Button mCalculate;
    private TextView mTotal;
    private EditText mBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        //widget
        mCalculate = (Button) findViewById(R.id.btnCalculate);
        mSpinner = (Spinner) findViewById(R.id.Spn);
        mTotal = (TextView) findViewById(R.id.txtTotal1);
        mBill = (EditText) findViewById(R.id.edtBill);

        //Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        //Listen
        mCalculate.setOnClickListener(this);
        mTotal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCalculate:
                String input = mBill.getText().toString();
                float total = Float.parseFloat(input) / 2;
                mTotal.setText("$ "+total);
                break;
        }
    }

}
