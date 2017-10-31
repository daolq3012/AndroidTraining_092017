package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTxtDisplay2, mTxtDisplay1;
    private Button mBtnDelete, mBtnDeleteOneRow, mBtnDeleteAll,
            mBtnNegativePositiveNumber, mBtnSqrt, mBtnSeven, mBtnEight,
            mBtnNine, mBtnDevide, mBtnPercent, mBtnFour, mBtnFive, mBtnSix,
            mBtnMulti, mBtnOne, mBtnTwo, mBtnThree, mBtnMinus, mBtnPlus,
            mBtnZero, mBtnComma, mBtnEqual;
    private String strDisplayBefore;
    private String strDisplayBeforeRow2;
    private boolean isDevideClicked = false;
    private boolean isPlusClicked = false;
    private boolean isMinusClicked = false;
    private boolean isPercentClicked = false;
    private boolean isSqrtClicked = false;
    private boolean isMultiClicked = false;
    private float result = 1;
    private float tempResult;
    private float tempNumb = 0;
    private float tempNumbPercent = 0;
    private int countDevide = 0;
    private int countMulti = 0;
    private int countPlus = 0;
    private int countMinus = 0;
    private int countEqualMulti = 0;
    private int countEqualDevide = 0;
    private int countEqualMinus = 0;
    private int countEqualPlus = 0;
    private float resultPercent = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);
        initViews();

        //TODO somebug need fix later
        initListeners();
    }

    private void initViews() {
        mTxtDisplay2 = (TextView) findViewById(R.id.display2_TextView);
        mTxtDisplay1 = (TextView) findViewById(R.id.display1_TextView);
        mBtnDelete = (Button) findViewById(R.id.delete_Button);
        mBtnDeleteOneRow = (Button) findViewById(R.id.deleteOneRow_Button);
        mBtnDeleteAll = (Button) findViewById(R.id.deleteAll_Button);
        mBtnNegativePositiveNumber = (Button) findViewById(R.id.negativePositiveNumber_Button);
        mBtnSqrt = (Button) findViewById(R.id.sqrt_Button);
        mBtnSeven = (Button) findViewById(R.id.seven_Button);
        mBtnEight = (Button) findViewById(R.id.eight_Button);
        mBtnNine = (Button) findViewById(R.id.nine_Button);
        mBtnDevide = (Button) findViewById(R.id.devide_Button);
        mBtnPercent = (Button) findViewById(R.id.percent_Button);
        mBtnFour = (Button) findViewById(R.id.four_Button);
        mBtnFive = (Button) findViewById(R.id.five_Button);
        mBtnSix = (Button) findViewById(R.id.six_Button);
        mBtnMulti = (Button) findViewById(R.id.multi_Button);
        mBtnOne = (Button) findViewById(R.id.one_Button);
        mBtnTwo = (Button) findViewById(R.id.two_Button);
        mBtnThree = (Button) findViewById(R.id.three_Button);
        mBtnMinus = (Button) findViewById(R.id.minus_Button);
        mBtnPlus = (Button) findViewById(R.id.plus_Button);
        mBtnZero = (Button) findViewById(R.id.zero_Button);
        mBtnComma = (Button) findViewById(R.id.comma_Button);
        mBtnEqual = (Button) findViewById(R.id.equal_Button);
    }

    private void initListeners(){
        mTxtDisplay2.setOnClickListener(this);
        mTxtDisplay1.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
        mBtnDeleteOneRow.setOnClickListener(this);
        mBtnDeleteAll.setOnClickListener(this);
        mBtnNegativePositiveNumber.setOnClickListener(this);
        mBtnSqrt.setOnClickListener(this);
        mBtnSeven.setOnClickListener(this);
        mBtnEight.setOnClickListener(this);
        mBtnNine.setOnClickListener(this);
        mBtnFour.setOnClickListener(this);
        mBtnFive.setOnClickListener(this);
        mBtnSix.setOnClickListener(this);
        mBtnOne.setOnClickListener(this);
        mBtnTwo.setOnClickListener(this);
        mBtnThree.setOnClickListener(this);
        mBtnZero.setOnClickListener(this);
        mBtnDevide.setOnClickListener(this);
        mBtnPercent.setOnClickListener(this);
        mBtnEqual.setOnClickListener(this);
        mBtnMulti.setOnClickListener(this);
        mBtnPlus.setOnClickListener(this);
        mBtnMinus.setOnClickListener(this);
        mBtnComma.setOnClickListener(this);
    }

    private void setBooleanFalse(){
        isDevideClicked = false;
        isPlusClicked = false;
        isMinusClicked = false;
        isPercentClicked = false;
        isSqrtClicked = false;
        isMultiClicked = false;
    }

    private void resultWithoutEqual(){
        if (countMulti == 0 && countDevide == 0 && countPlus == 0 && countMinus == 0){
            result = tempNumb;
        }else  if (countDevide != 0 && countMulti ==0 && countPlus == 0 && countMinus == 0){
            if (isPercentClicked){
                tempResult = result;
                tempNumbPercent = result;
                result = tempResult / resultPercent;
            }else{
                tempResult = result;
                result = tempResult / tempNumb;
                mTxtDisplay1.setText(result+"");
            }
        }else if (countDevide == 0 && countMulti != 0 && countPlus == 0 && countMinus == 0){
            if (isPercentClicked){
                tempResult = result;
                tempNumbPercent = result;
                result = tempResult * resultPercent;
            }else {
                tempResult = result;
                result = tempResult * tempNumb;
                mTxtDisplay1.setText(result + "");
            }
        }else if (countDevide == 0 && countMulti == 0 && countPlus != 0 && countMinus == 0) {
            if (isPercentClicked){
                tempResult = result;
                tempNumbPercent = result;
                result = tempResult + resultPercent;
            }else {
                tempResult = result;
                result = tempResult + tempNumb;
                mTxtDisplay1.setText(result + "");
            }
        }else if (countDevide == 0 && countMulti == 0 && countPlus == 0 && countMinus != 0) {
            if (isPercentClicked){
                tempResult = result;
                tempNumbPercent = result;
                result = tempResult - resultPercent;
                Toast.makeText(this, tempResult+" " + resultPercent, Toast.LENGTH_SHORT).show();
            }else {
                tempResult = result;
                result = tempResult - tempNumb;
                mTxtDisplay1.setText(result + "");
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.delete_Button:
                String strDelete = mTxtDisplay1.getText().toString();
                String subStrDelete = strDelete.substring(0,strDelete.length()-1);
                mTxtDisplay1.setText(subStrDelete);
                break;
            case R.id.deleteOneRow_Button:
                mTxtDisplay1.setText("0");
                tempNumb = 0;
                countDevide = 0;
                countMulti = 0;
                countPlus = 0;
                countMinus = 0;
                break;
            case R.id.deleteAll_Button:
                mTxtDisplay2.setText("");
                mTxtDisplay1.setText("0");
                result = 1;
                tempNumb = 0;
                countDevide = 0;
                countMulti = 0;
                countPlus = 0;
                countMinus = 0;
                countEqualMulti = 0;
                countEqualDevide = 0;
                countEqualMinus = 0;
                countEqualPlus = 0;
                setBooleanFalse();
                break;
            case R.id.negativePositiveNumber_Button:
                String strTemp = mTxtDisplay1.getText().toString();
                if (!strTemp.contains("-")){
                    mTxtDisplay1.setText("-"+strTemp);
                } else {
                    mTxtDisplay1.setText(strTemp.substring(1,strTemp.length()));
                }
                break;
            case R.id.sqrt_Button:
                isSqrtClicked = true;
                String strTemp2 = mTxtDisplay1.getText().toString();
                mTxtDisplay2.setText("sqrt("+strTemp2+")");
                if (!strTemp2.contains("-")){
                    float sqrt = Float.parseFloat(strTemp2);
                    double result = Math.sqrt(sqrt);
                    mTxtDisplay1.setText(result+"");
                } else {
                    mTxtDisplay1.setText("Invalid input");
                }
                break;
            case R.id.seven_Button:
                strDisplayBefore = mTxtDisplay1.getText().toString();
                if (isDevideClicked || isSqrtClicked || isMultiClicked || isMinusClicked){
                    setBooleanFalse();
                    String strDisplay = "7";
                    mTxtDisplay1.setText(strDisplay);
                } else {
                    if (strDisplayBefore.equals("0")){
                        String strDisplay = "7";
                        mTxtDisplay1.setText(strDisplay);
                    } else{
                        String strDisplay = strDisplayBefore + 7;
                        mTxtDisplay1.setText(strDisplay);
                    }
                }
                break;
            case R.id.eight_Button:
                strDisplayBefore = mTxtDisplay1.getText().toString();
                if (isDevideClicked || isSqrtClicked || isMultiClicked || isMinusClicked){
                    setBooleanFalse();
                    String strDisplay = "8";
                    mTxtDisplay1.setText(strDisplay);
                } else {
                    if (strDisplayBefore.equals("0")) {
                        String strDisplay = "8";
                        mTxtDisplay1.setText(strDisplay);
                    } else {
                        String strDisplay = strDisplayBefore + 8;
                        mTxtDisplay1.setText(strDisplay);
                    }
                }
                break;
            case R.id.nine_Button:
                strDisplayBefore = mTxtDisplay1.getText().toString();
                if (isDevideClicked || isSqrtClicked || isMultiClicked || isMinusClicked){
                    setBooleanFalse();
                    String strDisplay = "9";
                    mTxtDisplay1.setText(strDisplay);
                } else {
                    if (strDisplayBefore.equals("0")) {
                        String strDisplay = "9";
                        mTxtDisplay1.setText(strDisplay);
                    } else {
                        String strDisplay = strDisplayBefore + 9;
                        mTxtDisplay1.setText(strDisplay);
                    }
                }
                break;
            case R.id.four_Button:
                strDisplayBefore = mTxtDisplay1.getText().toString();
                if (isDevideClicked || isSqrtClicked || isMultiClicked || isMinusClicked){
                    setBooleanFalse();
                    String strDisplay = "4";
                    mTxtDisplay1.setText(strDisplay);
                } else {
                    if (strDisplayBefore.equals("0")) {
                        String strDisplay = "4";
                        mTxtDisplay1.setText(strDisplay);
                    } else {
                        String strDisplay = strDisplayBefore + 4;
                        mTxtDisplay1.setText(strDisplay);
                    }
                }
                break;
            case R.id.five_Button:
                strDisplayBefore = mTxtDisplay1.getText().toString();
                if (isDevideClicked || isSqrtClicked || isMultiClicked || isMinusClicked){
                    setBooleanFalse();
                    String strDisplay = "5";
                    mTxtDisplay1.setText(strDisplay);
                } else {
                    if (strDisplayBefore.equals("0")) {
                        String strDisplay = "5";
                        mTxtDisplay1.setText(strDisplay);
                    } else {
                        String strDisplay = strDisplayBefore + 5;
                        mTxtDisplay1.setText(strDisplay);
                    }
                }
                break;
            case R.id.six_Button:
                strDisplayBefore = mTxtDisplay1.getText().toString();
                if (isDevideClicked || isSqrtClicked || isMultiClicked || isMinusClicked){
                    setBooleanFalse();
                    String strDisplay = "6";
                    mTxtDisplay1.setText(strDisplay);
                } else {
                    if (strDisplayBefore.equals("0")) {
                        String strDisplay = "6";
                        mTxtDisplay1.setText(strDisplay);
                    } else {
                        String strDisplay = strDisplayBefore + 6;
                        mTxtDisplay1.setText(strDisplay);
                    }
                }
                break;
            case R.id.one_Button:
                strDisplayBefore = mTxtDisplay1.getText().toString();
                if (isDevideClicked || isSqrtClicked || isMultiClicked || isMinusClicked){
                    setBooleanFalse();
                    String strDisplay = "1";
                    mTxtDisplay1.setText(strDisplay);
                } else {
                    if (strDisplayBefore.equals("0")) {
                        String strDisplay = "1";
                        mTxtDisplay1.setText(strDisplay);
                    } else {
                        String strDisplay = strDisplayBefore + 1;
                        mTxtDisplay1.setText(strDisplay);
                    }
                }
                break;
            case R.id.two_Button:
                strDisplayBefore = mTxtDisplay1.getText().toString();
                if (isDevideClicked || isSqrtClicked || isMultiClicked || isMinusClicked){
                    setBooleanFalse();
                    String strDisplay = "2";
                    mTxtDisplay1.setText(strDisplay);
                } else {
                    if (strDisplayBefore.equals("0")) {
                        String strDisplay = "2";
                        mTxtDisplay1.setText(strDisplay);
                    } else {
                        String strDisplay = strDisplayBefore + 2;
                        mTxtDisplay1.setText(strDisplay);
                    }
                }
                break;
            case R.id.three_Button:
                strDisplayBefore = mTxtDisplay1.getText().toString();
                if (isDevideClicked || isSqrtClicked || isMultiClicked || isMinusClicked){
                    setBooleanFalse();
                    String strDisplay = "3";
                    mTxtDisplay1.setText(strDisplay);
                } else {
                    if (strDisplayBefore.equals("0")) {
                        String strDisplay = "3";
                        mTxtDisplay1.setText(strDisplay);
                    } else {
                        String strDisplay = strDisplayBefore + 3;
                        mTxtDisplay1.setText(strDisplay);
                    }
                }
                break;
            case R.id.zero_Button:
                strDisplayBefore = mTxtDisplay1.getText().toString();
                if (isDevideClicked || isSqrtClicked || isMultiClicked || isMinusClicked){
                    setBooleanFalse();
                    String strDisplay = "0";
                    mTxtDisplay1.setText(strDisplay);
                } else {
                    if (strDisplayBefore.equals("0")) {
                        String strDisplay = "0";
                        mTxtDisplay1.setText(strDisplay);
                    } else {
                        String strDisplay = strDisplayBefore + 0;
                        mTxtDisplay1.setText(strDisplay);
                    }
                }
                break;
            case R.id.devide_Button:
                isDevideClicked = true;
                countEqualMulti = 0;
                countEqualPlus = 0;
                countEqualMinus = 0;
                strDisplayBefore = mTxtDisplay1.getText().toString();
                strDisplayBeforeRow2 = mTxtDisplay2.getText().toString();
                if (isPercentClicked){
                    String strDisplay = strDisplayBeforeRow2 + " / ";
                    mTxtDisplay2.setText(strDisplay);
                    mTxtDisplay1.setText(result+"");
                }else{
                    String strDisplay = strDisplayBeforeRow2 + strDisplayBefore + " / ";
                    mTxtDisplay2.setText(strDisplay);
                }
                tempNumb = Float.parseFloat(strDisplayBefore);
                tempNumbPercent = Float.parseFloat(strDisplayBefore);
                if (countPlus > 0 || countMinus > 0 || countMulti > 0 ){
                    resultWithoutEqual();
                    countPlus = 0;
                    countMinus = 0;
                    countMulti = 0;
                }else{
                    resultWithoutEqual();
                }
                countEqualDevide++;
                countDevide++;
                break;
            case R.id.percent_Button:
                isPercentClicked = true;
                strDisplayBefore = mTxtDisplay1.getText().toString();
                strDisplayBeforeRow2 = mTxtDisplay2.getText().toString();
                float tempNumb2 = Float.parseFloat(strDisplayBefore);
                if (!strDisplayBeforeRow2.equals("")){
                    resultPercent = (tempNumbPercent * tempNumb2) / 100;
                    String strDisplay2 = strDisplayBeforeRow2 + resultPercent;
                    mTxtDisplay2.setText(strDisplay2);
                    mTxtDisplay1.setText(resultPercent+"");
                }else{
                    mTxtDisplay2.setText("0");
                    mTxtDisplay1.setText("0");
                }
                resultWithoutEqual();
//                Toast.makeText(this, result+" percentrs", Toast.LENGTH_SHORT).show();
                break;
            case R.id.multi_Button:
                isMultiClicked = true;
                countEqualPlus = 0;
                countEqualDevide = 0;
                countEqualMinus = 0;
                strDisplayBefore = mTxtDisplay1.getText().toString();
                strDisplayBeforeRow2 = mTxtDisplay2.getText().toString();
                if (isPercentClicked){
                    String strDisplay = strDisplayBeforeRow2 + " * ";
                    mTxtDisplay2.setText(strDisplay);
                    mTxtDisplay1.setText(result+"");
                }else{
                    String strDisplay = strDisplayBeforeRow2 + strDisplayBefore + " * ";
                    mTxtDisplay2.setText(strDisplay);
                }
                tempNumb = Float.parseFloat(strDisplayBefore);
                tempNumbPercent = Float.parseFloat(strDisplayBefore);
                if (countDevide > 0 || countMinus > 0 || countPlus > 0 ){
                    resultWithoutEqual();
                    countDevide = 0;
                    countMinus = 0;
                    countPlus = 0;
                }else{
                    resultWithoutEqual();
                }
                countEqualMulti++;
                countMulti++;
                break;
            case R.id.plus_Button:
                isMultiClicked = true;
                countEqualMulti = 0;
                countEqualDevide = 0;
                countEqualMinus = 0;
                strDisplayBefore = mTxtDisplay1.getText().toString();
                strDisplayBeforeRow2 = mTxtDisplay2.getText().toString();
                if (isPercentClicked){
                    String strDisplay = strDisplayBeforeRow2 + " + ";
                    mTxtDisplay2.setText(strDisplay);
                    mTxtDisplay1.setText(result+"");
                }else{
                    String strDisplay = strDisplayBeforeRow2 + strDisplayBefore + " + ";
                    mTxtDisplay2.setText(strDisplay);
                }
                tempNumb = Float.parseFloat(strDisplayBefore);
                tempNumbPercent = Float.parseFloat(strDisplayBefore);
                if (countDevide > 0 || countMinus > 0 || countMulti > 0 ){
                    resultWithoutEqual();
                    countDevide = 0;
                    countMinus = 0;
                    countMulti = 0;
                }else{
                    resultWithoutEqual();
                }
                countEqualPlus++;
                countPlus++;
                break;
            case R.id.minus_Button:
                isMinusClicked = true;
                countEqualMulti = 0;
                countEqualDevide = 0;
                countEqualPlus = 0;
                strDisplayBefore = mTxtDisplay1.getText().toString();
                strDisplayBeforeRow2 = mTxtDisplay2.getText().toString();
                if (isPercentClicked){
                    String strDisplay = strDisplayBeforeRow2 + " - ";
                    mTxtDisplay2.setText(strDisplay);
                    mTxtDisplay1.setText(result+"");
                }else{
                    String strDisplay = strDisplayBeforeRow2 + strDisplayBefore + " - ";
                    mTxtDisplay2.setText(strDisplay);
                }
                tempNumb = Float.parseFloat(strDisplayBefore);
                tempNumbPercent = Float.parseFloat(strDisplayBefore);
                if (countDevide > 0 || countPlus > 0 || countMulti > 0 ){
                    resultWithoutEqual();
                    countDevide = 0;
                    countPlus = 0;
                    countMulti = 0;
                }else{
                    resultWithoutEqual();
                }
                countEqualMinus++;
                countMinus++;
                break;
            case R.id.equal_Button:
                strDisplayBefore = mTxtDisplay1.getText().toString();
                tempNumb = Float.parseFloat(strDisplayBefore);
                if (countEqualDevide != 0){
                    if (isPercentClicked){
                        mTxtDisplay1.setText((result)+"");
                    }else{
                        mTxtDisplay1.setText((result/tempNumb)+"");
                    }
                }else if (countEqualMulti != 0 ){
                    if (isPercentClicked){
                        mTxtDisplay1.setText((result)+"");
                    }else {
                        mTxtDisplay1.setText((result * tempNumb) + "");
                    }
                }else if (countEqualPlus != 0 ){
                    if (isPercentClicked){
                        mTxtDisplay1.setText((result)+"");
                    }else {
                        mTxtDisplay1.setText((result + tempNumb) + "");
                    }
                }else if (countEqualMinus != 0 ){
                    if (isPercentClicked){
                        mTxtDisplay1.setText((result)+"");
                    }else {
                        mTxtDisplay1.setText((result - tempNumb) + "");
                    }
                }
                mTxtDisplay2.setText("");
                setBooleanFalse();
                break;
            case R.id.comma_Button:
                strDisplayBefore = mTxtDisplay1.getText().toString();
                if (isDevideClicked || isSqrtClicked || isMultiClicked || isMinusClicked){
                    setBooleanFalse();
                    String strDisplay = "0.";
                    mTxtDisplay1.setText(strDisplay);
                } else {
                    if (strDisplayBefore.equals("0")) {
                        String strDisplay = "0.";
                        mTxtDisplay1.setText(strDisplay);
                    } else {
                        String strDisplay = strDisplayBefore + ".";
                        mTxtDisplay1.setText(strDisplay);
                    }
                }
                break;
        }
    }
}