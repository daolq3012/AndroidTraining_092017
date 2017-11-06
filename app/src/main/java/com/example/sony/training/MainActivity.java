package com.example.sony.training;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int GALLERY_REQUEST_CODE = 100;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Button mBtnGotoSecondActivity,mBtnOpenGoole,mBtnOpenGallery,mBtnOpenCamera;
    private EditText mEdtInput;
    private ImageView mImgAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();
    }

    private void initViews() {
        mBtnGotoSecondActivity = (Button) findViewById(R.id.btnGotoSecondActivity);
        mBtnOpenGoole = (Button) findViewById(R.id.btnOpenGoogle);
        mBtnOpenGallery = (Button) findViewById(R.id.btnOpenGallery);
        mBtnOpenCamera = (Button) findViewById(R.id.btnOpenCamera);
        mEdtInput= (EditText) findViewById(R.id.edtInput);
        mImgAvatar = (ImageView) findViewById(R.id.imgAvatar);
    }

    private void initEvents() {
        mBtnGotoSecondActivity.setOnClickListener(this);
        mBtnOpenGoole.setOnClickListener(this);
        mBtnOpenGallery.setOnClickListener(this);
        mBtnOpenCamera.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGotoSecondActivity:
                openSecondActivity();
                break;
            case R.id.btnOpenGoogle:
                openGoogle();
                break;
            case R.id.btnOpenGallery:
                openGallery();
                break;
            case R.id.btnOpenCamera:
                openCamera();
                break;
        }
    }

    private void openSecondActivity() {
        String input = mEdtInput.getText().toString();
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra(Constant.KEY_DATA_INPUT,input);
        startActivity(intent);
    }

    private void openGoogle() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://google.com"));
        startActivity(intent);
    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,GALLERY_REQUEST_CODE);
    }

    private void openCamera() {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                Uri selectImage = data.getData();
                Glide.with(MainActivity.this).load(selectImage).into(mImgAvatar);
            }
        } else if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImgAvatar.setImageBitmap(imageBitmap);
        }
    }
}
