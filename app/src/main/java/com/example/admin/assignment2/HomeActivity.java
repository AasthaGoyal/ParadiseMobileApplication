
package com.example.admin.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    ImageButton btnServices, btnSpecials, btnContactUs, btnCareers, btnAboutUs, btnFeatures;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnServices = (ImageButton) findViewById(R.id.btnServices);
        btnSpecials = (ImageButton) findViewById(R.id.btnSpecials);
        btnContactUs = (ImageButton) findViewById(R.id.btnContactUs);
        btnCareers = (ImageButton) findViewById(R.id.btnCareers);
        btnAboutUs = (ImageButton) findViewById(R.id.btnAboutUs);
        btnFeatures = (ImageButton) findViewById(R.id.btnFeatures);

        btnServices.setOnClickListener(new ServicesClicked());

        btnAboutUs.setOnClickListener(new AboutUsClicked());
        btnContactUs.setOnClickListener(new ContactUsClicked());
        btnCareers.setOnClickListener(new CareersClicked());
        btnSpecials.setOnClickListener(new SpecialsClicked());
        btnFeatures.setOnClickListener(new FeaturesClicked());

    }

    class SpecialsClicked implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            // Toast.makeText(HomeActivity.this, "Code is reaching", Toast.LENGTH_SHORT).show();
           Intent intent = new Intent(HomeActivity.this, SpecialsActivity.class );
            startActivity(intent);
        }
    }

    class ContactUsClicked implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(HomeActivity.this, ContactsActivity.class );
           startActivity(intent);
        }
    }

    class CareersClicked implements View.OnClickListener{

        @Override
        public void onClick(View v) {
           Intent intent = new Intent(HomeActivity.this, LoadCareerDataActivity.class );
           startActivity(intent);
        }
    }

    class AboutUsClicked implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Toast.makeText(HomeActivity.this, "Code is reaching", Toast.LENGTH_SHORT).show();
           Intent intent = new Intent(HomeActivity.this, AboutUsActivity.class );
           startActivity(intent);
        }
    }

    class ServicesClicked implements View.OnClickListener{

        @Override
        public void onClick(View v) {
           Intent intent = new Intent(HomeActivity.this, MenuDataActivity.class );
            startActivity(intent);

        }
    }

    class FeaturesClicked implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(HomeActivity.this, FeaturesActivity.class );
            startActivity(intent);
        }
    }

}
