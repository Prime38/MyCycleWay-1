package com.example.prime.mycycleway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EmailLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_login);
    }
    public void openLocationActivity(View view){
        Intent i=new Intent(this,MapsActivity.class);
        startActivity(i);
    }
}
