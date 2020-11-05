package com.example.appdistribuidas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private  static String API_BASE_URL = "http://10.0.2.2:8090/api/";
    private  static Retrofit retrofit;
    private  static Gson gson;

    public static  Retrofit getRetrofitInstance(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_BASE_URL)
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public static  RetrofitInterface getUserService(){
        RetrofitInterface retrofitInterface = getRetrofitInstance().create(RetrofitInterface.class);
        return retrofitInterface;
    }
}
