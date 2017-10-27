package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;

    private Button number0;
    private Button number1;
    private Button number2;
    private Button number3;
    private Button number4;
    private Button number5;
    private Button number6;
    private Button number7;
    private Button number8;
    private Button number9;

    private Button cong;
    private Button tru;
    private Button nhan;
    private Button chia;

    private Button cham;
    private Button tinh;
    private Button clear;
    private Button allClear;

    float so1,so2 ;
    String tinhToan,output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);

        editText = (EditText) findViewById(R.id.editText);

        number0 = (Button) findViewById(R.id.number0);
        number1 = (Button) findViewById(R.id.number1);
        number2 = (Button) findViewById(R.id.number2);
        number3 = (Button) findViewById(R.id.number3);
        number4 = (Button) findViewById(R.id.number4);
        number5 = (Button) findViewById(R.id.number5);
        number6 = (Button) findViewById(R.id.number6);
        number7 = (Button) findViewById(R.id.number7);
        number8 = (Button) findViewById(R.id.number8);
        number9 = (Button) findViewById(R.id.number9);

        cong = (Button) findViewById(R.id.cong);
        tru = (Button) findViewById(R.id.tru);
        nhan = (Button) findViewById(R.id.nhan);
        chia = (Button) findViewById(R.id.chia);

        cham = (Button) findViewById(R.id.cham);
        tinh = (Button) findViewById(R.id.tinh);
        clear = (Button) findViewById(R.id.clear);
        allClear = (Button) findViewById(R.id.allClear);

        number0.setOnClickListener(this);
        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
        number5.setOnClickListener(this);
        number6.setOnClickListener(this);
        number7.setOnClickListener(this);
        number8.setOnClickListener(this);
        number9.setOnClickListener(this);

        cong.setOnClickListener(this);
        tru.setOnClickListener(this);
        nhan.setOnClickListener(this);
        chia.setOnClickListener(this);

        cham.setOnClickListener(this);
        tinh.setOnClickListener(this);
//        clear.setOnClickListener(this);
        allClear.setOnClickListener(this);
    }

    private void TinhToan(){
        so1 = Float.parseFloat(editText.getText().toString());
        output = "0";
        editText.setText("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.number0:
                editText.append("0");
                break;
            case R.id.number1:
                editText.append("1");
                break;
            case R.id.number2:
                editText.append("2");
                break;
            case R.id.number3:
                editText.append("3");
                break;
            case R.id.number4:
                editText.append("4");
                break;
            case R.id.number5:
                editText.append("5");
                break;
            case R.id.number6:
                editText.append("6");
                break;
            case R.id.number7:
                editText.append("7");
                break;
            case R.id.number8:
                editText.append("8");
                break;
            case R.id.number9:
                editText.append("9");
                break;
            case R.id.cong:
                tinhToan = "+";
                TinhToan();
                break;
            case R.id.tru:
                tinhToan = "-";
                TinhToan();
                break;
            case R.id.nhan:
                tinhToan = "*";
                TinhToan();
                break;
            case R.id.chia:
                tinhToan = "/";
                TinhToan();
                break;
            case R.id.cham:
                editText.append(".");
                break;

            case R.id.tinh:
                Float ketqua = null;
                so2 = Float.parseFloat(editText.getText().toString());
                if (tinhToan == "+"){
                    ketqua = so1 + so2;
                }
                if (tinhToan == "-"){
                    ketqua = so1 - so2;
                }
                if (tinhToan == "*"){
                    ketqua = so1 * so2;
                }
                if (tinhToan == "/"){
                    ketqua = so1 / so2;
                }
                editText.setText(String.valueOf(ketqua));
                so1 = 0.0f;
                so2 = 0.0f;
                output = "0";
                break;

            case R.id.allClear:
                editText.setText("");
                so1 = 0.0f;
                so2 = 0.0f;
                break;

            default:
                if (output.equals("0")){
                    output = "";
                }
                output += ((Button)v).getText().toString();
                editText.setText(output);
        }
    }
}
