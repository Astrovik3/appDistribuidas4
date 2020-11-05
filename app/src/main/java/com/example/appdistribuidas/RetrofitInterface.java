package com.example.appdistribuidas;

import com.example.appdistribuidas.Models.LoginRequest;
import com.example.appdistribuidas.Models.LoginResponse;
import com.example.appdistribuidas.Models.Usuario;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {
/*
    @POST("/login")
    Call<LoginResult> executeLogin(@Body HashMap<String, String> map);
*/
    @GET("users")
    Call<List<Usuario>> getUsuarios();

    @POST("users/login")
    Call<Void> login(@Body LoginRequest loginRequest);
}
