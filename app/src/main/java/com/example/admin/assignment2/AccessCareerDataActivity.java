package com.example.admin.assignment2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class AccessCareerDataActivity extends AppCompatActivity {

    String urlAddress = ApplicationSettings.hostURL + "insertCareer.php";
    EditText txtJobTitle, txtJobType, txtJobDuration, txtSalary;
    String jobTitle, jobType, jobDuration, salary;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_career_data);

        txtJobTitle = (EditText) findViewById(R.id.txtJobTitle);
        txtJobType = (EditText) findViewById(R.id.txtJobType);
        txtJobDuration = (EditText) findViewById(R.id.txtJobDuration);
        txtSalary = (EditText) findViewById(R.id.txtSalary);
        btnRegister = (Button) findViewById(R.id.btnInsertCareer);

        jobTitle = txtJobTitle.getText().toString();
        jobType = txtJobType.getText().toString();
        jobDuration = txtJobDuration.getText().toString();
        salary = txtSalary.getText().toString();

        btnRegister.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                SaveData saveData = new SaveData();
                saveData.execute(urlAddress, jobTitle, jobType, jobDuration, salary);
            }
        });

    }

    class SaveData extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                URLConnection connection = url.openConnection();

                String param = URLEncoder.encode("jobTitle", "UTF-8");
                param += "=" + URLEncoder.encode(strings[1], "UTF-8");

                param += "&" + URLEncoder.encode("jobType", "UTF-8");
                param += "=" + URLEncoder.encode(strings[2], "UTF-8");

                param += "&" + URLEncoder.encode("jobDuration", "UTF-8");
                param += "=" + URLEncoder.encode(strings[3], "UTF-8");

                param += "&" + URLEncoder.encode("salary", "UTF-8");
                param += "=" + URLEncoder.encode(strings[4], "UTF-8");

                connection.setDoOutput(true);
                OutputStreamWriter output =
                        new OutputStreamWriter(connection.getOutputStream());

                output.write(param);
                output.flush();
               Toast.makeText(AccessCareerDataActivity.this, "The data has been saved successfully", Toast.LENGTH_SHORT).show();
            }
            catch(Exception ex)
            {
                Log.d("Exception ", ex.getMessage());
            }

            return null;


        }
    }
}
