package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button calculateButton;
    private TextView mTxtTotalNumber;
    private EditText mEdtBillAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        calculateButton = (Button) findViewById(R.id.calculateButton);
        mTxtTotalNumber = (TextView) findViewById(R.id.txtTotalNumber);
        mEdtBillAmount = (EditText) findViewById(R.id.edtBillAmount);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String total = mEdtBillAmount.getText().toString();
                float result = Float.parseFloat(total);
                mTxtTotalNumber.setText("$"+(result/2));
                Toast.makeText(MainActivity.this,"Click vao button calculate",Toast.LENGTH_LONG).show();
            }
        });
    }

}
