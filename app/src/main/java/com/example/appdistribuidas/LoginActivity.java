package com.example.appdistribuidas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appdistribuidas.Models.LoginRequest;
import com.example.appdistribuidas.Models.LoginResponse;
import com.example.appdistribuidas.Models.Usuario;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    Button btnAccept;
    EditText txtUser;
    EditText editTextTextPassword;
    Button btnOlvidoPass;

    Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "http://10.0.2.2:8090/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getUsuarios();
/*
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);
*/
        btnAccept = findViewById(R.id.btnAccept);
        txtUser = findViewById(R.id.txtUser);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        btnOlvidoPass = findViewById(R.id.btnOlvidoPassword);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = txtUser.getText().toString();
                String password = editTextTextPassword.getText().toString();

                LoginRequest loginRequest = new LoginRequest();
                loginRequest.setMail(mail);
                loginRequest.setUserPassword(password);

                checkLoginDetails(loginRequest);
                //if(name.isEmpty())
                //    name = "Extraño";

                // Intent: un vinculo entre actividades, origen -> destino
                Intent i = new Intent(LoginActivity.this, MainPageActivity.class);
                //i.putExtra("name",name);
                //startActivity(i);
            }
        });

        btnOlvidoPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {
                //borrar despues
                //handleSignupDialog();
                Intent i = new Intent(LoginActivity.this, RecuperoPasswordActivity.class);
                startActivity(i);
            }
        });
    }

    private void checkLoginDetails(LoginRequest loginRequest) {
        //Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();
        //final RetrofitInterface api = retrofit.create(RetrofitInterface.class);
        //Call<LoginResponse>
        Call<LoginResponse> call = RetrofitClientInstance.getUserService().login(loginRequest) ;
        Log.d("aa",loginRequest.toString());
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"yes"+response.body().getMail(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"no",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"naao"+t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                Log.e("tag",t.getLocalizedMessage());
            }
        });



    }

    private void getUsuarios(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        Call<List<Usuario>> call = retrofitInterface.getUsuarios();

        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if(!response.isSuccessful()){
                    //aca podemos controlar que hacer segun el response code.
                    txtUser.setText("Codigo: "+ response.code());
                    return;
                }
                List<Usuario> usuarioList = response.body();

                for(Usuario usuario: usuarioList){
                    String content = "";
                    content += ".  "+ usuario.getFirstName();
                    txtUser.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                txtUser.setText(t.getMessage());
            }
        });

    }

}
