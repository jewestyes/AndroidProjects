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
    private TextView gravityTextView;
    private TextView magneticTextView;

    private SensorManager sensorManager;
    private Sensor game_rotation;
    private Sensor gravity;
    private Sensor magnetic;

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
        game_rotation =  sensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);
        gravity =  sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        magnetic = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sensor, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gameRotationTextView = getView().findViewById(R.id.gameRotationTextView);
        gravityTextView = getView().findViewById(R.id.gravityTextView);
        magneticTextView = getView().findViewById(R.id.magneticTextView);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this, magnetic,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, game_rotation,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gravity,
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

        }
        if (event.sensor.getType() == Sensor.TYPE_GAME_ROTATION_VECTOR){
            float valueRotation = event.values[0];
            gameRotationTextView.setText("Game rotation: " + valueRotation);
        }
        if (event.sensor.getType() == Sensor.TYPE_GRAVITY){
            float valueGravity = event.values[0];
            gravityTextView.setText("Gravity: "+ valueGravity);
        }
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            float valueMagnetic = event.values[0];
            magneticTextView.setText("Magnetic: "+ valueMagnetic);
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}