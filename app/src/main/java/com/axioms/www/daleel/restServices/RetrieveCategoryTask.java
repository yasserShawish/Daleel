package com.axioms.www.daleel.restServices;

import android.os.AsyncTask;
import android.util.Log;

import com.axioms.www.daleel.metadata.MyCategory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by aababneh on 6/6/2017.
 */

public class RetrieveCategoryTask extends AsyncTask<Object ,Void , List<MyCategory>> {

    @Override
    protected List<MyCategory> doInBackground(Object[] params) {
        DalelDataService dalelDataService = (DalelDataService) params[0];
        Call<List<MyCategory>> listCall = dalelDataService.dalellCategory();
        List<MyCategory> list = new ArrayList();
        try {
            Response<List<MyCategory>> response = listCall.execute();
            if(response.isSuccessful()){
                list = response.body();
            }else {
                Log.e("category" , response.errorBody().string());
            }
        } catch (IOException e) {
            Log.e("category retrieve task" , e.getMessage());
        }
        return list;
    }
}
