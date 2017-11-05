package com.example.sony.training;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int GALLERY_REQUEST_CODE = 100;
    private Button mButtonGotoActivity2, mButtonOpenGoogleDotCom, mButtonOpenGallery, mButtonOpenCamera;
    private EditText mEditTextInput;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();
    }


    private void initViews() {
        mButtonGotoActivity2 = (Button) findViewById(R.id.btnActivity2);
        mButtonOpenGoogleDotCom = (Button) findViewById(R.id.btnGoogle);
        mButtonOpenGallery = (Button) findViewById(R.id.btnGallery);
        mButtonOpenCamera = (Button) findViewById(R.id.btnCamera);
        mEditTextInput = (EditText) findViewById(R.id.edtinput);
        mImage = (ImageView) findViewById(R.id.image);
    }

    private void initEvents() {
        mButtonGotoActivity2.setOnClickListener(this);
        mButtonOpenGoogleDotCom.setOnClickListener(this);
        mButtonOpenGallery.setOnClickListener(this);
        mButtonOpenCamera.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnActivity2:
                openActivitySecond();
                break;
            case R.id.btnGoogle:
                openGoogle();
                break;
            case R.id.btnGallery:
                openGallery();
                break;
            case R.id.btnCamera:
                openCamera();
                break;
            default:
                break;
        }
    }

    private void openCamera() {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setAction(android.content.Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    private void openGoogle() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://google.com"));
        startActivity(intent);
    }

    private void openActivitySecond() {
        String input = mEditTextInput.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(Constant.KEY_DATA_INPUT, input);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST_CODE) {
            if (data != null) {
                Uri selectedImage = data.getData();
                Glide.with(MainActivity.this).load(selectedImage).into(mImage);
            }
        }
    }
}