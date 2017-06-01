package com.axioms.www.daleel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.axioms.www.daleel.services.LocationService;
import com.axioms.www.daleel.services.impl.LocationServiceImpl;
import com.axioms.www.daleel.utils.DallelConstant;
import com.axioms.www.daleel.utils.GPSTracker;
import com.google.gson.Gson;

public class Splash extends AppCompatActivity {

    LocationService locationService;
    GPSTracker gpsTracker ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        locationService = new LocationServiceImpl(this);
        gpsTracker = new GPSTracker(this);
        Thread thread = new Thread(){
            @Override
            public void run() {

                try {
                    sleep(3000);
                    Location currentLocation = gpsTracker.getLocation();
                    SharedPreferences shared = getSharedPreferences(
                                    DallelConstant.SHARED_PREF_NAME.getName()
                                    , MODE_PRIVATE);
                    Gson gson = new Gson();
                    SharedPreferences.Editor editor = shared.edit();
                    String jsonObject = gson.toJson(currentLocation);
                    editor.putString(DallelConstant.USER_LOCATION.getName() , jsonObject);
                    editor.apply();
                    Intent main = new Intent(getApplicationContext() , MainActivity.class);
                    startActivity(main);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
