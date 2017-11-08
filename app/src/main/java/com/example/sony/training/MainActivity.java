package com.example.sony.training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.sony.training.handler.FetchDataFromUrl;
import com.example.sony.training.model.Item;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnFetchDataListener {

    private EditText mKeywordEditText, mLimitNumberEditText;
    private Button mSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mKeywordEditText = (EditText) findViewById(R.id.keywordEdittext);
        mLimitNumberEditText = (EditText) findViewById(R.id.limitNumberEdittext);
        mSearchButton = (Button) findViewById(R.id.searchButton);
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keyword = mKeywordEditText.getText().toString();
                String limit = mLimitNumberEditText.getText().toString();
                if (keyword.isEmpty() || limit.isEmpty()) {
                    return;
                }
                new FetchDataFromUrl(MainActivity.this).execute(
                        "https://api.github.com/search/users?per_page=" + limit + "&q=" + keyword);
            }
        });
    }

    @Override
    public void onFetchDataSuccess(List<Item> users) {
        Log.d("abc","xyz");
    }
}
