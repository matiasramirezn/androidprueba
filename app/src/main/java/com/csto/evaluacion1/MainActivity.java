package com.csto.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText correo;
    EditText contra;
    Button btn_acceder;
    Button btn_registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correo = (EditText)findViewById(R.id.correo);
        contra = (EditText)findViewById(R.id.clave);
        btn_acceder = (Button)findViewById(R.id.boton_acceder);
        btn_registro = (Button)findViewById(R.id.boton_registro);

    }

    public void registro(View v){

        Intent I = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(I);

    }

    public void ingreso(View v){

        String corre = correo.getText().toString();
        String cla = contra.getText().toString();

        String nombre = getIntent().getStringExtra("nombre");
        String cor = getIntent().getStringExtra("correo");
        String con = getIntent().getStringExtra("clave");
        String reg = getIntent().getStringExtra("region");

        if(corre.equals(cor) && cla.equals(con)){
            Intent I = new Intent(getApplicationContext(),Main3Activity.class);
            I.putExtra("nombre",nombre);
            I.putExtra("region",reg);
            startActivity(I);
        }else{
            Toast.makeText(getApplicationContext(),"CORREO O CONTRASEÑA INCORRECTO",Toast.LENGTH_LONG).show();
        }
    }

    public void vermapa(View v){
        Intent I = new Intent(getApplicationContext(),MainActivity2.class);
        startActivity(I);
    }

}
