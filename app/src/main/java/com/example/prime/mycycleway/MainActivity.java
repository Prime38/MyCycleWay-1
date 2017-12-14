package com.example.prime.mycycleway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openSignInActivity(View view){
//        Intent i= new Intent(this,signinActivity.class);
        Intent i= new Intent(this,MapsActivity.class);
        startActivity(i);
    }
}
