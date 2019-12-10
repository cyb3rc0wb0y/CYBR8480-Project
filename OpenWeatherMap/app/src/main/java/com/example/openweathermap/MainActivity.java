// Source Code Cite: https://www.androdocs.com/java/creating-an-android-weather-app-using-java.html

package com.example.openweathermap;

import android.hardware.Sensor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androdocs.httprequest.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String CITY = "omaha,us";
    String API = "08e7577504c64f1e0ec2f293f880fea5";

    TextView addressTxt, updated_atTxt, statusTxt, tempTxt, temp_minTxt, temp_maxTxt, sunriseTxt,
            sunsetTxt, windTxt, pressureTxt, humidityTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addressTxt = findViewById(R.id.address);
        updated_atTxt = findViewById(R.id.updated_at);
        statusTxt = findViewById(R.id.status);
        tempTxt = findViewById(R.id.temp);
        temp_minTxt = findViewById(R.id.temp_min);
        temp_maxTxt = findViewById(R.id.temp_max);
        sunriseTxt = findViewById(R.id.sunrise);
        sunsetTxt = findViewById(R.id.sunset);
        windTxt = findViewById(R.id.wind);
        pressureTxt = findViewById(R.id.pressure);
        humidityTxt = findViewById(R.id.humidity);

        // new weatherTask().execute();

        // Source Code Cite: https://guides.codepath.com/android/Repeating-Periodic-Tasks
        // Documentation For Handler: https://developer.android.com/reference/android/os/Handler#postDelayed(java.lang.Runnable,%20long)
        // Updates every minute, however free service updates < 2 hours so updates may be sparse
        final Handler handler = new Handler();
        // Define the code block to be executed
        Runnable runnableCode = new Runnable() {
            @Override
            public void run() {
                new weatherTask().execute();
                handler.postDelayed(this, 100000);
            }
        };
        handler.post(runnableCode);

        final Button buttonPT = findViewById(R.id.button_temp);
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

    }

    class weatherTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            /* Showing the ProgressBar, Making the main design GONE */
            findViewById(R.id.loader).setVisibility(View.VISIBLE);
            findViewById(R.id.mainContainer).setVisibility(View.GONE);
            findViewById(R.id.errorText).setVisibility(View.GONE);
        }

        protected String doInBackground(String... args) {
            String response = HttpRequest.excuteGet("https://api.openweathermap.org/data/2.5/weather?q=" + CITY + "&units=imperial&appid=" + API);
            return response;
        }

        @Override
        protected void onPostExecute(String result) {


            try {
                JSONObject jsonObj = new JSONObject(result);
                JSONObject main = jsonObj.getJSONObject("main");
                JSONObject sys = jsonObj.getJSONObject("sys");
                JSONObject wind = jsonObj.getJSONObject("wind");
                JSONObject weather = jsonObj.getJSONArray("weather").getJSONObject(0);

                Long updatedAt = jsonObj.getLong("dt");
                String updatedAtText = "Updated at: " + new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(new Date(updatedAt * 1000));
                String hookTemp = main.getString("temp");
                String temp = main.getString("temp") + "°F";
                String hookMin = main.getString("temp_min");
                String tempMin = "Min Temp: " + main.getString("temp_min") + "°F";
                String hookMax = main.getString("temp_max");
                String tempMax = "Max Temp: " + main.getString("temp_max") + "°F";
                String pressure = main.getString("pressure");
                String humidity = main.getString("humidity");

                Long sunrise = sys.getLong("sunrise");
                Long sunset = sys.getLong("sunset");
                String windSpeed = wind.getString("speed");
                String weatherDescription = weather.getString("description");

                String address = jsonObj.getString("name") + ", " + sys.getString("country");

                String webhook = "https://maker.ifttt.com/trigger/weather_forecast/with/key/oTQhwYJ4LQ1q65WjFyHCLx8YX98NYkHlBRaIrOGw5Pr?value1=" + hookTemp + "&value2=" + hookMin + "&value3=" + hookMax;
                Toast.makeText(getApplicationContext(), "Sending Email Notification...", Toast.LENGTH_LONG).show();
                HttpRequest.excuteGet(webhook);

                //String test = HttpRequest.excuteGet("https://maker.ifttt.com/trigger/weather_forecast/with/key/oTQhwYJ4LQ1q65WjFyHCLx8YX98NYkHlBRaIrOGw5Pr?value1=" + hookTemp + "&value2=" + hookMin + "&value3=" + hookMax);

                /* Populating extracted data into our views */
                addressTxt.setText(address);
                updated_atTxt.setText(updatedAtText);
                statusTxt.setText(weatherDescription.toUpperCase());
                tempTxt.setText(temp);
                temp_minTxt.setText(tempMin);
                temp_maxTxt.setText(tempMax);
                sunriseTxt.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunrise * 1000)));
                sunsetTxt.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunset * 1000)));
                windTxt.setText(windSpeed);
                pressureTxt.setText(pressure);
                humidityTxt.setText(humidity);

                /* Views populated, Hiding the loader, Showing the main design */
                findViewById(R.id.loader).setVisibility(View.GONE);
                findViewById(R.id.mainContainer).setVisibility(View.VISIBLE);


            } catch (JSONException e) {
                findViewById(R.id.loader).setVisibility(View.GONE);
                findViewById(R.id.errorText).setVisibility(View.VISIBLE);
            }

        }
    }
}