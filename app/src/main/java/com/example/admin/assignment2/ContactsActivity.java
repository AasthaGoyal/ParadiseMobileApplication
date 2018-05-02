package com.example.admin.assignment2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ContactsActivity extends AppCompatActivity {



    Button btnSendMessage, btnGoogleMaps, btnGoToWebsite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        btnSendMessage = (Button) findViewById(R.id.btnSendMessage);
        btnGoogleMaps = (Button) findViewById(R.id.btnGoogleMaps);
        btnGoToWebsite = (Button) findViewById(R.id.btnGoToWebsite);

        btnSendMessage.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactsActivity.this, SendMessageActivity.class);
                startActivity(intent);
            }
        });

        btnGoogleMaps.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactsActivity.this, GoogleMapsActivity.class);
                startActivity(intent);
            }
        });

        btnGoToWebsite.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactsActivity.this, ImageSliderActivity.class);
                startActivity(intent);
            }
        });



    }





}
