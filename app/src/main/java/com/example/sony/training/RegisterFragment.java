package com.example.sony.training;


import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class RegisterFragment extends Fragment implements View.OnClickListener {

    private EditText mEdtRegisterUsername;
    private EditText mEdtRegisterEmail;
    private EditText mEdtRegisterPassword;
    private EditText mEdtRegisterConfirmPassword;
    private Button mBtnRegister;
    private AlertDialog.Builder builder;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        initViews();
        initEvents();
        return view;
    }

    private void initViews() {
        mEdtRegisterUsername = (EditText) view.findViewById(R.id.edtRegisterUsername);
        mEdtRegisterEmail = (EditText) view.findViewById(R.id.edtRegisterEmail);
        mEdtRegisterPassword = (EditText) view.findViewById(R.id.edtRegisterPassword);
        mEdtRegisterPassword.setTypeface(Typeface.DEFAULT);
        mEdtRegisterConfirmPassword = (EditText) view.findViewById(R.id.edtRegisterConfirmPassword);
        mEdtRegisterConfirmPassword.setTypeface(Typeface.DEFAULT);
        mBtnRegister = (Button) view.findViewById(R.id.btnRegister);

        builder = new AlertDialog.Builder(this.getContext(),R.style.MyDialogTheme);
    }

    private void initEvents() {
        mBtnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                String email = mEdtRegisterEmail.getText().toString();
                if(!Validate.isEmailValid(email)) {
                    builder.setTitle(R.string.email_error_title);
                    builder.setMessage(R.string.email_error_message);
                    builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mEdtRegisterEmail.setText("");
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                if (Validate.isPasswordWeak(mEdtRegisterPassword)) {
                    builder.setTitle(R.string.password_error_title);
                    builder.setMessage(R.string.password_error_message);
                    builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                break;
        }
    }
}
