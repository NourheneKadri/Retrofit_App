package com.example.retrofit_app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;



   public interface JSONPlaceholder {

      @GET("posts")
        Call<List<RequestPost>> getRequestPost();

    }


