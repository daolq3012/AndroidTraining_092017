package com.example.sony.training;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FisrtFragment extends Fragment implements View.OnClickListener {
    private TextView textView;
    private Button button;
    private boolean isClick = false;
    private FirstFragmentEventListenner firstFragmentEventListenner;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FirstFragmentEventListenner){
            firstFragmentEventListenner = (FirstFragmentEventListenner) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fisrt, container, false);

        textView = (TextView) view.findViewById(R.id.testTV);
        button = (Button) view.findViewById(R.id.btn);

        button.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                isClick = !isClick;
                firstFragmentEventListenner.onButtonClick();
                textView.setTextColor(getResources().getColor(isClick ? android.R.color.black:android.R.color.holo_blue_dark));
                break;
            default:
                break;
        }
    }
}
