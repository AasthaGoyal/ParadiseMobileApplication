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

public class AccessMenuDataActivity extends AppCompatActivity {

    String urlAddress = ApplicationSettings.hostURL + "insertMenu.php";
    EditText txtItemName, txtMenuType, txtItemPrice, txtItemDescription;
    String itemName, menuType, price, itemDescription;
    Button btnInsertMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_menu_data);

        txtItemName = (EditText) findViewById(R.id.txtItemName);
        txtMenuType = (EditText) findViewById(R.id.txtMenuType);
        txtItemPrice = (EditText) findViewById(R.id.txtItemPrice);
        txtItemDescription = (EditText) findViewById(R.id.txtItemDescription);
        btnInsertMenu = (Button) findViewById(R.id.btnInsertMenu);

        itemName = txtItemName.getText().toString();
        menuType = txtMenuType.getText().toString();
        price = txtItemPrice.getText().toString();
        itemDescription = txtItemDescription.getText().toString();

        btnInsertMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveMenuData saveData = new SaveMenuData();
                saveData.execute(urlAddress, itemName, menuType, price, itemDescription);
            }

        });
    }


        class SaveMenuData extends AsyncTask<String, Void, String>
        {

            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url = new URL(strings[0]);
                    URLConnection connection = url.openConnection();

                    String param = URLEncoder.encode("itemName", "UTF-8");
                    param += "=" + URLEncoder.encode(strings[1], "UTF-8");

                    param += "&" + URLEncoder.encode("menuType", "UTF-8");
                    param += "=" + URLEncoder.encode(strings[2], "UTF-8");

                    param += "&" + URLEncoder.encode("itemPrice", "UTF-8");
                    param += "=" + URLEncoder.encode(strings[3], "UTF-8");

                    param += "&" + URLEncoder.encode("itemDescription", "UTF-8");
                    param += "=" + URLEncoder.encode(strings[4], "UTF-8");

                    connection.setDoOutput(true);
                    OutputStreamWriter output =
                            new OutputStreamWriter(connection.getOutputStream());

                    output.write(param);
                    output.flush();
                    Toast.makeText(AccessMenuDataActivity.this, "The data has been saved successfully", Toast.LENGTH_SHORT).show();
                }
                catch(Exception ex)
                {
                    Log.d("Exception ", ex.getMessage());
                }

                return null;


            }
        }



}
