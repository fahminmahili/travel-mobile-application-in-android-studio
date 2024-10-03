package com.example.fegetravelmobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView stepCounterView, caloriesView, distanceView;
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Button startButton, stopButton;
    private boolean isMeasuring = false;
    private int stepCount = 0;
    private double totalDistance = 0; // in kilometers
    private double totalCalories = 0; // in kcal

    private float lastY, lastZ;
    private final float STEP_THRESHOLD = 1.2f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stepCounterView = findViewById(R.id.stepCounterView);
        caloriesView = findViewById(R.id.caloriesView);
        distanceView = findViewById(R.id.distanceView);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        startButton.setOnClickListener(v -> {
            startMeasurement();
        });

        stopButton.setOnClickListener(v -> {
            stopMeasurement();
        });

        // Initially, the stop button is not visible
        stopButton.setVisibility(View.GONE);

        Button viewMapButton = findViewById(R.id.viewMapButton);
        viewMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });


        Button backToHomeButton = findViewById(R.id.backToHomeButton);
        backToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                // Consider clearing the top of the stack to prevent back navigation to MainActivity
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }


    private void startMeasurement() {
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            isMeasuring = true;
            startButton.setVisibility(View.GONE);
            stopButton.setVisibility(View.VISIBLE);
            resetMeasurements();
        } else {
            stepCounterView.setText("Accelerometer is not available!");
        }
    }

    private void stopMeasurement() {
        if (isMeasuring) {
            sensorManager.unregisterListener(this, accelerometer);
            isMeasuring = false;
            startButton.setVisibility(View.VISIBLE);
            stopButton.setVisibility(View.GONE);
        }
    }

    private void resetMeasurements() {
        stepCount = 0;
        totalDistance = 0;
        totalCalories = 0;
        updateUI();
    }

    private void updateUI() {
        stepCounterView.setText(String.format("Steps: %d", stepCount));
        distanceView.setText(String.format("Distance: %.2f km", totalDistance));
        caloriesView.setText(String.format("Calories: %.2f kcal", totalCalories));
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER && isMeasuring) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            float accelerationMagnitude = (float) Math.sqrt(x*x + y*y + z*z) - SensorManager.GRAVITY_EARTH;
            if (accelerationMagnitude > STEP_THRESHOLD) {
                stepCount++;
                totalDistance += 0.0008; // Approx. 0.8 meters per step
                totalCalories += 0.05; // Roughly 0.05 kcal per step
                updateUI();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not used in this context
    }
}




