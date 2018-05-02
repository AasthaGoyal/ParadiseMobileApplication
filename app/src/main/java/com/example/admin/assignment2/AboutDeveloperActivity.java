package com.example.admin.assignment2;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AboutDeveloperActivity extends Fragment {


        TextView txtAboutDeveloper;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_about_developer, container, false);

            txtAboutDeveloper =  (TextView) rootView.findViewById(R.id.txtAboutDeveloper);
            txtAboutDeveloper.setText("I have deveoped this project as part of my assignment. My full name is Aastha Goyal. I am a student of the programme Bachelors in Information Technology(Level 7), specializing in softwares development at AIS.");
            return rootView;
        }


}
