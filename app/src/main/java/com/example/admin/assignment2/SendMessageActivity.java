package com.example.admin.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendMessageActivity extends AppCompatActivity {

    EditText txtPhoneNo, txtMessage;
    Button btnSend;
    String phoneNo, Message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        txtPhoneNo = (EditText) findViewById(R.id.txtPhoneNo);
        txtMessage = (EditText) findViewById(R.id.txtMessage);
        btnSend = (Button) findViewById(R.id.btnSend);

        phoneNo = txtPhoneNo.getText().toString();
        Message = txtMessage.getText().toString();

        btnSend.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                sendMessage(phoneNo, Message);
            }
        });

    }

    private void sendMessage(String phone, String message) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone, null, message, null, null);
            Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
        } catch (Exception ex) {
            Toast.makeText(this, "Message not Sent", Toast.LENGTH_SHORT).show();
        }
    }
}
