package com.example.sony.training;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by phong on 10/24/17.
 */

public class TipRadioActivity extends AppCompatActivity{
    private EditText mEditTotal;
    private TextView mTxtTotal;
    private EditText mEditPerson;
    private TextView mTxtPerson;
    private Spinner mSpinner_SplitBill;
    private Button mButtonApply;
    private RadioButton mRadioNone;
    private RadioButton mRadioTip;
    private RadioButton mRadioBill;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_widgets_radiobutton);
        mEditTotal = (EditText) findViewById(R.id.editTotal);
        mTxtTotal = (TextView) findViewById(R.id.txtTotal);
        mSpinner_SplitBill = (Spinner) findViewById(R.id.spinner_SplitBill);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_SplitBill, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner_SplitBill.setAdapter(adapter);

    }
}
