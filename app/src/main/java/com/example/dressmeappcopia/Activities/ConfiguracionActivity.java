package com.example.dressmeappcopia.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dressmeappcopia.R;

public class ConfiguracionActivity extends AppCompatActivity {
    private TextView textView ;
    private Button botonCambioTallas;
    private Button botonCambioPrendas;
    private Button botonTipoColor;
    private Button botonCambioPerfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        enlazaControles();
    }

    private void enlazaControles() {
        textView=findViewById(R.id.textView4);
        botonCambioPerfil=findViewById(R.id.botonCambioPerfil);
        botonCambioTallas=findViewById(R.id.botonCambioTallas);
        botonTipoColor=findViewById(R.id.botonTipoColor);
        botonCambioPrendas=findViewById(R.id.botonCambioPrendas);

        botonCambioPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiaPerfil();
            }
        });
        botonTipoColor.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiaColor();
            }
        }));
        botonCambioTallas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambioTallas();
            }
        });
        botonCambioPrendas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambioPrendas();
            }
        });

    }

    private void cambioPrendas() {
    Intent cambio = new Intent(this,CambioPrendasActivity.class);
    startActivity(cambio);
    }

    private void cambioTallas() {
    Intent cambio = new Intent(this,CambioTallasActivity.class);
    startActivity(cambio);
    }

    private void cambiaColor() {
        Intent cambio = new Intent(this,CambioColorActivity.class);
        startActivity(cambio);
    }

    private void cambiaPerfil() {
        Intent cambio= new Intent(this,PerfilConfiguracionActivity.class);
        startActivity(cambio);
    }
}
