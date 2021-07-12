package com.csto.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLData;

public class MainActivity4 extends AppCompatActivity {

    EditText ciudad, n_region;
    Button ingresar, volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        ciudad = (EditText)findViewById(R.id.txt_ciudad);
        n_region = (EditText)findViewById(R.id.region);

        ingresar = (Button)findViewById(R.id.btn_ingresar);
        volver = (Button)findViewById(R.id.btn_volver);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db;
                DbHelper Conn = new DbHelper(getApplicationContext());
                db = Conn.getWritableDatabase();
                ContentValues CV = new ContentValues();
                CV.put("nombre_ciudad",ciudad.getText().toString());
                CV.put("region",Integer.parseInt(n_region.getText().toString()));
                db.insert("ciudades_chile",null,CV);
                Toast.makeText(getApplicationContext(),"Registro Ingresado",Toast.LENGTH_SHORT).show();
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(I);
            }
        });

    }
}