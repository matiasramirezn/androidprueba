package com.csto.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
//algo sasa
public class Main2Activity extends AppCompatActivity {

    EditText nombre;
    EditText rut;
    EditText correo;
    EditText clave1;
    EditText clave2;
    Button btn_registro;
    Spinner region;
    CheckBox aprueba;
    RadioButton masculino;
    RadioButton femenino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre = (EditText)findViewById(R.id.nombre);
        rut = (EditText)findViewById(R.id.rut);
        correo = (EditText)findViewById(R.id.correo);
        clave1 = (EditText)findViewById(R.id.clave1);
        clave2 = (EditText)findViewById(R.id.clave2);
        btn_registro = (Button)findViewById(R.id.boton_registro);
        region = (Spinner)findViewById(R.id.regiones);
        aprueba = (CheckBox)findViewById(R.id.sino);
        masculino = (RadioButton)findViewById(R.id.mas);
        femenino = (RadioButton)findViewById(R.id.fem);

    }

    public void registrar(View v){

        String nom = nombre.getText().toString();
        String ru = rut.getText().toString();
        String cor = correo.getText().toString();
        String cl1 = clave1.getText().toString();
        String cl2 = clave2.getText().toString();
        String sp = region.getSelectedItem().toString();

        if(nom.equals("") || ru.equals("") || cor.equals("") || cl1.equals("") || cl2.equals("")){
            Toast.makeText(getApplicationContext(),"NO DEBEN QUEDAR ESPACIOS EN BLANCO",Toast.LENGTH_LONG).show();
        }else{
            if(cl1.equals(cl2)){
                Log.d("CSTO","usted escribio esto en el cajon nombre: "+nombre);
                Log.d("CSTO","usted escribio esto en el cajon rut: "+ru);
                Log.d("CSTO","usted escribio esto en el cajon correo: "+correo);
                Log.d("CSTO","usted escribio esto en el cajon clave: "+cl1);
                Log.d("CSTO","usted escribio esto en el cajon repetir clave: "+cl2);

                Intent I = new Intent(getApplicationContext(),MainActivity.class);
                I.putExtra("nombre",nom);
                I.putExtra("correo",cor);
                I.putExtra("clave",cl1);
                I.putExtra("region",sp);
                startActivity(I);
            }else{
                Toast.makeText(getApplicationContext(),"LA CONTRASEÑA DEBE SER IGUAL EN AMBOS CAMPOS",Toast.LENGTH_LONG).show();
            }
        }

    }

}
