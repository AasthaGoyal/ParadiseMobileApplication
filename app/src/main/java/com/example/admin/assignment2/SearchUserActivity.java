package com.example.admin.assignment2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SearchUserActivity extends AppCompatActivity {


    String url = ApplicationSettings.hostURL + "searchUser.php";
    LinearLayout layout;
    EditText txtEmployeeId;
    String employeeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);

        txtEmployeeId = (EditText) findViewById(R.id.txtItemId);
        employeeId = txtEmployeeId.getText().toString();
        layout = (LinearLayout) findViewById(R.id.layout);

        new ShowUserData().execute( url, employeeId);
    }


    class ShowUserData extends AsyncTask<String, Void, String> {

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

                    Button btn = new Button(SearchUserActivity.this);
                    btn.setText(object.getString("employeeId") + " " + object.getString("employeeName") + " " + object.getString("employeeGender") + " " + object.getString("employeeAddress") + " " + object.getString("employeePhoneNo") + "" + object.getString("employeePost")+ "" + object.getString("employeeUsername") + "" + object.getString("employeePassword"));
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
                String param = URLEncoder.encode("employeeId", "UTF-8");
                param += "=" + URLEncoder.encode(strings[1], "UTF-8");

                connection.setDoOutput(true);
                OutputStreamWriter output = new OutputStreamWriter(connection.getOutputStream());
                output.write(param);
                output.flush();

                //Toast.makeText(SearchCareerActivity.this, "Code Reaching", Toast.LENGTH_SHORT).show();
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
