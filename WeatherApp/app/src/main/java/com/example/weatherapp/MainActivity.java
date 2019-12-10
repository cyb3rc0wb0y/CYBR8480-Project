package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.hardware.Sensor;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;


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
                openWeatherAPI();
            }
        });

        final Button buttonPT = findViewById(R.id.buttonPhoneTemp);
        buttonPT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                // Sensor Manager Documentation: https://developer.android.com/reference/android/hardware/SensorManager.html

                // Temp Sensor Documentation: https://developer.android.com/reference/android/hardware/Sensor.html#STRING_TYPE_AMBIENT_TEMPERATURE
                final String STRING_TYPE_AMBIENT_TEMPERATURE = Sensor.STRING_TYPE_AMBIENT_TEMPERATURE;

                // Toast Documentation: https://developer.android.com/guide/topics/ui/notifiers/toasts
                // Toast.makeText(getApplicationContext(), STRING_TYPE_AMBIENT_TEMPERATURE, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "Retrieving Phone Temp...", Toast.LENGTH_LONG).show();

            }
        });

        final Button buttonE = findViewById(R.id.buttonEmail);
        buttonE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                ifttt();
            }
        });

    }

    public void openWeatherAPI() {
        // Volley Request Documentation: https://developer.android.com/training/volley/simple
        final TextView textView = (TextView) findViewById(R.id.text);
        String url = "http://api.openweathermap.org/data/2.5/forecast?id=5074472&APPID=08e7577504c64f1e0ec2f293f880fea5";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        TextView textView = (TextView) findViewById(R.id.textView1);
                        textView.setText(response.toString());
                        //textView.setText("Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("That didn't work!");

                    }
                });
        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

    public void openWeatherAPI2() {
        // Volley Request Documentation: https://developer.android.com/training/volley/simple
        final TextView textView = (TextView) findViewById(R.id.text);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://api.openweathermap.org/data/2.5/forecast?id=5074472&APPID=08e7577504c64f1e0ec2f293f880fea5";
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        textView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    public void ifttt() {
        // Volley Request Documentation: https://developer.android.com/training/volley/simple
        final TextView textView = (TextView) findViewById(R.id.text);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://maker.ifttt.com/trigger/{weather_forecast}/with/key/m5E5SE0CCPXfhFVZ5O7e2Dbm1FxN_9MIJqJAQzvryC";
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        textView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

}
