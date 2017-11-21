package com.example.sony.training;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateMemberActivity extends AppCompatActivity {
    private EditText edtMemberName, edtMemberAge;
    private Button btnInsert;
    private AppDatabase mDatabase;
    private MainApplication mApplication;
    private InsertAsyncTask mInsertAsyncTask;
    private Member mMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_member);
        findViews();
    }

    private void findViews() {
        edtMemberName = findViewById(R.id.edt_Member_Name);
        edtMemberAge = findViewById(R.id.edt_Member_Age);
        btnInsert = findViewById(R.id.btn_Insert_LayoutCreateMember);
        mApplication = (MainApplication) getApplication();
        mDatabase = mApplication.getDatabase();
        mInsertAsyncTask = new InsertAsyncTask(CreateMemberActivity.this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtMemberName.getText().toString();
                int age = Integer.parseInt(edtMemberAge.getText().toString());
                mMember = new Member(name, age);
                mInsertAsyncTask.execute(mMember);
                finish();
            }
        });
    }
}
