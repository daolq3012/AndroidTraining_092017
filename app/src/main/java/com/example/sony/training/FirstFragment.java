package com.example.sony.training;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {

    private RelativeLayout firstFragmentParentLayout;
    private TextView firstTextView;
    private Button firstButton;

    private boolean isClicked = false;

    private FirstFragmentEventListener firstFragmentEventListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FirstFragmentEventListener){
            firstFragmentEventListener = (FirstFragmentEventListener) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        firstFragmentParentLayout = (RelativeLayout) view.findViewById(R.id.firstFragmentParentLayout);
        firstTextView = (TextView) view.findViewById(R.id.firstTextView);
        firstButton = (Button) view.findViewById(R.id.firstButton);

        firstButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.firstButton:
                firstFragmentEventListener.onButtonClicked();
                isClicked = !isClicked;
                firstTextView.setTextColor(getResources().getColor(isClicked ? android.R.color.black : R.color.colorAccent));
                break;
            default:
                break;
        }
    }
}
