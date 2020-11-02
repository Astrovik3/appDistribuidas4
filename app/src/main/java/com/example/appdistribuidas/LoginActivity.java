package com.example.appdistribuidas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        btnOlvidoPass = findViewById(R.id.btnOlvidoPassword);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
     //           handleLoginDialog();
                String name = txtUser.getText().toString();
                if(name.isEmpty())
                    name = "Extraño";

                // Intent: un vinculo entre actividades, origen -> destino
                Intent i = new Intent(LoginActivity.this, MainPageActivity.class);
                i.putExtra("name",name);
                startActivity(i);
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
                    content += ".  "+ usuario.getNombre();
                    txtUser.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                txtUser.setText(t.getMessage());
            }
        });

    }
/*
    private void handleSignupDialog() {
    }

    private void handleLoginDialog() {
        //creo que esto es al pedo, despues veo
        View view = getLayoutInflater().inflate(R.layout.activity_login, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view).show();
        final Button loginBtn = view.findViewById(R.id.btnAccept);
        final EditText emailEdit = view.findViewById(R.id.txtUser);
        final EditText passwordEdit = view.findViewById(R.id.editTextTextPassword);

        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                HashMap<String, String> map = new HashMap<>();

                map.put("email", emailEdit.getText().toString());
                map.put("password",passwordEdit.getText().toString());

                Call<LoginResult> call = retrofitInterface.executeLogin(map);
                call.enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                        if(response.code() == 200){
                            LoginResult result = response.body();
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(LoginActivity.this);
                            builder1.setTitle(result.getName());
                            builder1.setMessage(result.getEmail());

                            builder1.show();
                        }else if(response.code()== 404){
                            Toast.makeText(LoginActivity.this, "wrong", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
    */
}
