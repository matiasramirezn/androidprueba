package com.csto.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {
    EditText texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        texto = (EditText)findViewById(R.id.texto);

        String nombrecito = getIntent().getStringExtra("nombre");
        String reg = getIntent().getStringExtra("region");

        texto.setText(nombrecito+" de la region "+reg);
    }
}

