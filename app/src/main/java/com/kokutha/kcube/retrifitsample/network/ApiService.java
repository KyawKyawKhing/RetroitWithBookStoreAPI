package com.kokutha.kcube.retrifitsample.network;

import com.kokutha.kcube.retrifitsample.model.BookModel;
import com.kokutha.kcube.retrifitsample.model.ResultModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by K Cube on 5/15/2018.
 */

public interface ApiService {

    @GET("book")
    Call<ResultModel> getBookList();
}
