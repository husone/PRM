package com.example.webservice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface Api {
    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Results>> getsuperHeroes();
}

