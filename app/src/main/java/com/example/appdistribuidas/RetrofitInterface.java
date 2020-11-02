package com.example.appdistribuidas;

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
    @GET("usuarios")
    Call<List<Usuario>> getUsuarios();

}
