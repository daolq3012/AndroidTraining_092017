package com.example.sony.training;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {

    private TextView mFirstTextView;
    private Button mFirstButton;
    private boolean isClicked = false;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        mFirstTextView = (TextView) view.findViewById(R.id.firstTextView);
        mFirstButton = (Button) view.findViewById(R.id.firstButton);

        mFirstButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.firstButton:
                isClicked = !isClicked;
                mFirstTextView.setTextColor(getResources().getColor(isClicked ? R.color.colorAccent : R.color.colorPrimaryDark));
                break;
            default:
                break;
        }
    }
}
