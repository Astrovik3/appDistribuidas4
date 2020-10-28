
package com.example.appdistribuidas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;


public class ClaimsActivity extends AppCompatActivity {

    ImageView imgCamera1;
    ImageView imgCamera2;
    ImageView imgCamera3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claims);
        imgCamera1 = findViewById(R.id.imageView3);
        imgCamera2 = findViewById(R.id.imageView4);
        imgCamera3 = findViewById(R.id.imageView5);

        imgCamera1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent: un vinculo entre actividades, origen -> destino
                Intent i = new Intent(ClaimsActivity.this, CameraActivity.class);
                //i.putExtra("nombre",nombre);
                startActivity(i);
            }
        });
        imgCamera2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ClaimsActivity.this, CameraActivity.class);
                startActivity(i);
            }
        });
        imgCamera3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ClaimsActivity.this, CameraActivity.class);
                startActivity(i);
            }
        });







    }


}
