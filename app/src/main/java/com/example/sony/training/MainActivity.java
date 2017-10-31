package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnNumaber0;
    private Button mBtnNumaber1;
    private Button mBtnNumaber2;
    private Button mBtnNumaber3;
    private Button mBtnNumaber4;
    private Button mBtnNumaber5;
    private Button mBtnNumaber6;
    private Button mBtnNumaber7;
    private Button mBtnNumaber8;
    private Button mBtnNumaber9;
    private Button mBtnDivide;
    private Button mBtnPlus;
    private Button mBtnSub;
    private Button mBtnMultiplication;
    private Button mBtnPercent;
    private Button mBtnDot;
    private Button mBtnEquals;
    private Button mBtnClear;
    private Button mBtnBackspace;

    private TextView mTxtResult;
    private TextView mTxtDisplay;

    private String input = "";
    private String display = "";
    private boolean newWave;
    private int result;
    private int number1;
    private int number2;
    private int flag = 1;
    private char previousCalculation = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);

        addControl();
        addEvent();
    }

    private void addControl() {
        mBtnNumaber0 = (Button) findViewById(R.id.btnNumber0);
        mBtnNumaber1 = (Button) findViewById(R.id.btnNumber1);
        mBtnNumaber2 = (Button) findViewById(R.id.btnNumber2);
        mBtnNumaber3 = (Button) findViewById(R.id.btnNumber3);
        mBtnNumaber4 = (Button) findViewById(R.id.btnNumber4);
        mBtnNumaber5 = (Button) findViewById(R.id.btnNumber5);
        mBtnNumaber6 = (Button) findViewById(R.id.btnNumber6);
        mBtnNumaber7 = (Button) findViewById(R.id.btnNumber7);
        mBtnNumaber8 = (Button) findViewById(R.id.btnNumber8);
        mBtnNumaber9 = (Button) findViewById(R.id.btnNumber9);

        mBtnDivide = (Button) findViewById(R.id.btnDivide);
        mBtnPlus = (Button) findViewById(R.id.btnPlus);
        mBtnSub = (Button) findViewById(R.id.btnSub);
        mBtnMultiplication = (Button) findViewById(R.id.btnMultiplication);
        mBtnPercent = (Button) findViewById(R.id.btnPercent);
        mBtnDot = (Button) findViewById(R.id.btnDot);
        mBtnEquals = (Button) findViewById(R.id.btnEquals);
        mBtnBackspace = (Button) findViewById(R.id.btnBackspace);

        mBtnClear = (Button) findViewById(R.id.btnClear);

        mTxtDisplay = (TextView) findViewById(R.id.txtDisplay);
        mTxtResult = (TextView) findViewById(R.id.txtResult);

        mTxtDisplay.setText(" ");
    }

    private void addEvent() {
        mBtnNumaber0.setOnClickListener(this);
        mBtnNumaber1.setOnClickListener(this);
        mBtnNumaber2.setOnClickListener(this);
        mBtnNumaber3.setOnClickListener(this);
        mBtnNumaber4.setOnClickListener(this);
        mBtnNumaber5.setOnClickListener(this);
        mBtnNumaber6.setOnClickListener(this);
        mBtnNumaber7.setOnClickListener(this);
        mBtnNumaber8.setOnClickListener(this);
        mBtnNumaber9.setOnClickListener(this);

        mBtnPlus.setOnClickListener(this);
        mBtnSub.setOnClickListener(this);
        mBtnMultiplication.setOnClickListener(this);
        mBtnDivide.setOnClickListener(this);

        mBtnClear.setOnClickListener(this);
        mBtnEquals.setOnClickListener(this);
        mBtnBackspace.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNumber0:
                if (mTxtResult.getText().toString().equals("0")) {
                    input = "";
                    mTxtResult.setText("0");
                } else {
                    enterNumber(mBtnNumaber0);
                }
                break;
            case R.id.btnNumber1:
                enterNumber(mBtnNumaber1);
                break;
            case R.id.btnNumber2:
                enterNumber(mBtnNumaber2);
                break;
            case R.id.btnNumber3:
                enterNumber(mBtnNumaber3);
                break;
            case R.id.btnNumber4:
                enterNumber(mBtnNumaber4);
                break;
            case R.id.btnNumber5:
                enterNumber(mBtnNumaber5);
                break;
            case R.id.btnNumber6:
                enterNumber(mBtnNumaber6);
                break;
            case R.id.btnNumber7:
                enterNumber(mBtnNumaber7);
                break;
            case R.id.btnNumber8:
                enterNumber(mBtnNumaber8);
                break;
            case R.id.btnNumber9:
                enterNumber(mBtnNumaber9);
                break;
            case R.id.btnClear:
                input = "";
                mTxtResult.setText("0");
                mTxtDisplay.setText(" ");
                newWave = true;
                result = 0;
                number1 = 0;
                number2 = 0;
                previousCalculation = ' ';
                break;

            case R.id.btnPlus:
                calculateInput(mBtnPlus);
                previousCalculation = '+';
                break;
            case R.id.btnSub:
                calculateInput(mBtnSub);
                previousCalculation = '-';
                break;
            case R.id.btnMultiplication:
                calculateInput(mBtnMultiplication);
                previousCalculation = '*';
                break;
            case R.id.btnDivide:
                calculateInput(mBtnDivide);
                previousCalculation = '/';
                break;
            case R.id.btnEquals:
                if (flag == 1) {
                    number1 = Integer.parseInt(mTxtResult.getText().toString());
                    flag = 2;
                } else {
                    number2 = Integer.parseInt(mTxtResult.getText().toString());
                    flag = 1;
                }
                switch (display.charAt(display.length() - 1)) {
                    case '+':
                        result = number1 + number2;
                        mTxtResult.setText(result + "");
                        number1 = result;
                        if (flag == 1) {
                            number1 = result;
                        } else {
                            number2 = result;
                        }
                        break;
                    case '-':
                        if (flag == 2) {
                            result = number2 - number1;
                        } else {
                            result = number1 - number2;
                        }
                        mTxtResult.setText(result + "");
                        number1 = result;
                        if (flag == 1) {
                            number1 = result;
                        } else {
                            number2 = result;
                        }
                        break;
                    case '*':
                        result = number1 * number2;
                        mTxtResult.setText(result + "");
                        number1 = result;
                        if (flag == 1) {
                            number1 = result;
                        } else {
                            number2 = result;
                        }
                        break;
                    case '/':
                        if (flag == 2) {
                            result = number2 / number1;
                        } else {
                            result = number1 / number2;
                        }
                        mTxtResult.setText(result + "");
                        number1 = result;
                        if (flag == 1) {
                            number1 = result;
                        } else {
                            number2 = result;
                        }
                        break;
                }
                mTxtDisplay.setText(" ");
                input = mTxtResult.getText().toString();
                newWave = true;
                previousCalculation = '=';
                break;
            case R.id.btnBackspace:
                if(newWave && (input.length() > 1) && (previousCalculation != '=')) {
                    input = input.substring(0,input.length()-1);
                    mTxtResult.setText(input);
                } else if(input.length() == 1) {
                    input = "";
                    mTxtResult.setText("0");
                }
        }
    }

    private void enterNumber(Button button) {
        if(previousCalculation != '=') {
            input = input.concat(button.getText().toString());
            mTxtResult.setText(input);
            newWave = true;
        } else {
            input = "";
            input = input.concat(button.getText().toString());
            mTxtResult.setText(input);
            newWave = true;
        }
    }

    private void calculateInput(Button button) {
        display = mTxtDisplay.getText().toString();
        if (!newWave) {
            display = display.substring(0, display.length() - 1);
            display = display.concat(button.getText().toString());
            mTxtDisplay.setText(display);
            input = "";
            newWave = false;
        } else {
            if (flag == 1) {
                number1 = Integer.parseInt(mTxtResult.getText().toString());
                flag = 2;
            } else {
                number2 = Integer.parseInt(mTxtResult.getText().toString());
                flag = 1;
            }
            switch (previousCalculation) {
                case '+':
                    result = number1 + number2;
                    mTxtResult.setText(result + "");
                    if (flag == 2) {
                        number1 = result;
                    } else {
                        number2 = result;
                    }
                    break;
                case '-':
                    if (flag == 1) {
                        result = number1 - number2;
                    } else {
                        result = number2 - number1;
                    }
                    mTxtResult.setText(result + "");
                    if (flag == 2) {
                        number1 = result;
                    } else {
                        number2 = result;
                    }
                    break;
                case '*':
                    result = number1 * number2;
                    mTxtResult.setText(result + "");
                    if (flag == 2) {
                        number1 = result;
                    } else {
                        number2 = result;
                    }
                    break;
                case '/':
                    if (flag == 1) {
                        result = number1 / number2;
                    } else {
                        result = number2 / number1;
                    }
                    mTxtResult.setText(result + "");
                    if (flag == 2) {
                        number1 = result;
                    } else {
                        number2 = result;
                    }
                    break;
            }
            display = display.concat(input.concat(button.getText().toString()));
            mTxtDisplay.setText(display);
            input = "";
            newWave = false;
        }
    }
}
