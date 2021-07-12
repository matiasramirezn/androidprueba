package com.csto.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

    }

    public void ins(View v){
        Intent I = new Intent(getApplicationContext(),MainActivity4.class);
        startActivity(I);
    }

    public void mos(View v){
        Intent I = new Intent(getApplicationContext(),MainActivity5.class);
        startActivity(I);
    }

}