package com.axioms.www.daleel.restServices;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aababneh on 6/6/2017.
 */

public class ApiClient {

    public static final String BASE_URL = "https://api.myjson.com";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static DalelDataService getDalelDataService(){
        return getClient().create(DalelDataService.class);
    }
}
