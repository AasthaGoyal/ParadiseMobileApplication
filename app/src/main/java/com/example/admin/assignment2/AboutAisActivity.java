package com.example.admin.assignment2;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AboutAisActivity extends Fragment {

    TextView txtAbtAis;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_about_ais, container, false);

        txtAbtAis =  (TextView) rootView.findViewById(R.id.txtAbtAis);
        txtAbtAis.setText("This project has been made by the student of Auckland Institutes of Studies (AIS). AIS is the is the largest privately owned tertiary institute in Auckland, New Zealand.The institute now has two campuses in Mt Albert: St Helens Campus, located at 28a Linwood Ave and Asquith Campus, located at 120 Asquith Ave. AIS offers bachelor and masters level degree programmes in business, information technology, tourism management, and hospitality management. The institutes own English Language Centre offers a range of English language courses including English teacher training (CertTESOL). The institute is closely affiliated with the Centre for Research in International Education (CRIE)");
        return rootView;
    }
}

