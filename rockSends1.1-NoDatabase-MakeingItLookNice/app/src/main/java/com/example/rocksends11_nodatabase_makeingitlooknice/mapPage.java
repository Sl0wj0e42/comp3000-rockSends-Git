package com.example.rocksends11_nodatabase_makeingitlooknice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class mapPage extends AppCompatActivity implements OnMapReadyCallback {

    public ArrayList<String> coordinatesAll = new ArrayList<String>(), routePlaces = new ArrayList<String>();
    LatLng location;
    Marker locationMarker;
    int markerMaker;
    Button routePlacesButton, mapBtn, logOutBtn;
    Spinner spinnerNumber;
    TableRow routePlacesRows;
    TableLayout routePlacesTable;

    ConstraintLayout constraintLayout3, constraintLayout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_page);

        mapBtn = findViewById(R.id.mapButton);
        mapBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_type_two));
        mapBtn.setTextColor(getResources().getColor(R.color.black));
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Dashboard = new Intent(mapPage.this, mapPage.class);
                startActivity(Dashboard);
            }
        });

        logOutBtn = findViewById(R.id.logOut);
        logOutBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_type_one));
        logOutBtn.setTextColor(getResources().getColor(R.color.honnyOrange));
        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Dashboard = new Intent(mapPage.this, MainActivity.class);
                startActivity(Dashboard);
            }
        });

        constraintLayout3 = findViewById(R.id.constraintLayout3);
        constraintLayout4 = findViewById(R.id.constraintLayout4);
        constraintLayout3.setVisibility(View.INVISIBLE);
        constraintLayout4.setVisibility(View.INVISIBLE);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        double coordinatesLatitude = 0, coordinatesLongitude = 0;
        coordinatesAll = getCoordinatesForMap();

        for(markerMaker=0; markerMaker<coordinatesAll.size(); markerMaker++) {
            String[] coordinates = coordinatesAll.get(markerMaker).split(",");

            coordinatesLatitude = Double.parseDouble(coordinates[0]);
            coordinatesLongitude = Double.parseDouble(coordinates[1]);

            location = new LatLng(coordinatesLatitude, coordinatesLongitude);
            locationMarker = googleMap.addMarker(new MarkerOptions().position(location).title(coordinates[2]));

            coordinatesAll.set(markerMaker, coordinatesAll.get(markerMaker) + "," + locationMarker);

            googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener(){
                @Override
                public boolean onMarkerClick(@NonNull Marker marker) {
                    markerPressed(marker);
                    return false;
                }
            });
        }

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12));
    }

    public ArrayList<String> getCoordinatesForMap(){
        String lc = "50.38672946323083,-4.1528859699520835,Plymouth Life Center - Local Climbing Wall,1234", hoe = "50.36375411643798,-4.140128658419766,Plymouth Hoe - Outdoors Aria,2345", plymHanger = "50.40415494842452,-4.167053371270924,Plymouth Hanger - Local Climbing Wall,3456", devilsPoint = "50.359398,-4.164424, Devils Point - Outdoors Aria,4567";

        coordinatesAll.add(lc);
        coordinatesAll.add(hoe);
        coordinatesAll.add(plymHanger);


        return coordinatesAll;
    }

    private void markerPressed(Marker marker) {
        for (int i=0; i<coordinatesAll.size(); i++){
            String[] coordinatesXnY = coordinatesAll.get(i).split(",");

            String markerStr = marker.toString();

            if ((coordinatesXnY[4].equals(markerStr) && ((coordinatesXnY[3].equals("1234")) || (coordinatesXnY[3].equals("3456"))))){
                viewClimbingLocation(coordinatesXnY, markerStr);
                i = coordinatesAll.size()+1;
            }
            else if (coordinatesXnY[4].equals(markerStr)){
                tableRoutePlaces(coordinatesXnY);
                i = coordinatesAll.size()+1;
            }
        }
    }

    public void tableRoutePlaces(String[] coordinatesXnY){
        constraintLayout3.setVisibility(View.VISIBLE);
        constraintLayout4.setVisibility(View.INVISIBLE);

        routePlaces.add(0, "Waterfront Bar,1234");
        routePlaces.add(1, "Pebble Veach Area,2345");
        routePlaces.add(2, "Artifical walls,3456");
        routePlaces.add(3, "Slabs Area,4567");
        routePlaces.add(4, "Drain Gully Area,5678");
        routePlaces.add(5, "Fastnet Lookout,6789");
        routePlaces.add(6, "Glass Bottom Rock,7890");
        routePlaces.add(7, "Tidal Cave Area,8901");
        routePlaces.add(8, "Artistic Arête,9012");
        routePlaces.add(9, "High Dive Area,0123");

        routePlacesTable = (TableLayout) findViewById(R.id.table_main);

        routePlacesTable.removeAllViews();

        for(int i = 0; i<routePlaces.size(); i++){
            String[] idNButtenName = routePlaces.get(i).split(",");
            routePlacesRows = new TableRow(this);
            spinnerNumber = new Spinner(this);

            routePlacesButton = new Button(this);
            routePlacesButton.setText(" "+idNButtenName[0]+" ");
            routePlacesButton.setGravity(Gravity.CENTER);
            routePlacesButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_type_one));
            routePlacesButton.setTextColor(getResources().getColor(R.color.honnyOrange));
            routePlacesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    buttonPressed(idNButtenName);
                }
            });

            routePlacesRows.addView(routePlacesButton);
            routePlacesRows.addView(spinnerNumber);

            routePlacesTable.addView(routePlacesRows);
        }
    }

    public void viewClimbingLocation(String[] locationSetter, String markerStr){
        constraintLayout3.setVisibility(View.INVISIBLE);
        constraintLayout4.setVisibility(View.VISIBLE);

        ImageView loactionImage = findViewById(R.id.loactionImage);
        TextView locationName = findViewById(R.id.locationName), locationPrice = findViewById(R.id.locationPrice), locationInformation = findViewById(R.id.locationInformation);

        String[] locationNameStr = locationSetter[2].split(" - ");

        if(locationSetter[3].equals("1234")){
            Bitmap plymouthactivelogo = BitmapFactory.decodeResource(getResources(), R.drawable.plymouthactivelogo);
            loactionImage.setImageBitmap(Bitmap.createScaledBitmap(plymouthactivelogo, 1500, 1000, false));

            locationName.setText(locationNameStr[1]);
            locationPrice.setText("£");
            locationInformation.setText("The local ativaty center in\nthe city of plymouth which\nhosts the one of\nthe largest indoor climbing\nwalls in South West\nUk as well as\nan engageing boldering wall.");
        }else if(locationSetter[3].equals("3456")){
            Bitmap hangerlogo = BitmapFactory.decodeResource(getResources(), R.drawable.hangerlogo);
            loactionImage.setImageBitmap(Bitmap.createScaledBitmap(hangerlogo, 1500, 1000, false));

            locationName.setText(locationNameStr[1]);
            locationPrice.setText("££");
            locationInformation.setText("The Hanger Climbing Walls\nare popping up all\naround the country with the\none in plymouth being\nsuch a grate comunity\nwhy not check it\nout.");
        }
    }

    private void buttonPressed(String[] idNButtenName) {
        if(idNButtenName[1].equals("4567") || idNButtenName[1].equals("5678") || idNButtenName[1].equals("6789") || idNButtenName[1].equals("7890")) {
            Intent movePage = new Intent(mapPage.this, routesPage.class);
            movePage.putExtra("tryPullThis", idNButtenName[1]);
            startActivity(movePage);
        } else{
            Toast.makeText(this, "Error: " + idNButtenName[0] + " has no climbs as of now", Toast.LENGTH_SHORT).show();
        }
    }
}