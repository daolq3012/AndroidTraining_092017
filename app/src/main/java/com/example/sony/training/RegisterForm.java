package com.example.sony.training;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class RegisterForm extends AppCompatActivity implements View.OnClickListener {

    private static int GALLERY_REQUEST_CODE = 100;
    private TextView mTxtAddPhoto;
    private ImageView mIvAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);
        initViews();

        initListeners();
    }

    private void initListeners() {
        mIvAvatar.setOnClickListener(this);
    }

    private void initViews() {
        mTxtAddPhoto = (TextView) findViewById(R.id.addPhotoTextView);
        mIvAvatar = (ImageView) findViewById(R.id.avatarImageView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.avatarImageView:
                openGallery();
                break;
        }
    }

    private void openGallery() {
        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/");
        startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST_CODE){
            if (data != null){
                Uri selectedImage = data.getData();
                Glide.with(RegisterForm.this).load(selectedImage).into(mIvAvatar);
            }
        }
    }
}