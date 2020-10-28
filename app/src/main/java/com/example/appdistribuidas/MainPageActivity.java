package com.example.appdistribuidas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPageActivity extends AppCompatActivity {
    RecyclerView listReclamosPropios;
    String[] claims;
    String[] dates;
    String[] states;
    Button btnCamera;
    Button newWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Resources res = getResources();
        listReclamosPropios = (RecyclerView) findViewById(R.id.listReclamosPropios);
        claims = res.getStringArray(R.array.claims);
        dates = res.getStringArray(R.array.dates);
        states = res.getStringArray(R.array.states);

        MyAdapter myAdapter = new MyAdapter(this, claims, dates, states);
        listReclamosPropios.setAdapter(myAdapter);
        listReclamosPropios.setLayoutManager(new LinearLayoutManager(this));


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


    }



}