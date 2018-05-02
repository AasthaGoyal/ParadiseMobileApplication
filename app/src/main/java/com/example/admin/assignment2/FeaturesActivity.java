package com.example.admin.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FeaturesActivity extends AppCompatActivity {

    Button btnInsertCareer,btnSearchCareer, btnInsertUser, btnSearchUser, btnInsertMenu, btnSearchMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);

        btnInsertCareer = (Button) findViewById(R.id.btnInsertCareer);
        btnSearchCareer = (Button) findViewById(R.id.btnSearchCareer);
        btnInsertUser = (Button) findViewById(R.id.btnInsertUser);
        btnSearchUser = (Button) findViewById(R.id.btnSearchUser);
        btnInsertMenu = (Button) findViewById(R.id.btnInsertMenu);
        btnSearchMenu = (Button) findViewById(R.id.btnSearchMenu);

        btnInsertMenu.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (FeaturesActivity.this, AccessMenuDataActivity.class);
                startActivity(intent);
            }
        });

        btnSearchMenu.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (FeaturesActivity.this, SearchMenu.class);
                startActivity(intent);
            }
        });

        btnInsertCareer.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (FeaturesActivity.this, AccessCareerDataActivity.class);
                startActivity(intent);
            }
        });

        btnSearchCareer.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (FeaturesActivity.this, SearchCareerActivity.class);
                startActivity(intent);
            }
        });

        btnInsertUser.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (FeaturesActivity.this, AccessUserDataActivity.class);
                startActivity(intent);
            }
        });

        btnSearchUser.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (FeaturesActivity.this, SearchUserActivity.class);
                startActivity(intent);
            }
        });
    }



}
