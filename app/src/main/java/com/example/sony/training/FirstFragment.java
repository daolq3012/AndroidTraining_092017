package com.example.sony.training;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {

    private TextView mFirstTextView;
    private Button mFirstButton;
    private boolean isClicked = false;
    private RelativeLayout relativeLayout;

    private FirstFragmentEventListener firstFragmentEventListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FirstFragmentEventListener) {
            firstFragmentEventListener = (FirstFragmentEventListener) context;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        mFirstTextView = (TextView) view.findViewById(R.id.firstTextView);
        mFirstButton = (Button) view.findViewById(R.id.firstButton);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.container_second_fragment);
        mFirstButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.firstButton:
                firstFragmentEventListener.onButtonClicked();
                isClicked = !isClicked;
                mFirstTextView.setTextColor(getResources().getColor(isClicked ? R.color.colorAccent : R.color.colorPrimaryDark));
                break;
            default:
                break;
        }
    }
}
