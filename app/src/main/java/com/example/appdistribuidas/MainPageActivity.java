
package com.example.appdistribuidas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainPageActivity extends AppCompatActivity {

    private TextView txtMessage;
    private Button btnCamera;
    private Button newWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        txtMessage = findViewById(R.id.txtMessage);
        btnCamera = findViewById(R.id.btnCamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Intent: un vinculo entre actividades, origen -> destino
                Intent i = new Intent(MainPageActivity.this, CameraActivity.class);
                //i.putExtra("nombre",nombre);
                startActivity(i);
            }
        });

        newWindow = findViewById(R.id.window1);
        newWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent: un vinculo entre actividades, origen -> destino
                Intent j = new Intent(MainPageActivity.this, ClaimsActivity.class);
                startActivity(j);
            }
        });

        String nombre = getIntent().getStringExtra("nombre");
        txtMessage.setText("Bienvenido "+ nombre);
    }



}