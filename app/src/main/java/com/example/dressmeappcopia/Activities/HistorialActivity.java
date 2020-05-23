package com.example.dressmeappcopia.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.dressmeappcopia.BaseDatos.GestorBD;
import com.example.dressmeappcopia.Objetos.Conjunto;
import com.example.dressmeappcopia.Objetos.Prenda;
import com.example.dressmeappcopia.R;

import java.util.Collections;
import java.util.List;

public class HistorialActivity extends AppCompatActivity {

        private List<Conjunto> listaConjuntos;
        //Se rellenará usando métodos de GestorBD, y se irán sacando los conjuntos de allí.
        private LinearLayout listaPrendas;
        private TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        enlazaControles();
        hagoCosas();


    }



    private void enlazaControles() {
        listaPrendas = (LinearLayout) findViewById(R.id.lista_prendas);

    }

    private void hagoCosas() {
        listaConjuntos= GestorBD.ConjuntosEnBD(this);
        Collections.reverse(listaConjuntos); // esto voltea la lista
        Conjunto aux;
        int contador=0;
        for(Conjunto c : listaConjuntos){
            contador++;
            //Crear un text view, mostrarlo por pantalla
            metodoMisPanas(contador);
            //Recorro el conjunto y muestro las prendas


            for(int j = 1; j < c.getSize(); j++){ // empezamos en 1, porque la pos 0 es para el propio ID del conjunto //
                //Voy mostrando todas las prendas por pantalla
            int idPrenda= c.obtenId(j);
            Prenda prenda = GestorBD.Obtener_Prenda(this,idPrenda);
            metodoChavales(prenda);
            }
        }


    }

    private void metodoMisPanas(int cont) {
        View v = getLayoutInflater().inflate(R.layout.activity_conjunto_view, null);

        TextView conjunto = (TextView) v.findViewById(R.id.conjuntoView);
        conjunto.setText("CONJUNTO "+cont);
        listaPrendas.addView(v);
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
}
