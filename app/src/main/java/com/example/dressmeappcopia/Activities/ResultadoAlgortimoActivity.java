package com.example.dressmeappcopia.Activities;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dressmeappcopia.Objetos.Conjunto;
import com.example.dressmeappcopia.R;

public class ResultadoAlgortimoActivity extends AppCompatActivity {
    private Conjunto conjunto;
    private LinearLayout listaPrendas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_algoritmo);
        enlazaControles();
    }

    private void enlazaControles() {
        listaPrendas = (LinearLayout) findViewById(R.id.lista_prendas);

    }

/* TODO: Solucionar problemas varios

    private void hagoCosas() {
        //conjunto = GestorBD.resAlgoritmo(this);


        for (int j = 1; j < conjunto.getSize(); j++) { // empezamos en 1, porque la pos 0 es para el propio ID del conjunto //
            //Voy mostrando todas las prendas por pantalla
            int idPrenda = conjunto.obtenId(j);
            Prenda prenda = GestorBD.Obtener_Prenda(this, idPrenda);
            metodoChavales(prenda);
        }


    }

    void metodoChavales(final Prenda prenda)
    {
        View v = getLayoutInflater().inflate(R.layout.activity_prenda_view, null);

        TextView nombre = (TextView) v.findViewById(R.id.prenda_nombre);
        TextView tipo = (TextView) v.findViewById(R.id.prenda_tipo);
        TextView color = (TextView) v.findViewById(R.id.prenda_color);
        TextView talla = (TextView) v.findViewById(R.id.prenda_talla);



        String tipoText = GestorBD.Dar_Tipo(this, prenda.tipo);
        String tallaText = GestorBD.Dar_Talla(this, prenda.talla);

        nombre.setText(prenda.nombre);
        tipo.setText(tipoText);
        color.setText(prenda.color);
        talla.setText(tallaText);

        TableLayout t = (TableLayout) v.findViewById(R.id.boton_prenda);


        listaPrendas.addView(v);
    }
*/


}