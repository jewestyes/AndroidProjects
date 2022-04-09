package ru.mirea.kuzin.intentapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeGet extends Activity {

    TextView timeTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.timeget_layout);
        timeTextView = (TextView) findViewById(R.id.realTime);
        timeTextView.setText(getIntent().getStringExtra("time"));
    }
}
