package com.example.sony.training;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener{

    private EditText mEdtEmail, mEdtPassword;
    private Button mBtnLogin;
    private TextView mTxtRegister;
    private FieldCheckValidate fieldCheckValidate = new FieldCheckValidate();
    private FirstFragmentEventListener firstFragmentEventListener;
    private boolean isLoginSuccess = false;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (!isLoginSuccess){
            View v = inflater.inflate(R.layout.fragment_first, container, false);
            initViews(v);
            initListeners();
            return v;
        }else {
            Toast.makeText(getContext(), "thanh cong", Toast.LENGTH_SHORT).show();
            View v = inflater.inflate(R.layout.fragment_login_success, container, false);
            return v;
        }





    }

    private void initViews(View v){
        mEdtEmail = (EditText) v.findViewById(R.id.email_EditText);
        mEdtPassword = (EditText) v.findViewById(R.id.password_EditText);
        mBtnLogin = (Button) v.findViewById(R.id.login_Button);
        mTxtRegister = (TextView) v.findViewById(R.id.register_TextView);

    }

    private void initListeners(){
        mBtnLogin.setOnClickListener(this);
        mTxtRegister.setOnClickListener(this);
    }

    // hàm liên kết tới activity cha, giao tiếp với activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FirstFragmentEventListener){
            firstFragmentEventListener = (FirstFragmentEventListener) context;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_Button:
                if (fieldCheckValidate.checkLogin(mEdtEmail, mEdtPassword,getContext())){
                    isLoginSuccess = !isLoginSuccess;
                    firstFragmentEventListener.onButtonClicked();
                }
                break;
            default:
                break;
        }
    }
}
