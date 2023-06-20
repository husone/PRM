package com.example.webservice2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface Api {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("posts")
    Call<List<Results>> getPosts();
}

