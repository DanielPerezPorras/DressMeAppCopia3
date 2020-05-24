package com.example.dressmeappcopia;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class TestColorPicker extends AppCompatActivity {

    private int rojo;
    private int verde;
    private int azul;

    private SeekBar barRojo;
    private SeekBar barVerde;
    private SeekBar barAzul;
    private ImageView imgColor;

    private TextView txtRGB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_color_picker);
        enlazarControles();
    }

    private void enlazarControles() {

        barRojo = findViewById(R.id.barRojo);
        barVerde = findViewById(R.id.barVerde);
        barAzul = findViewById(R.id.barAzul);
        imgColor = findViewById(R.id.imgColor);
        txtRGB = findViewById(R.id.txtRGB);

        barRojo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setRojo(progress);
                mostrarColor();
                actualizarImgColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
        barVerde.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setVerde(progress);
                mostrarColor();
                actualizarImgColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
        barAzul.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setAzul(progress);
                mostrarColor();
                actualizarImgColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

    }

    private void setRojo(int val) { rojo = val; }
    private void setVerde(int val) { verde = val; }
    private void setAzul(int val) { azul = val; }

    private void actualizarImgColor() {
        String hex = String.format("#%02X%02X%02X", rojo, verde, azul);
        imgColor.setBackgroundColor(Color.parseColor(hex));
    }

    private void mostrarColor() {
        String str = "rgb(" + rojo + ", " + verde + ", " + azul + ")";
        String hex = String.format("#%02X%02X%02X", rojo, verde, azul);
        txtRGB.setText(str + " " + hex);
    }

}
