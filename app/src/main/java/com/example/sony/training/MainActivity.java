package com.example.sony.training;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FirstFragmentEventListenner{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FisrtFragment fisrtFragment = new FisrtFragment();
        getFragmentManager().beginTransaction().add(R.id.content_first_fragment, fisrtFragment).commitAllowingStateLoss();

        SecondFragment secondFragment = new SecondFragment();
        getFragmentManager().beginTransaction().add(R.id.content_second_fragment, secondFragment).commitAllowingStateLoss();
    }

    @Override
    public void onButtonClick() {
        if (isFisrtFragmentAdded()){
            return;
        }
        FisrtFragment fisrtFragment = new FisrtFragment();
        getFragmentManager().beginTransaction().add(R.id.content_second_fragment,fisrtFragment).commitAllowingStateLoss();

    }

    public boolean isFisrtFragmentAdded() {
        android.app.Fragment fragment = getFragmentManager().findFragmentById(R.id.content_second_fragment);
        return fragment instanceof FisrtFragment;
    }
}
