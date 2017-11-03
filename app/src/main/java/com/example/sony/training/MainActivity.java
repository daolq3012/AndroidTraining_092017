package com.example.sony.training;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int GALLERY_REQUEST_CODE = 100;

    private Button mButtonGotoActivitySecond, mButtonOpenGoogleDotCom, mButtonOpenGallery,
            mButtonOpenCamera;

    private EditText mEditTextInput;

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        initEvents();
    }

    private void initViews() {
        mButtonGotoActivitySecond = (Button) findViewById(R.id.btnGotoActivity2);
        mButtonOpenGoogleDotCom = (Button) findViewById(R.id.btnOpenGoogleDotCom);
        mButtonOpenGallery = (Button) findViewById(R.id.btnOpenGallery);
        mButtonOpenCamera = (Button) findViewById(R.id.btnOpenCamera);
        mEditTextInput = (EditText) findViewById(R.id.edtInput);
        mImageView = (ImageView) findViewById(R.id.imgTest);
    }

    private void initEvents() {
        mButtonGotoActivitySecond.setOnClickListener(this);
        mButtonOpenGoogleDotCom.setOnClickListener(this);
        mButtonOpenGallery.setOnClickListener(this);
        mButtonOpenCamera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGotoActivity2:
                openActivitySecond();
                break;
            case R.id.btnOpenGoogleDotCom:
                openGoogleDotCom();
                break;
            case R.id.btnOpenGallery:
                openGallery();
                break;
            case R.id.btnOpenCamera:
                break;
        }
    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setAction(android.content.Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    private void openGoogleDotCom() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://google.com"));
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
                Glide.with(MainActivity.this).load(selectedImage).into(mImageView);
            }
        }
    }
}
