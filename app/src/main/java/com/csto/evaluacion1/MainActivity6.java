package com.csto.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {

    EditText ciudad, region, primary;
    Button btn_modi, btn_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        ciudad = (EditText)findViewById(R.id.ciuda);
        region = (EditText)findViewById(R.id.regi);
        primary = (EditText)findViewById(R.id.PK);
        primary.setEnabled(false);

        btn_modi = (Button)findViewById(R.id.mod);
        btn_volver = (Button)findViewById(R.id.volv);

        Bundle b = getIntent().getExtras();
        String pk = b.get("pk").toString();

        SQLiteDatabase db;
        DbHelper Conn = new DbHelper(getApplicationContext());
        db = Conn.getWritableDatabase();
        String SQL = "select nombre_ciudad, region from ciudades_chile where id_ciudad=?";
        String [] WHERE = {pk};
        Cursor C = db.rawQuery(SQL,WHERE);
        if(C!=null){
            if(C.moveToFirst()){
                ciudad.setText(C.getString(0));
                region.setText(C.getString(1));
            }
        }
        primary.setText(pk);

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver();
            }
        });

        btn_modi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 SQLiteDatabase db;
                 DbHelper Conn = new DbHelper(getApplicationContext());
                 db = Conn.getWritableDatabase();

                 String pri = primary.getText().toString();
                 String city = ciudad.getText().toString();
                 String re = region.getText().toString();

                 String WHERECLAUSE="id_ciudad=?";
                 String [] WHERE = {pri};

                ContentValues CV = new ContentValues();
                CV.put("nombre_ciudad",ciudad.getText().toString());
                CV.put("region",Integer.parseInt(region.getText().toString()));

                 db.update("ciudades_chile",CV,WHERECLAUSE,WHERE);

                Toast.makeText(getApplicationContext(),"CIUDAD ACTUALIZADA CON EXITO",Toast.LENGTH_SHORT).show();

                volver();
            }
        });

    }

    public void volver(){
        Intent I = new Intent(getApplicationContext(),MainActivity5.class);
        startActivity(I);
    }
}