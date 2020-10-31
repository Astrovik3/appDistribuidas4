package com.example.appdistribuidas;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @POST("/login")
    Call<LoginResult> executeLogin(@Body HashMap<String, String> map);

    //lo hago para seguir el tutorial, despues lo borro o cambio
    @POST("/signup")
    Call<Void> executeSignup(@Body HashMap<String, String>map);
}
