package com.kokutha.kcube.retrifitsample.network;

import com.kokutha.kcube.retrifitsample.model.BookModel;
import com.kokutha.kcube.retrifitsample.model.ResultModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by K Cube on 5/15/2018.
 */

public class RetrofitHelper {

    private ApiService apiService;

    public RetrofitHelper() {
        String base_url = "http://192.168.43.32/BookStore/public/api/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public Call<ResultModel> getBookList() {
        return apiService.getBookList();
    }

}
