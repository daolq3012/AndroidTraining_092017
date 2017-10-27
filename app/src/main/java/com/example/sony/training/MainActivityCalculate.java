package com.example.sony.training;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by phong on 10/27/17.
 */

public class MainActivityCalculate extends AppCompatActivity implements View.OnClickListener {
    private EditText editInput;
    private TextView viewResult;
    private Button btnNumber0;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;
    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;
    private Button btnBang;
    private Button btnClearNumber;
    private Button btnClearAll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_widgets_calculator);
        initWidgetCalculate();
        setEventClickViews();
    }

    public void initWidgetCalculate() {
        editInput = (EditText) findViewById(R.id.edit_input);
        viewResult = (TextView) findViewById(R.id.txtViewResult);

        btnNumber0 = (Button) findViewById(R.id.btn0);
        btnNumber1 = (Button) findViewById(R.id.button1);
        btnNumber2 = (Button) findViewById(R.id.button2);
        btnNumber3 = (Button) findViewById(R.id.button3);
        btnNumber4 = (Button) findViewById(R.id.button4);
        btnNumber5 = (Button) findViewById(R.id.button5);
        btnNumber6 = (Button) findViewById(R.id.button6);
        btnNumber7 = (Button) findViewById(R.id.button7);
        btnNumber8 = (Button) findViewById(R.id.button8);
        btnNumber9 = (Button) findViewById(R.id.button9);

        btnCong = (Button) findViewById(R.id.btnCong);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);

        btnClearNumber = (Button) findViewById(R.id.btnClearNumber);
        btnClearAll = (Button) findViewById(R.id.buttonClearAll);
        btnBang = (Button) findViewById(R.id.btnBang);
    }

    public void setEventClickViews() {
        editInput.setOnClickListener(MainActivityCalculate.this);
        viewResult.setOnClickListener(MainActivityCalculate.this);

        btnNumber0.setOnClickListener(MainActivityCalculate.this);
        btnNumber1.setOnClickListener(MainActivityCalculate.this);
        btnNumber2.setOnClickListener(MainActivityCalculate.this);
        btnNumber3.setOnClickListener(MainActivityCalculate.this);
        btnNumber4.setOnClickListener(MainActivityCalculate.this);
        btnNumber5.setOnClickListener(MainActivityCalculate.this);
        btnNumber6.setOnClickListener(MainActivityCalculate.this);
        btnNumber7.setOnClickListener(MainActivityCalculate.this);
        btnNumber8.setOnClickListener(MainActivityCalculate.this);
        btnNumber9.setOnClickListener(MainActivityCalculate.this);

        btnCong.setOnClickListener(MainActivityCalculate.this);
        btnTru.setOnClickListener(MainActivityCalculate.this);
        btnNhan.setOnClickListener(MainActivityCalculate.this);
        btnChia.setOnClickListener(MainActivityCalculate.this);

        btnClearNumber.setOnClickListener(MainActivityCalculate.this);
        btnClearAll.setOnClickListener(MainActivityCalculate.this);
        btnBang.setOnClickListener(MainActivityCalculate.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                editInput.append("0");
                break;
            case R.id.button1:
                editInput.append("1");
                break;
            case R.id.button2:
                editInput.append("2");
                break;
            case R.id.button3:
                editInput.append("3");
                break;
            case R.id.button4:
                editInput.append("4");
                break;
            case R.id.button5:
                editInput.append("5");
                break;
            case R.id.button6:
                editInput.append("6");
                break;
            case R.id.button7:
                editInput.append("7");
                break;
            case R.id.button8:
                editInput.append("8");
                break;
            case R.id.button9:
                editInput.append("9");
                break;
            case R.id.btnCong:
                editInput.append("+");
                break;
            case R.id.btnTru:
                editInput.append("-");
                break;
            case R.id.btnNhan:
                editInput.append("*");
                break;
            case R.id.btnChia:
                editInput.append("/");
                break;
            case R.id.btnClearNumber:
                BaseInputConnection textFileInputConnection = new BaseInputConnection(editInput, true);
                textFileInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.buttonClearAll:
                //TO DO
                editInput.setText("");
                viewResult.setText("");
                break;
            case R.id.btnBang:
                //To do
                DecimalFormat df = new DecimalFormat("###.#######");
                double result = 0;
                addOperation(editInput.getText().toString());
                addNumber(editInput.getText().toString());
                // Thuật toán tính toán biểu thức
                if(arrOperation.size()>=arrNumber.size() ||arrOperation.size()<1){
                    viewResult.setText("Lỗi định dạng");
                }else {
                    for (int i = 0; i < (arrNumber.size() - 1); i++) {
                        switch (arrOperation.get(i)) {
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
                    viewResult.setText(df.format(result) + "");
                }
        }

    }

    //Mảng chứa các phép tính +, - , x, /
    public ArrayList<String> arrOperation;
    //Mảng chứa các số
    public ArrayList<Double> arrNumber;

    //Lấy tất cả các phép tính lưu vào mảng arrOperation
    public int addOperation(String input) {
        arrOperation = new ArrayList<>();

        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '*':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }

    //Lấy tất cả các số lưu vào mảng arrNumber
    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while (matcher.find()) {
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
//    public String deleteNumber(String number) {
//        int lenght = number.length();
//        String del = number.substring(0, lenght - 1) {
//
//        }
//        return del;
//    }
}
