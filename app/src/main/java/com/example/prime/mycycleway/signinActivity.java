package com.example.prime.mycycleway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class signinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }
    public void openFBLogin(View view){
        Intent i=new Intent(this,FBLoginActivity.class);
        startActivity(i);
    }
    public void openGoogleLogin(View view){
        Intent i=new Intent(this,GoogleSigninActivity.class);
        startActivity(i);
    }
//    public void openEmailLogin(View view){
//        Intent i=new Intent(this,EmailLoginActivity.class);
//        startActivity(i);
//    }
}
