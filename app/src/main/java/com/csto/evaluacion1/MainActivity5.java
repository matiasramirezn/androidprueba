package com.csto.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    Button boton_volver;
    ListView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        boton_volver = (Button)findViewById(R.id.vol);
        listado = (ListView)findViewById(R.id.lv);

        ArrayList<String>ciudades = new ArrayList<String>();
        ArrayList<Integer>ciudades_pk = new ArrayList<Integer>();

        SQLiteDatabase db;
        DbHelper Conn = new DbHelper(getApplicationContext());
        db = Conn.getWritableDatabase();
        Cursor C = db.query("ciudades_chile",null,null,null,null,null,null);
        if(C!=null){
            if(C.moveToFirst()){
                do{
                    ciudades_pk.add(C.getInt(0));
                    String info = C.getString(1)+" - "+C.getInt(2);
                    ciudades.add(info);
                }
                while(C.moveToNext());
            }
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,ciudades);

        listado.setAdapter(adaptador);

        boton_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(I);
            }
        });

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = listado.getItemAtPosition(position).toString();
                Integer pk = ciudades_pk.get(position);
                Intent I = new Intent(getApplicationContext(),MainActivity6.class);
                I.putExtra("pk",pk+"");
                startActivity(I);
            }
        });

    }
}