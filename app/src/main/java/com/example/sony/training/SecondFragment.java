package com.example.sony.training;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment implements View.OnClickListener {

    private EditText etUserName;
    private EditText etEmailS;
    private EditText etAge;
    private EditText etPassS;

    private Button bLoginS;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_second, container, false);

        initViews();
        initEvent();

        return view;
    }

    private void initViews() {
        etUserName = (EditText) view.findViewById(R.id.editUserName);
        etEmailS = (EditText) view.findViewById(R.id.editEmailAddressSecond);
        etAge = (EditText) view.findViewById(R.id.editAge);
        etPassS = (EditText) view.findViewById(R.id.editPasswordSecond);
    }

    private void initEvent() {
        bLoginS = (Button) view.findViewById(R.id.buttonLoginSecond);
    }

    @Override
    public void onClick(View v) {

    }
}
