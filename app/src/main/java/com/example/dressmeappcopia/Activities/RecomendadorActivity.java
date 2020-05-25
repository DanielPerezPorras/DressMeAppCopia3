package com.example.dressmeappcopia.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dressmeappcopia.R;

public class RecomendadorActivity extends AppCompatActivity {
    private Button bRecomendador;
    private Button bHistorial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_recomendador);
           enlazaControles();
    }
    private void enlazaControles(){
        bRecomendador= findViewById(R.id.bRecomendador);
        bHistorial = findViewById(R.id.bHistorial);

        bRecomendador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saltoAlgoritmo();
            }
        });
        bHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saltoHistorial();
            }
        });
    }
    private void saltoAlgoritmo(){
        Intent salto = new Intent(this,AlgoritmoRecomendador.class);
        startActivity(salto);
    }
    private  void saltoHistorial(){
        Intent saltoH = new Intent(this,HistorialActivity.class);
        startActivity(saltoH);
    }
}
