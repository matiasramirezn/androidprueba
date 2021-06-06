package com.csto.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.csto.evaluacion1.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity2 extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Spinner s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        s = (Spinner)findViewById(R.id.spinner3);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

    }

    public void irmapa(View v){

        if(s.getSelectedItemPosition()==1) {

            LatLng TALCA = new LatLng(-35.427570, -71.653859);
            mMap.addMarker(new MarkerOptions().position(TALCA).title("TALCA"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(TALCA));
            mMap.moveCamera(CameraUpdateFactory.zoomTo(14));

        }else {
            if (s.getSelectedItemPosition()==2) {

                LatLng PICHILEMU = new LatLng(-34.391038, -72.013569);
                mMap.addMarker(new MarkerOptions().position(PICHILEMU).title("PICHILEMU"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(PICHILEMU));
                mMap.moveCamera(CameraUpdateFactory.zoomTo(14));

            }else {
                if (s.getSelectedItemPosition()==3) {

                    LatLng VILCHES = new LatLng(-35.573216, -71.167487);
                    mMap.addMarker(new MarkerOptions().position(VILCHES).title("VILCHES"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(VILCHES));
                    mMap.moveCamera(CameraUpdateFactory.zoomTo(14));

                }
            }
        }
    }

}