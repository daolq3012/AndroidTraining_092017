package com.example.sony.training;


import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sony.training.adpater.ViewPagerAdpater;


public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText mEdtLoginUsername;
    private EditText mEdtLoginPassword;
    private Button mBtnLogin;
    private TextView mTxtLoginSignUp;
    private AlertDialog.Builder builder;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        initViews();
        initEvents();
        return view;
    }

    private void initViews() {
        mEdtLoginUsername = (EditText) view.findViewById(R.id.edtLoginUsername);
        mEdtLoginPassword = (EditText) view.findViewById(R.id.edtLoginPassword);
        mEdtLoginPassword.setTypeface(Typeface.DEFAULT);
        mBtnLogin = (Button) view.findViewById(R.id.btnLogin);
        mTxtLoginSignUp = (TextView) view.findViewById(R.id.txtLoginSignUp);

        builder = new AlertDialog.Builder(this.getContext(),R.style.MyDialogTheme);
    }

    private void initEvents() {
        mBtnLogin.setOnClickListener(this);
        mTxtLoginSignUp.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                String username = mEdtLoginUsername.getText().toString();
                String password = mEdtLoginPassword.getText().toString();
                if (Validate.isPasswordWeak(mEdtLoginPassword)) {
                    builder.setTitle(R.string.password_error_title);
                    builder.setMessage(R.string.password_error_message);
                    builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else if (username.equals("tdtruyen") && password.equals("123456")){
                    getFragmentManager().beginTransaction().replace(R.id.container_fragment,new LoginSuccessFragment()).addToBackStack(null).commit();
                }
                break;
        }
    }
}
