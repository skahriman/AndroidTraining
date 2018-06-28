package com.example.sefakkahriman.chasemobileappdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ProfileSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);

    }

    public void onClickButton(View view) {
        switch (view.getId()) {
            case R.id.mySettings:
                Toast.makeText(this, "Clicked on My settings", Toast.LENGTH_SHORT).show();
                break;

            case R.id.viewAlerts:
                Toast.makeText(this, "Clicked on View Alerts", Toast.LENGTH_SHORT).show();
                break;

            case R.id.manageAlerts:
                Toast.makeText(this, "Clicked on Manage Alerts", Toast.LENGTH_SHORT).show();
                break;

            case R.id.secureMessageCenter:
                Toast.makeText(this, "Clicked on Secure Message Center", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contactUs:
                Toast.makeText(this, "Clicked on Contact Us", Toast.LENGTH_SHORT).show();
                break;

            case R.id.faqs:
                Toast.makeText(this, "Clicked on FAQs", Toast.LENGTH_SHORT).show();
                break;

            case R.id.privacy:
                Toast.makeText(this, "Clicked on Privacy", Toast.LENGTH_SHORT).show();
                break;

            case R.id.disclosures:
                Toast.makeText(this, "Clicked on Disclosures", Toast.LENGTH_SHORT).show();
                break;

            case R.id.legalAgreements:
                Toast.makeText(this, "Clicked on Legal Agreements", Toast.LENGTH_SHORT).show();
                break;

        }
    }

}
