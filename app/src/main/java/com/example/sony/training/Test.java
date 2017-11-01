package com.example.sony.training;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by phong on 11/01/17.
 */

public class Test extends AppCompatActivity implements FirstFragmentEventListener{

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.test);

        FirstFragment firstFragment = new FirstFragment();
        getFragmentManager().beginTransaction().add(R.id.container_first_fragment,firstFragment).commitAllowingStateLoss();

        SecondFragment secondFragment = new SecondFragment();
        getFragmentManager().beginTransaction().add(R.id.container_second_fragment,secondFragment).commitAllowingStateLoss();
    }
    @Override
    public void onButtonClicked(){
        if(isFirstFragmentAdded()){
            return;
        }

        FirstFragment firstFragment = new FirstFragment();
        getFragmentManager().beginTransaction().replace(R.id.container_second_fragment,firstFragment).commitAllowingStateLoss();
    }
    private boolean isFirstFragmentAdded(){
        Fragment fragment = getFragmentManager().findFragmentById(R.id.container_second_fragment);
        return fragment instanceof FirstFragment;
    }

}
