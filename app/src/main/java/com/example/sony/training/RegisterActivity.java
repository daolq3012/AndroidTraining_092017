package com.example.sony.training;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int GALLERY_REQUEST_CODE = 10;

    private EditText mEdtRegisterUsername;
    private EditText mEdtRegisterEmail;
    private EditText mEdtRegisterPassword;
    private EditText mEdtRegisterConfirmPassword;
    private Button mBtnRegister;
    private CircleImageView mImgAvatar;

    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
        initEvents();
    }

    private void initViews() {
        mEdtRegisterUsername = (EditText) findViewById(R.id.edtRegisterUsername);
        mEdtRegisterEmail = (EditText) findViewById(R.id.edtRegisterEmail);
        mEdtRegisterPassword = (EditText) findViewById(R.id.edtRegisterPassword);
        mEdtRegisterPassword.setTypeface(Typeface.DEFAULT);
        mEdtRegisterConfirmPassword = (EditText) findViewById(R.id.edtRegisterConfirmPassword);
        mEdtRegisterConfirmPassword.setTypeface(Typeface.DEFAULT);
        mBtnRegister = (Button) findViewById(R.id.btnRegister);
        mImgAvatar = (CircleImageView) findViewById(R.id.imgAvatar);

        builder = new AlertDialog.Builder(RegisterActivity.this,R.style.MyDialogTheme);
    }

    private void initEvents() {
        mBtnRegister.setOnClickListener(this);
        mImgAvatar.setOnClickListener(this);
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
            case R.id.imgAvatar:
                openGallery();
                break;
        }
    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,GALLERY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                Uri selectImage = data.getData();
                Glide.with(RegisterActivity.this).load(selectImage).into(mImgAvatar);
            }
        }
    }
}
