package com.example.sony.training;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment implements View.OnClickListener{
    private TextView firstTextView;
    private Button firstButton;

    private boolean isClicked = false;
    private FirstFragmentEventListener firstFragmentEventListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof  FirstFragmentEventListener){
            firstFragmentEventListener = (FirstFragmentEventListener) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        firstTextView = (TextView) view.findViewById(R.id.firstTextView);
        firstButton = (Button) view.findViewById(R.id.firstButton);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch ((v.getId())){
            case R.id.firstButton:
                firstFragmentEventListener.onButtonClicked();
                isClicked =!isClicked;
                firstTextView.setTextColor(getResources().getColor(isClicked ? android.R.color.background_dark: R.color.colorAccent));
                break;
            default:
                break;
        }

    }
}
