package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class captolayter extends AppCompatActivity implements View.OnClickListener {



    private Button chin;
    private Button tam;
    private Button bay;
    private  Button sau;
    private Button nam;
    private Button bon;
    private Button ba;
    private Button hai;
    private Button mot;
    private Button cong;
    private Button tru;
    private Button nhan;
    private Button chia;
    private Button bang;
    private EditText mhinh;
    private TextView ketqua;
    private Button c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captolayter);
        chin = (Button) findViewById(R.id.chin);
        tam= (Button) findViewById(R.id.tam);
        bay = (Button) findViewById(R.id.bay);
        nam = (Button) findViewById(R.id.sau);
        bon = (Button) findViewById(R.id.nam);
        ba = (Button) findViewById(R.id.bon);
        hai = (Button) findViewById(R.id.hai);
        mot= (Button) findViewById(R.id.mot);
        cong = (Button) findViewById(R.id.cong);
        tru = (Button) findViewById(R.id.tru);
        bang = (Button) findViewById(R.id.bang);
        mhinh = (EditText) findViewById(R.id.mhinh);
        ketqua = (TextView) findViewById(R.id.ketqua);
        c = (Button) findViewById(R.id.c);


        chin.setOnClickListener(this);
        tam.setOnClickListener(this);
        bay.setOnClickListener(this);
        sau.setOnClickListener(this);
        nam.setOnClickListener(this);
        bon.setOnClickListener(this);
        ba.setOnClickListener(this);
        hai.setOnClickListener(this);
        mot.setOnClickListener(this);
        cong.setOnClickListener(this);
        c.setOnClickListener(this);
        bang.setOnClickListener(this);
        nhan.setOnClickListener(this);
        chia.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.chin:
                mhinh.append("9");
                break;
            case R.id.tam:
                mhinh.append("8");
                break;

            case R.id.bay:
                mhinh.append("7");
                break;

            case R.id.sau:
                mhinh.append("6");
                break;

            case R.id.nam:
                mhinh.append("5");
                break;

            case R.id.bon:
                mhinh.append("4");
                break;

            case R.id.ba:
                mhinh.append("3");
                break;
            case R.id.hai:
                mhinh.append("2");
                break;
            case R.id.mot:
                mhinh.append("1");
                break;
            case R.id.cong:
                mhinh.append("+");
                break;
            case R.id.tru:
                mhinh.append("-");
                break;
            case R.id.khong:
                mhinh.append("1");
                break;
            case R.id.c:

                BaseInputConnection textFieldInputConnection = new BaseInputConnection(mhinh, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));

                break;
            case R.id.bang:
                DecimalFormat df = new DecimalFormat("###.#######");
                double result = 0;
                addOperation(mhinh.getText().toString());
                addNumber(mhinh.getText().toString());
                // Thuật toán tính toán biểu thức

                if (chuoi.size() >=so.size() || chuoi.size() < 1) {
                    ketqua.setText("Lỗi định dạng");
                } else {
                    for (int i = 0; i < (so.size() - 1); i++) {
                        switch (chuoi.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = so.get(i) + so.get(i + 1);
                                } else {
                                    result = result + so.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = so.get(i) - so.get(i + 1);
                                } else {
                                    result = result - so.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    result = so.get(i) * so.get(i + 1);
                                } else {
                                    result = result * so.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    result = so.get(i) / so.get(i + 1);
                                } else {
                                    result = result / so.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    ketqua.setText(df.format(result) + "");
                }

        }
    }

    public ArrayList<String> chuoi;

    public ArrayList<Double> so;

    public int addOperation(String input) {
        chuoi = new ArrayList<>();

        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    chuoi.add(cArray[i] + "");
                    break;
                case '-':
                    chuoi.add(cArray[i] + "");
                    break;
                case '*':
                    chuoi.add(cArray[i] + "");
                    break;
                case '/':
                    chuoi.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }

    public void addNumber(String stringInput) {
        so = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while(matcher.find()){
            so.add(Double.valueOf(matcher.group(1)));
        }
    }
}

}
