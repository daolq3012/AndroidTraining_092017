package com.example.sony.training;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.sony.training.R.*;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText usernameActivity , passwordActivity;
    private Button loginActivity;
    private TextView Registeractivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_login);
        usernameActivity = (EditText) findViewById(id.username);
        passwordActivity = (EditText) findViewById(id.password);
        loginActivity = (Button) findViewById(id.login);

        usernameActivity.setText("");
        passwordActivity.setText("");
       loginActivity.setOnClickListener(this);
        usernameActivity.setOnClickListener(this);

        nextRegisrt();


    }
    // dang ky bang Fragment
    public void nextRegisrt(){
        Registeractivity = (TextView) findViewById(id.Register);
        Registeractivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentRegisterAcyivity  fragmentRegisterAcyivity = new FragmentRegisterAcyivity();
                fragmentTransaction.add(R.id.loginActivity,fragmentRegisterAcyivity);
                fragmentTransaction.commit();
            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case id.login:
                final  String kiemtra ="  /[a-z][0-9]/@[a-z][A-Z]/.[a-z][A-Z]";
                if (usernameActivity.equals(kiemtra)){
                    Toast.makeText(this,"Email  khong dung dinh dang  ",Toast.LENGTH_LONG).show();

                }
                if (usernameActivity.equals(null)&& passwordActivity.equals(null)){

                    Toast.makeText(this,"Email || passsword not null",Toast.LENGTH_LONG).show();

                }
                if (usernameActivity.length() <9  && passwordActivity.length() <6){
                    Toast.makeText(this,"Email || passsword phai lon 6 ky tu ",Toast.LENGTH_LONG).show();
                }
                if(usernameActivity .equals("anhvuceo@gmail.com") && passwordActivity.equals("123456"  )){


                    Toast.makeText(this,"danh nhap thanh cong ",Toast.LENGTH_LONG).show();

                }


                else {
                    Toast.makeText(this,"danh nhap thanh cong ",Toast.LENGTH_LONG).show();
                }

                break;
        }

    }
}
