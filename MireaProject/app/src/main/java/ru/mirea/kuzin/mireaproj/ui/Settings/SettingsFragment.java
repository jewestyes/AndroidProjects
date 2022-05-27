package ru.mirea.kuzin.mireaproj.ui.Settings;

import android.os.Bundle;
import android.widget.Toast;
import androidx.preference.PreferenceFragmentCompat;
import ru.mirea.kuzin.mireaproj.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

        Toast.makeText(getContext(), "These are your settings", Toast.LENGTH_SHORT).show();
    }
}