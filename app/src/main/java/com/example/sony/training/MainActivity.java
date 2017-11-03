package com.example.sony.training;

<<<<<<< Updated upstream
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTxtUN;
    private EditText mEdtUN;
    private Spinner mSpinner;
=======
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.sony.training.Adapter.TestPagerAdapter;

public class MainActivity extends FragmentActivity implements FirstFragmentEventListenner {
    private ViewPager testViewPager;
>>>>>>> Stashed changes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

<<<<<<< Updated upstream
//        mTxtUN = (TextView) findViewById(R.id.txtUN);
//        mEdtUN = (EditText) findViewById(R.id.editUN);
        mSpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
=======
        testViewPager = (ViewPager) findViewById(R.id.testViewPager);
        TestPagerAdapter testPagerAdapter = new TestPagerAdapter(getSupportFragmentManager());
        testViewPager.setAdapter(testPagerAdapter);

//        FisrtFragment fisrtFragment = new FisrtFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.container_first_fragment, fisrtFragment).commitAllowingStateLoss();
//
//        FisrtFragment1 fisrtFragment1 = new FisrtFragment1();
//        getSupportFragmentManager().beginTransaction().add(R.id.container_first_fragment_1, fisrtFragment1).commitAllowingStateLoss();


    }


    @Override
    public void onButtonClick() {
        if (isFirstFragmentAdded()) {
            return;
        }
        FisrtFragment fisrtFragment = new FisrtFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container_first_fragment_1, fisrtFragment).commitAllowingStateLoss();
    }

    public boolean isFirstFragmentAdded() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container_first_fragment_1);
        return fragment instanceof FisrtFragment;
>>>>>>> Stashed changes
    }
}
