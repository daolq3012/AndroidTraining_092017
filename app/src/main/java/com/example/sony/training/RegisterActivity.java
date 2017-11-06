package com.example.sony.training;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView mImage;
    private static final int GALLERY_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
        initEvents();
    }

    private void initEvents() {
        mImage.setOnClickListener(this);
    }

    private void initViews() {
        mImage = (ImageView) findViewById(R.id.img_addphoto);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_addphoto:
                imageClicked();
                break;
        }
    }

    private void imageClicked() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST_CODE) {
            if (data != null) {
                Uri selectedImage = data.getData();
                Glide.with(RegisterActivity.this).load(selectedImage).into(mImage);
            }
        }
    }
}
