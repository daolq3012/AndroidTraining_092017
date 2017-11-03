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
public class FirstFragment extends Fragment implements View.OnClickListener {

    private Button bLoginF;
    private EditText etEmailF;
    private EditText etPassF;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_first, container, false);

        initViews();
        initEvent();

        return view;

    }

    private void initViews() {
        bLoginF = (Button) view.findViewById(R.id.buttonLogin);
        etEmailF = (EditText) view.findViewById(R.id.editEmailAddressFirst);
        etPassF = (EditText) view.findViewById(R.id.editPasswordFirst);
    }

    private void initEvent() {
        bLoginF.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonLogin:
                String email = etEmailF.getText().toString();
                String pass = etPassF.getText().toString();
                if (email.equals("nam@gmail.com") && pass.equals("123qwe")) {
                    getFragmentManager().beginTransaction().replace(R.id.firstFragment, new ThirdFragment()).commit();
                }
                break;
        }
    }
}
