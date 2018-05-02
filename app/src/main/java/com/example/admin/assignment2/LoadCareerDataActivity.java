package com.example.admin.assignment2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class LoadCareerDataActivity extends AppCompatActivity {


    String url = ApplicationSettings.hostURL + "GetCareerData.php";
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_career_data);

        layout = (LinearLayout) findViewById(R.id.layout);
        new LoadCareerData().execute( url);

    }

    class LoadCareerData extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String json) {
            try {
                JSONArray array = new JSONArray(json);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);

                    Button btn = new Button(LoadCareerDataActivity.this);
                    btn.setText(object.getString("jobTitle") + " " + object.getString("jobType") + " " + object.getString("jobDuration") + " " + object.getString("salary"));
                    layout.addView(btn);
                }
            } catch (Exception ex) {
                Log.d("Exception:", ex.getMessage());
            }
        }

        @Override
        protected String doInBackground(String... strings) {
            StringBuffer buffer = null;
            try {
                //  Log.d("Paradise", "Url = " + strings[0]);
                URL url = new URL(strings[0]);
                URLConnection connection = url.openConnection();
                //String param = URLEncoder.encode("menuType", "UTF-8");
                //  param += "=" + URLEncoder.encode(strings[1], "UTF-8");

                //connection.setDoOutput(true);
                // OutputStreamWriter output = new OutputStreamWriter(connection.getOutputStream());
                //output.write(param);
                // output.flush();
                Toast.makeText(LoadCareerDataActivity.this, "Code Reaching", Toast.LENGTH_SHORT).show();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                buffer = new StringBuffer();
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

            } catch (Exception ex) {
                Log.d("Exception", ex.getMessage());
            }
            return buffer.toString();
        }
    }


}
