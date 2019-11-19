package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.hardware.Sensor;

public class MainActivity extends AppCompatActivity {

    // TYPE_AMBIENT_TEMPERATURE
    // public static final int TYPE_AMBIENT_TEMPERATURE= 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonOW = findViewById(R.id.buttonOpenWeather);
        buttonOW.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });

        final Button buttonPT = findViewById(R.id.buttonPhoneTemp);
        buttonPT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String STRING_TYPE_AMBIENT_TEMPERATURE = Sensor.STRING_TYPE_AMBIENT_TEMPERATURE;
                Toast.makeText(getApplicationContext(), STRING_TYPE_AMBIENT_TEMPERATURE, Toast.LENGTH_LONG).show();
            }
        });

        final Button buttonE = findViewById(R.id.buttonEmail);
        buttonE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });

    }



}
