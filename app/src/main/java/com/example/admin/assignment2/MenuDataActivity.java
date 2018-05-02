package com.example.admin.assignment2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MenuDataActivity extends AppCompatActivity {

    Button btnCatering, btnBuffet, btnDineIn, btnTakeaway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_data);

        btnCatering = (Button) findViewById(R.id.btnCatering);
        btnBuffet = (Button) findViewById(R.id.btnBuffet);
        btnDineIn = (Button) findViewById(R.id.btnDineIn);
        btnTakeaway = (Button) findViewById(R.id.btnTakeaway);

        /* I created the LoadMenuDataActivity to show the data according to the particular menu type,
        but was not able to run it properly*/

        btnCatering.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intentMenu = new Intent(MenuDataActivity.this, LoadMenuDataActivity.class);
                intentMenu.putExtra("menuType", "Catering");
                startActivity(intentMenu);
            }

        });

        btnBuffet.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intentMenu = new Intent(MenuDataActivity.this, LoadMenuDataActivity.class);
                intentMenu.putExtra("menuType", "Buffet");
                startActivity(intentMenu);
            }

        });

        btnTakeaway.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intentMenu = new Intent(MenuDataActivity.this, LoadMenuDataActivity.class);
                intentMenu.putExtra("menuType", "Takeaway");
                startActivity(intentMenu);
            }

        });

        btnDineIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intentMenu = new Intent(MenuDataActivity.this, LoadMenuDataActivity.class);
                intentMenu.putExtra("menuType", "DineIn");
                startActivity(intentMenu);
            }

        });
    }


}