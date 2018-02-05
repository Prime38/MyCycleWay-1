package com.example.prime.mycycleway;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Nammi on 1/23/2018.
 */
//Do the URL call in background

public class ReadTask extends AsyncTask<String, Void , String> {
    public ArrayList<LatLng> allpoints;
    ParserTask pTask;
    @Override
    protected String doInBackground(String... url) {
        // TODO Auto-generated method stub
        String data = "";
        try {
            MapHttpConnection http = new MapHttpConnection();
            data = http.readUr(url[0]);


        } catch (Exception e) {
            // TODO: handle exception
            Log.d("Background Task", e.toString());
        }
        return data;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        pTask=new ParserTask();
        pTask.execute(result);
    }
    public ArrayList<LatLng> getRoutepoints(){
        return pTask.getAllPoints();
    }



}
