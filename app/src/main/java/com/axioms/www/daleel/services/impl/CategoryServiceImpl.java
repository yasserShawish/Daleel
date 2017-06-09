package com.axioms.www.daleel.services.impl;

import android.util.Log;

import com.axioms.www.daleel.metadata.MyCategory;
import com.axioms.www.daleel.restServices.ApiClient;
import com.axioms.www.daleel.restServices.DalelDataService;
import com.axioms.www.daleel.restServices.RetrieveCategoryTask;
import com.axioms.www.daleel.services.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Retrofit;

/**
 * Created by Ahmad Ababneh on 29/04/2017.
 */

public class CategoryServiceImpl implements CategoryService{

    DalelDataService dalelDataService;

    public  CategoryServiceImpl(){
        dalelDataService = ApiClient.getDalelDataService();
    }

    @Override
    public List<MyCategory> findALlCategory() {;
        try {
            RetrieveCategoryTask categoryTask = new RetrieveCategoryTask();
            categoryTask.execute(dalelDataService);
            return categoryTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Log.e("Unknown error",ex.getMessage());
        }
        return new ArrayList<>();
    }
}
