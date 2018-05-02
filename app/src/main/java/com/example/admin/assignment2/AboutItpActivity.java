package com.example.admin.assignment2;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AboutItpActivity extends Fragment {
    TextView txtAboutItp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_about_itp, container, false);

        txtAboutItp = (TextView) rootView.findViewById(R.id.txtAboutItp);
        txtAboutItp.setText("We are the students of the Information Technology Program (ITP) of AIS. There are 5 programmes provided in IT. It includes: Bachelors in Information Technology, Graduate Diploma and Post graduate diploma in Information Technology.");
        return rootView;
    }
}
