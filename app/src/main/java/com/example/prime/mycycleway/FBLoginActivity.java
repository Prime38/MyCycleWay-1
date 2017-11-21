package com.example.prime.mycycleway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FBLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fblogin);
    }
    public void openLocationActivity(View view){
        Intent i=new Intent(this,MapsActivity.class);
        startActivity(i);
    }
}
