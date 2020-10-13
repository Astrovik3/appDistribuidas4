package com.example.appdistribuidas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button btnAccept;
    private EditText txtUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnAccept = findViewById(R.id.btnAccept);
        txtUser = findViewById(R.id.txtUser);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtUser.getText().toString();

                if(name.isEmpty())
                    name = "Extraño";

                // Intent: un vinculo entre actividades, origen -> destino
                Intent i = new Intent(LoginActivity.this, MainPageActivity.class);
                i.putExtra("name",name);
                startActivity(i);
            }
        });
    }
}
