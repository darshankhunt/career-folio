package com.example.resumemaker.Model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AboutRetrofit {

    @POST("create.php")
    Call<aboutModel> PostData(@Body aboutModel aboutModel);

}

