package com.example.sony.training;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;



public class FisrtFragment extends Fragment implements View.OnClickListener {
    private EditText edtUs;
    private EditText edtPs;
    private Button btnLogin;
    private RelativeLayout fragment;
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

        fragment = (RelativeLayout) view.findViewById(R.id.fragment1);
        btnLogin = (Button) view.findViewById(R.id.btn_login);
        edtUs = (EditText) view.findViewById(R.id.edt_us);
        edtPs = (EditText) view.findViewById(R.id.edt_ps);

        btnLogin.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String us = edtUs.getText().toString();
                String ps = edtPs.getText().toString();
                firstFragmentEventListenner.onButtonClick();
                if (us.equals("thanhthang@gmail.com") && ps.equals("thanhthang")){

                } else {

                }

                break;
            default:
                break;
        }
    }
}
