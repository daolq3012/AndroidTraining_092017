package com.example.sony.training;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener{

    private TextView mTxtHello;
    private Button mBtnFirst;
    private boolean isClicked = false;
    private RelativeLayout relativeLayout;
    private FirstFragmentEventListener firstFragmentEventListener;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        mTxtHello = (TextView) v.findViewById(R.id.helloTextView);
        mBtnFirst = (Button) v.findViewById(R.id.firstButton);
//        relativeLayout = (RelativeLayout) v.findViewById(R.id.container_second_fragment);
        mBtnFirst.setOnClickListener(this);
        return v;
    }

    // hàm liên kết tới activity cha, giao tiếp với activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FirstFragmentEventListener){
            firstFragmentEventListener = (FirstFragmentEventListener) context;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.firstButton:
                firstFragmentEventListener.onButtonClicked();
                isClicked = !isClicked ;
                mTxtHello.setTextColor(getResources().getColor(isClicked ? android.R.color.holo_orange_dark : android.R.color.holo_purple));
                break;
            default:
                break;
        }
    }
}
