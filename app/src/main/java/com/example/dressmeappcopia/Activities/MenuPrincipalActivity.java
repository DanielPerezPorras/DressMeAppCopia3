package com.example.dressmeappcopia.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dressmeappcopia.R;

public class MenuPrincipalActivity extends AppCompatActivity {

    Button bVestuario, bRecomendador, bConfiguracion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        bVestuario = (Button) findViewById(R.id.boton_vestuario);
        bRecomendador = (Button) findViewById(R.id.boton_recomendador);
        bConfiguracion = (Button) findViewById(R.id.boton_configuracion);

        bVestuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ir_a_vestuario();
            }
        });

        bRecomendador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ir_a_recomendador();
            }
        });

        bConfiguracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ir_a_configuracion();
            }
        });
    }

    void ir_a_vestuario()
    {
        Intent vestuario = new Intent(this, VestuarioActivity.class);
        startActivity(vestuario);
    }

    void ir_a_recomendador()
    {
        Intent recomendador = new Intent(this, RecomendadorActivity.class);
        startActivity(recomendador);
    }

    void ir_a_configuracion()
    {
        Intent configuracion = new Intent(this, ConfiguracionActivity.class);
        startActivity(configuracion);
    }
}
