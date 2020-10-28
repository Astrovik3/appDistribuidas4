package com.example.appdistribuidas;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecuperoPasswordActivity extends AppCompatActivity {

    public Button btnAceptar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recupero_pass);

        btnAceptar = findViewById(R.id.bttnAceptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RecuperoPasswordActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }

}
