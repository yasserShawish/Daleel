package com.axioms.www.daleel.utils;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

/**
 * Created by Ahmad Ababneh on 5/27/2017.
 */

public class ApiUtils {

    static char[] arabicChars = {'٠','١','٢','٣','٤','٥','٦','٧','٨','٩'};

    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1))
                * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return (dist);
    }

    public static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    public static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    public static Double distanceBetween(Location currentLocation , Location marketLocation) {
        LatLng start = new LatLng(currentLocation.getLatitude() , currentLocation.getLongitude());
        LatLng end = new LatLng(marketLocation.getLatitude() , marketLocation.getLongitude());
        if (start == null || end == null) {
            return null;
        }

        return SphericalUtil.computeDistanceBetween(start, end);
    }


    public static String convertDigits(String str){
        StringBuilder builder = new StringBuilder();
        for(int i =0;i<str.length();i++)
        {
            if(Character.isDigit(str.charAt(i)))
            {
                builder.append(arabicChars[(int)(str.charAt(i))-48]);
            }
            else
            {
                builder.append(str.charAt(i));
            }
        }

        return builder.toString();
    }

}
