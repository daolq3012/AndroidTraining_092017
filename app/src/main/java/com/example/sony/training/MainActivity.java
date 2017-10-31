package com.example.sony.training;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;

    private Button zeroNumberButton;
    private Button oneNumberButton;
    private Button twoNumberButton;
    private Button threeNumberButton;
    private Button fourNumberButton;
    private Button fiveNumberButton;
    private Button sixNumberButton;
    private Button sevenNumberButton;
    private Button eightNumberButton;
    private Button nineNumberButton;

    private Button addButton;
    private Button subButton;
    private Button multipleButton;
    private Button divButton;

    private Button dotButton;
    private Button byButton;
    private Button allClear;

    float so1,so2 ;
    String tinhToan,output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);

        initViews();

        initEvents();
    }

    private void initViews() {
        editText = (EditText) findViewById(R.id.editText);

        zeroNumberButton = (Button) findViewById(R.id.number0);
        oneNumberButton = (Button) findViewById(R.id.number1);
        twoNumberButton = (Button) findViewById(R.id.number2);
        threeNumberButton = (Button) findViewById(R.id.number3);
        fourNumberButton = (Button) findViewById(R.id.number4);
        fiveNumberButton = (Button) findViewById(R.id.number5);
        sixNumberButton = (Button) findViewById(R.id.number6);
        sevenNumberButton = (Button) findViewById(R.id.number7);
        eightNumberButton = (Button) findViewById(R.id.number8);
        nineNumberButton = (Button) findViewById(R.id.number9);

        addButton = (Button) findViewById(R.id.cong);
        subButton = (Button) findViewById(R.id.tru);
        multipleButton = (Button) findViewById(R.id.nhan);
        divButton = (Button) findViewById(R.id.chia);

        dotButton = (Button) findViewById(R.id.cham);
        byButton = (Button) findViewById(R.id.tinh);
        allClear = (Button) findViewById(R.id.allClear);
    }

    private void initEvents(){
        zeroNumberButton.setOnClickListener(this);
        oneNumberButton.setOnClickListener(this);
        twoNumberButton.setOnClickListener(this);
        threeNumberButton.setOnClickListener(this);
        fourNumberButton.setOnClickListener(this);
        fiveNumberButton.setOnClickListener(this);
        sixNumberButton.setOnClickListener(this);
        sevenNumberButton.setOnClickListener(this);
        eightNumberButton.setOnClickListener(this);
        nineNumberButton.setOnClickListener(this);

        addButton.setOnClickListener(this);
        subButton.setOnClickListener(this);
        multipleButton.setOnClickListener(this);
        divButton.setOnClickListener(this);

        dotButton.setOnClickListener(this);
        byButton.setOnClickListener(this);
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
                if (tinhToan.equals("+")){
                    ketqua = so1 + so2;
                }
                if (tinhToan.equals("-")){
                    ketqua = so1 - so2;
                }
                if (tinhToan.equals("*")){
                    ketqua = so1 * so2;
                }
                if (tinhToan.equals("/")){
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
