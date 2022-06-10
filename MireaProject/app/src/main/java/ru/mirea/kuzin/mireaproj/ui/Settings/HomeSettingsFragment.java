package ru.mirea.kuzin.mireaproj.ui.Settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import ru.mirea.kuzin.mireaproj.R;

public class HomeSettingsFragment extends Fragment {
    private TextView textView;
    private EditText editText;
    private Button applyTextButton;
    private Button saveButton;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";

    private String text;
    private boolean switchOnOff;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_settings, null);

        textView = (TextView) v.findViewById(R.id.textview);
        editText = (EditText) v.findViewById(R.id.edittext);
        applyTextButton = (Button) v.findViewById(R.id.apply_text_button);
        saveButton = (Button) v.findViewById(R.id.save_button);

        applyTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText().toString());
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        loadData();
        updateViews();

        return v;
    }
    public void saveData() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, textView.getText().toString());
        editor.apply();

        Toast.makeText(getActivity(), "Data saved", Toast.LENGTH_SHORT).show();
    }
    public void loadData() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
    }
    public void updateViews() {
        textView.setText(text);
    }
}