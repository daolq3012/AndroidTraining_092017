package com.example.sony.training;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button insertMemberButton;
    private Button viewListMemberButton;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

//    private ArrayList<Member> members;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        insertMemberButton = findViewById(R.id.btn_input_member);
        viewListMemberButton = findViewById(R.id.btn_show_list_member);

//        members = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Member member = new Member("Phong Chau #" + i,21);
//            members.add(member);
//        }

        insertMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateMemberActivity.class));
            }
        });
        viewListMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewListMembers();
            }
        });

    }

    private void viewListMembers() {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        final List<Member> members = db.memberDao().getAllMembers();
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new MemberAdapter(members);
        recyclerView.setAdapter(adapter);

    }
}
