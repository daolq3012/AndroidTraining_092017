package com.example.sony.training;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    private GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mGoogleMap = googleMap;
                mGoogleMap.moveCamera(
                        CameraUpdateFactory.newLatLngZoom(new LatLng(16.0603583, 108.2161433), 15));
                mGoogleMap.addMarker(
                        new MarkerOptions().position(new LatLng(16.0603583, 108.2071433))
                                .title("Day la marker 1"));
                mGoogleMap.addMarker(
                        new MarkerOptions().position(new LatLng(16.0603684, 108.2071436))
                                .title("Day la marker 2"));

                mGoogleMap.setMapStyle(
                        MapStyleOptions.loadRawResourceStyle(MainActivity.this, R.raw.google_map));
            }
        });
    }
}
