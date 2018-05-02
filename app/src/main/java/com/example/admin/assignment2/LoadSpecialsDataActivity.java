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

public class LoadSpecialsDataActivity extends AppCompatActivity {

    String url = ApplicationSettings.hostURL + "GetSpecialsItems.php";
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_specials_data);


        // Toast.makeText(LoadMenuDataActivity.this, "Code started", Toast.LENGTH_SHORT).show();
        new LoadSpecialsMenu().execute( url, "Specials");



    }

    class LoadSpecialsMenu extends AsyncTask<String, Void, String> {

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

                    Button btn = new Button(LoadSpecialsDataActivity.this);
                    btn.setText(object.getString("itemId") + " " + object.getString("itemName") + " " + object.getString("menuType") + " " + object.getString("itemPrice"));
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

                URL url = new URL(strings[0]);
                URLConnection connection = url.openConnection();

                Toast.makeText(LoadSpecialsDataActivity.this, "Code Reaching", Toast.LENGTH_SHORT).show();
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
