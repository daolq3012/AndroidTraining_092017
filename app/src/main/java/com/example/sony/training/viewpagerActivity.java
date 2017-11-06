package com.example.sony.training;

import android.content.Intent;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class viewpagerActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private Button login;
    private EditText usernamelogin , Passwordlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
         viewPagertapsu();
        loginactivity();


        initData();
    }

    private void initData() {
        TestPagerAdapter adapter = new TestPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    public void viewPagertapsu(){
        viewPager = (ViewPager)findViewById(R.id.viewpager);
    }
    public void loginactivity(){
        login         = (Button) findViewById(R.id.LoginActivity);
        usernamelogin = (EditText) findViewById(R.id.usename);
        Passwordlogin = (EditText) findViewById(R.id.password);

        usernamelogin.setText("");
        Passwordlogin.setText("");
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(viewpagerActivity.this,Nhandulieu.class);
        String name = usernamelogin.getText().toString();
        String pass = Passwordlogin.getText().toString();
        Bundle bundle = new Bundle();


        intent.putExtra("name",name);
        bundle.putString("name",name);
        bundle.putString("pas",pass);

        intent.putExtras(bundle);


        startActivity(intent);


    }

    private void startActivityForResult(Bundle bundle) {
        
    }
}
