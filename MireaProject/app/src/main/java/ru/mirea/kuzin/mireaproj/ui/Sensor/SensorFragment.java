package ru.mirea.kuzin.mireaproj.ui.Sensor;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.mirea.kuzin.mireaproj.R;

public class SensorFragment extends Fragment implements SensorEventListener{
    private Activity mActivity;

    private TextView gameRotationTextView;
    private TextView lightTextView;
    private TextView stepsTextView;

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private Sensor lightValues;
    private Sensor steps;

    public SensorFragment() {
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorManager = (SensorManager) this.getActivity().getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        lightValues =  sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        steps =  sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sensor, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gameRotationTextView = getView().findViewById(R.id.gameRotationTextView);
        lightTextView = getView().findViewById(R.id.gravityTextView);
        stepsTextView = getView().findViewById(R.id.magneticTextView);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometerSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, lightValues,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, steps,
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float valueAccelometer = event.values[0];
            gameRotationTextView.setText("Accelerometer: " + valueAccelometer);
        }
        if (event.sensor.getType() == Sensor.TYPE_LIGHT){
            float lightValue = event.values[0];
            lightTextView.setText("Light value: "+ lightValue);
        }

        if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER){
            float stepsValue = event.values[0];
            stepsTextView.setText("steps value: "+ stepsValue);
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}