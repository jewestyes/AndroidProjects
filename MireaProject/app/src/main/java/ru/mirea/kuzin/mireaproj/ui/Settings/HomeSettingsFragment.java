package ru.mirea.kuzin.mireaproj.ui.Settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ru.mirea.kuzin.mireaproj.R;

public class HomeSettingsFragment extends Fragment {
    private SharedPreferences preferences;
    TextView tv_signature;
    TextView tv_reply;
    TextView tv_sync;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_settings, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_signature = getView().findViewById(R.id.tv_signature);
        tv_reply = getView().findViewById(R.id.tv_reply);
        tv_sync = getView().findViewById(R.id.tv_sync);
        settings();
    }

    private void settings() {
        preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        String signature = preferences.getString("signature", "");
        String defaultReplyAction = preferences.getString("reply", "");
        boolean sync = preferences.getBoolean("sync", true);

        tv_signature.setText("Signature: "+ signature);
        tv_reply.setText("Default reply: "+ defaultReplyAction);
        tv_sync.setText("Sync: "+ sync);
    }
}