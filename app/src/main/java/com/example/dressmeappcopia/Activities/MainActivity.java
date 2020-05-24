package com.example.dressmeappcopia.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dressmeappcopia.BaseDatos.GestorBD;
import com.example.dressmeappcopia.R;
import com.example.dressmeappcopia.TestColorPicker;

public class MainActivity extends AppCompatActivity {

    private TextView textError;
    private EditText textNombre;
    private EditText textContrasenia;
    private Button btnLogin;
    private Button btnRegistro;
    private Button btnTestColorPicker;

    private Context contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enlazarControles();
        GestorBD.seleccionarBD("testcombocolor2.db");
    }

    private void enlazarControles() {

        textError = findViewById(R.id.textError);
        textError.setText("COPIA");
        textNombre = findViewById(R.id.textNombre);
        textContrasenia = findViewById(R.id.textContrasenia);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //irAMenuPrincipal();
                //quitarTeclado(v);
                // aqui pongo lo que hace el boton
                login(textNombre.getText().toString(), textContrasenia.getText().toString());
            }
        });

        btnRegistro = findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irARegistro();
            }
        });

        btnTestColorPicker = findViewById(R.id.btnTestColorPicker);
        btnTestColorPicker.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                irATestColorPicker();
            }
        });

        contexto = getApplicationContext();

    }

    private void irAMenuPrincipal() {

        Intent nuevaActividad = new Intent(this, MenuPrincipalActivity.class);
        startActivity(nuevaActividad);
        finish();
    }
    private void irARegistro(){
        Intent nuevaActividad = new Intent(this, RegistroActivity.class);
        startActivity(nuevaActividad);
        finish();
    }
    private void irATestColorPicker() {
        Intent nuevaActividad = new Intent(this, TestColorPicker.class);
        startActivity(nuevaActividad);
    }

    private void login(String usuario, String pass) {

        String error = "";
        boolean ok = true;

        if (!GestorBD.UsuarioEstaEnBD(getApplicationContext(), usuario)) {
            ok = false;
            error = getString(R.string.login_incorrecto_usuario);
        } else if (!GestorBD.PassCorrecta(getApplicationContext(), usuario, pass)) {
            ok = false;
            error = getString(R.string.login_incorrecto_pass);
        }

        if (ok) {
            GestorBD.setIdPerfil(GestorBD.IdPerfilAsociado(getApplicationContext(), usuario, pass));
            irAMenuPrincipal();
        } else {
            textError.setText(error);
        }


    }



}
