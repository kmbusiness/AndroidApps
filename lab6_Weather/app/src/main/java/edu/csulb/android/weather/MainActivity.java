package edu.csulb.android.weather;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
{

    private SensorManager sensorManager;
    private TextView temperatureTextView;
    private TextView pressureTextView;
    private TextView lightTextView;

    private float currentTemperature = Float.NaN;
    private float currentPressure = Float.NaN;
    private float currentLight = Float.NaN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureTextView = (TextView) findViewById(R.id.temperature_text);
        pressureTextView = (TextView) findViewById(R.id.pressure_text);
        lightTextView = (TextView) findViewById(R.id.light_text);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        Timer updateTimer = new Timer("weatherUpdate");
        updateTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateGUI();
            }
        }, 0, 1000);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (lightSensor != null) {
            sensorManager.registerListener(lightSensorEventListener, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            lightTextView.setText("Light Sensor Unavailable");
        }

        Sensor pressureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if (pressureSensor != null) {
            sensorManager.registerListener(pressureSensorEventListener, pressureSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            pressureTextView.setText("Pressure Sensor Unavailable");
        }

        Sensor temperatureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (temperatureSensor != null) {
            sensorManager.registerListener(tempSensorEventListener, temperatureSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else {
            temperatureTextView.setText("Temperature Sensor Unavailable");
        }
    }

    @Override
    protected void onPause() {
        sensorManager.unregisterListener(pressureSensorEventListener);
        sensorManager.unregisterListener(tempSensorEventListener);
        sensorManager.unregisterListener(lightSensorEventListener);
        super.onPause();
    }

    private void updateGUI() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (!Float.isNaN(currentPressure)) {
                    pressureTextView.setText(currentPressure + "(mBars)");
                    pressureTextView.invalidate();
                }
                if (!Float.isNaN(currentLight)) {
                    String lightStr = "Sunny";
                    if (currentLight <= SensorManager.LIGHT_CLOUDY) {
                        lightStr = "Night";
                    }
                    else if (currentLight <= SensorManager.LIGHT_OVERCAST) {
                        lightStr = "Cloudy";
                    }
                    else if (currentLight <= SensorManager.LIGHT_SUNLIGHT) {
                        lightStr = "Overcast";
                    }
                    lightTextView.setText(lightStr);
                    lightTextView.invalidate();
                }
                if (!Float.isNaN(currentTemperature)) {
                    temperatureTextView.setText(currentTemperature + "C");
                    temperatureTextView.invalidate();
                }
            }
        });
    }

    private final SensorEventListener tempSensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            currentTemperature = event.values[0];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    private final SensorEventListener pressureSensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            currentPressure = event.values[0];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    private final SensorEventListener lightSensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            currentLight = event.values[0];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
}
