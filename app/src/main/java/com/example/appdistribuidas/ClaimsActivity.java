
package com.example.appdistribuidas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class ClaimsActivity extends AppCompatActivity {

    private ImageView img1Camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claims);
        img1Camera = findViewById(R.id.imageView3);

        img1Camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent: un vinculo entre actividades, origen -> destino
                Intent i = new Intent(ClaimsActivity.this, CameraActivity.class);
                //i.putExtra("nombre",nombre);
                startActivity(i);
            }
        });


    }


}
