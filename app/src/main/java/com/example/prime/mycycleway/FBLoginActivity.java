package com.example.prime.mycycleway;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;


public class FBLoginActivity extends AppCompatActivity {

    LoginButton loginButton;
 //   TextView textView;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // FacebookSdk.sdkInitialize();
        setContentView(R.layout.activity_main);
        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions("email","public_profile");
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
               // String userid = loginResult.getAccessToken().getUserId();
                GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        //displayUserInfo(object);

                    }
                });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "first_name, last_name, email,id");
                graphRequest.setParameters(parameters);
                graphRequest.executeAsync();
                openLocationActivity();

            }
            @Override
            public void onCancel(){

            }
            @Override
            public void onError(FacebookException error){

            }

        });

    }
    @Override
    protected void onActivityResult( final int requestCode,final int resultCode,final  Intent data) {
        /*super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);*/
        openLocationActivity();
    }
    public void openLocationActivity(){
        Intent i=new Intent(this,MapsActivity.class);
        startActivity(i);
    }

}

// @SuppressLint("SetTextI18n")
    /*public void displayUserInfo(JSONObject object){
        String first_name , last_name,email , id ;
        first_name = "";
        last_name = "";
        email = "";
        id = "";
        try {
            first_name = object.getString("first_name");
            last_name = object.getString("last_name");
            email = object.getString("email");
            id = object.getString("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TextView tv_name, tv_email, tv_id;
        tv_name = (TextView)findViewById(R.id.TV_name);
        tv_email = (TextView)findViewById(R.id.TV_email);
        tv_id = (TextView)findViewById(R.id.TV_id);

        tv_name.setText(first_name+" "+last_name);
        tv_email.setText("Email : "+email);
        tv_id.setText("Id : "+id);
    }*/


