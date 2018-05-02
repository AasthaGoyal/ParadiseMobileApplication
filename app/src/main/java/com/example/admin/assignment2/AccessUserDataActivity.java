package com.example.admin.assignment2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class AccessUserDataActivity extends AppCompatActivity {

    String urlAddress = ApplicationSettings.hostURL + "insertUser.php";
    EditText txtName, txtGender, txtAddress, txtPhoneNo, txtPost, txtUsername, txtPassword;
    String name, gender, address, phoneNo, post, username, password;
    Button btnInsertUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_user_data);

        txtName = (EditText) findViewById(R.id.txtName);
        txtGender = (EditText) findViewById(R.id.txtGender);
        txtAddress = (EditText) findViewById(R.id.txtAddress);
        txtPhoneNo = (EditText) findViewById(R.id.txtPhoneNo);
        txtPost = (EditText) findViewById(R.id.txtPost);
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        btnInsertUser = (Button) findViewById(R.id.btnInsertUser);

        name = txtName.getText().toString();
        gender = txtGender.getText().toString();
        address = txtAddress.getText().toString();
        phoneNo = txtPhoneNo.getText().toString();
        post = txtPost.getText().toString();
        username = txtUsername.getText().toString();
        password = txtPassword.getText().toString();

        btnInsertUser.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                SaveUserData saveData = new SaveUserData();
                saveData.execute(urlAddress, name, gender, address, phoneNo, post, username, password);
            }
        });

    }

    class SaveUserData extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                URLConnection connection = url.openConnection();

                String param = URLEncoder.encode("employeeName", "UTF-8");
                param += "=" + URLEncoder.encode(strings[1], "UTF-8");

                param += "&" + URLEncoder.encode("employeeGender", "UTF-8");
                param += "=" + URLEncoder.encode(strings[2], "UTF-8");

                param += "&" + URLEncoder.encode("employeeAddress", "UTF-8");
                param += "=" + URLEncoder.encode(strings[3], "UTF-8");

                param += "&" + URLEncoder.encode("employeePhoneNo", "UTF-8");
                param += "=" + URLEncoder.encode(strings[4], "UTF-8");

                param += "&" + URLEncoder.encode("employeePost", "UTF-8");
                param += "=" + URLEncoder.encode(strings[5], "UTF-8");

                param += "&" + URLEncoder.encode("employeeUsername", "UTF-8");
                param += "=" + URLEncoder.encode(strings[6], "UTF-8");

                param += "&" + URLEncoder.encode("employeePassword", "UTF-8");
                param += "=" + URLEncoder.encode(strings[7], "UTF-8");

                connection.setDoOutput(true);
                OutputStreamWriter output =
                        new OutputStreamWriter(connection.getOutputStream());

                output.write(param);
                output.flush();
                Toast.makeText(AccessUserDataActivity.this, "The data has been saved successfully", Toast.LENGTH_SHORT).show();
            }
            catch(Exception ex)
            {
                Log.d("Exception ", ex.getMessage());
            }

            return null;


        }
    }
}
