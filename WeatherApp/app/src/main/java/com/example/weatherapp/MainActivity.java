package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.hardware.Sensor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button Documentation: https://developer.android.com/reference/android/widget/Button
        final Button buttonOW = findViewById(R.id.buttonOpenWeather);
        buttonOW.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                // Volley Request Documentation: https://developer.android.com/training/volley/simple
            }
        });

        final Button buttonPT = findViewById(R.id.buttonPhoneTemp);
        buttonPT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Sensor Manager Documentation: https://developer.android.com/reference/android/hardware/SensorManager.html

                // Temp Sensor Documentation: https://developer.android.com/reference/android/hardware/Sensor.html#STRING_TYPE_AMBIENT_TEMPERATURE
                final String STRING_TYPE_AMBIENT_TEMPERATURE = Sensor.STRING_TYPE_AMBIENT_TEMPERATURE;

                // Toast Documentation: https://developer.android.com/guide/topics/ui/notifiers/toasts
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
