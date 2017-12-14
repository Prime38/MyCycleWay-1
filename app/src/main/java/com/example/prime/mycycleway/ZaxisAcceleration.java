package com.example.prime.mycycleway;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class ZaxisAcceleration extends Activity implements SensorEventListener {
    private Sensor mySensor;
    private SensorManager SM;
    private double z;
    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SM = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
         z = event.values[2];
    }
    public double getValue(){
        double gravity = z/9.8;
        return gravity;
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
         // NOT IN USE
    }
    @Override
    protected void onResume() {
        super.onResume();
        SM.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        SM.unregisterListener(this);
    }
}
