package com.example.sony.training;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateMemberActivity extends AppCompatActivity {
    private static final String TAG = "CreateMember";
    private EditText edtMemberName, edtMemberAge;
    private Button btnInsert;

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

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Save to database

                Log.d(TAG, "Clicked" + edtMemberName.getText().toString());
                int ageMember = Integer.parseInt(edtMemberAge.getText().toString());

                if(edtMemberName.getText().toString().length()==0 && edtMemberAge.getText().toString().length()==0){
                    edtMemberName.setError("Required!");

                }else{
                    for (int i = 0; i < 10; i++) {
                        Member member = new Member(edtMemberName.getText().toString(), ageMember);
                        db.memberDao().insertAll(member);
                    }
                    startActivity(new Intent(CreateMemberActivity.this, MainActivity.class));
                }

            }
        });


    }
}
