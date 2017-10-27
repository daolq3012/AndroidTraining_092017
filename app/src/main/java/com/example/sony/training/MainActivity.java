package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText tvInput;
    private TextView tvResult;

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;

    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;

    private Button btnBang;
    private Button btnCham;
    private Button btnClear;
    private Button btnClearAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_widget_calculator);
        initWidgets();
        setEventClick();


    }

    public void initWidgets() {
        tvInput = (EditText) findViewById(R.id.txtInput);
        tvResult = (TextView) findViewById(R.id.txtResult);

        btn0 = (Button) findViewById(R.id.btn111111);
        btn1 = (Button) findViewById(R.id.btn11111);
        btn2 = (Button) findViewById(R.id.btn22222);
        btn3 = (Button) findViewById(R.id.btn33333);
        btn4 = (Button) findViewById(R.id.btn1111);
        btn5 = (Button) findViewById(R.id.btn2222);
        btn6 = (Button) findViewById(R.id.btn3333);
        btn7 = (Button) findViewById(R.id.btn111);
        btn8 = (Button) findViewById(R.id.btn222);
        btn9 = (Button) findViewById(R.id.btn333);

        btnCong = (Button) findViewById(R.id.btn333333);
        btnTru = (Button) findViewById(R.id.btn44444);
        btnNhan = (Button) findViewById(R.id.btn4444);
        btnChia = (Button) findViewById(R.id.btn444);

        btnCham = (Button) findViewById(R.id.btn222222);
        btnClear = (Button) findViewById(R.id.btn33);
        btnClearAll = (Button) findViewById(R.id.btn22);
        btnBang = (Button) findViewById(R.id.btnbang);
    }

    public void setEventClick() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);

        btnCham.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);
        btnBang.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn111111:
                tvInput.append("0");
                break;
            case R.id.btn11111:
                tvInput.append("1");
                break;
            case R.id.btn22222:
                tvInput.append("2");
                break;
            case R.id.btn33333:
                tvInput.append("3");
                break;
            case R.id.btn1111:
                tvInput.append("4");
                break;
            case R.id.btn2222:
                tvInput.append("5");
                break;
            case R.id.btn3333:
                tvInput.append("6");
                break;
            case R.id.btn111:
                tvInput.append("7");
                break;
            case R.id.btn222:
                tvInput.append("8");
                break;
            case R.id.btn333:
                tvInput.append("9");
                break;
            case R.id.btn333333:
                tvInput.append("+");
                break;
            case R.id.btn44444:
                tvInput.append("-");
                break;
            case R.id.btn4444:
                tvInput.append("*");
                break;
            case R.id.btn444:
                tvInput.append("/");
                break;
            case R.id.btn222222:
                tvInput.append(".");
                break;
            case R.id.btn33:
                BaseInputConnection texFieldInputConnection = new BaseInputConnection(tvInput, true);
                texFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btn22:
                tvInput.setText(null);
                tvResult.setText(null);
                break;
            case R.id.btnbang:
                DecimalFormat df = new DecimalFormat("###.####");
                double result = 0;
                addPheptinh(tvInput.getText().toString());
                addNumber(tvInput.getText().toString());
                //cách tính + - * /
                if (arrPheptinh.size() >= arrNumber.size()) {
                    tvResult.setText("Lỗi định dạng");
                } else {
                    for (int i = 0; i < (arrNumber.size() - 1); i++) {
                        switch (arrPheptinh.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = arrNumber.get(i) + arrNumber.get(i + 1);
                                } else {
                                    result = result + arrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = arrNumber.get(i) - arrNumber.get(i + 1);
                                } else {
                                    result = result - arrNumber.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    result = arrNumber.get(i) * arrNumber.get(i + 1);
                                } else {
                                    result = result * arrNumber.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    result = arrNumber.get(i) / arrNumber.get(i + 1);
                                } else {
                                    result = result / arrNumber.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    tvResult.setText(df.format(result) + "");
                }
            break;
        }

    }

    public ArrayList<String> arrPheptinh;
    public ArrayList<Double> arrNumber;

    public int addPheptinh(String input) {
        arrPheptinh = new ArrayList<>();
        char[] cArr = input.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            switch (cArr[i]) {
                case '+':
                    arrPheptinh.add(cArr[i] + "");
                    break;
                case '-':
                    arrPheptinh.add(cArr[i] + "");
                    break;
                case '*':
                    arrPheptinh.add(cArr[i] + "");
                    break;
                case '/':
                    arrPheptinh.add(cArr[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }

    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while (matcher.find()) {
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
}
