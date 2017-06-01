package com.axioms.www.daleel.services;

import android.location.Location;

/**
 * Created by Ahmad Ababneh on 5/23/2017.
 */

public interface LocationService {

    Location getBestLocation();
    Location getLocationByProvider(String provider);
    long getGPSCheckMilliSecsFromPrefs();

}
