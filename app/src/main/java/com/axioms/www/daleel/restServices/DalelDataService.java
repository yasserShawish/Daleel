package com.axioms.www.daleel.restServices;

import com.axioms.www.daleel.metadata.MyCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aababneh on 6/6/2017.
 */

public interface DalelDataService {

    @GET("bins/6srol")
    Call<List<MyCategory>> dalellCategory();

}
