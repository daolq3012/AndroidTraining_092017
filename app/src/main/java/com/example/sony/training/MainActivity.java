package com.example.sony.training;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static int GALLERY_REQUEST_CODE = 100;
    private Button mBtnOpenCamera, mBtnOpenGoogle, mBtnOpenGallery, mBtnGoToActivity2;
    private EditText mEdtInput;
    private ImageView mImvAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        initListeners();
    }

    private void initListeners() {
        mBtnGoToActivity2.setOnClickListener(this);
        mBtnOpenGoogle.setOnClickListener(this);
        mBtnOpenGallery.setOnClickListener(this);
        mBtnOpenCamera.setOnClickListener(this);
    }

    private void initViews() {
        mBtnGoToActivity2 = (Button) findViewById(R.id.btnGoToActivity2);
        mBtnOpenGoogle = (Button) findViewById(R.id.btnOpenGoogle);
        mBtnOpenGallery = (Button) findViewById(R.id.btnOpenGallery);
        mBtnOpenCamera = (Button) findViewById(R.id.btnOpenCamera);
        mEdtInput = (EditText) findViewById(R.id.edtInput);
        mImvAvatar = (ImageView) findViewById(R.id.imvAvatar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGoToActivity2:
                openMain2Activity();
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

    private void openCamera() {
    }

    private void openGallery() {
        Intent intent3 = new Intent();
        intent3.setAction(Intent.ACTION_GET_CONTENT);
        intent3.setType("image/");
        startActivityForResult(intent3,GALLERY_REQUEST_CODE);
    }

    private void openGoogle() {
        Intent intent2 = new Intent();
        intent2.setAction(Intent.ACTION_VIEW);
        intent2.setData(Uri.parse("http://www.google.com"));
        startActivity(intent2);
    }

    private void openMain2Activity() {
        String input = mEdtInput.getText().toString();
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(Constant.KEY_DATA_INPUT, input);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST_CODE ){
            if (data != null){
                Uri selectedImage = data.getData();

                // ham cua thu vien glide de load anh vao imageview
                Glide.with(MainActivity.this).load(selectedImage).into(mImvAvatar);

            }
        }
    }
}
