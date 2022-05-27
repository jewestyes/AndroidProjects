package ru.mirea.kuzin.mireaproj.ui.Audio;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;
import java.io.IOException;

public class AudioService extends Service {
    private MediaPlayer mediaPlayer;

    public AudioService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate(){
        String audioFile = Environment.getExternalStorageDirectory() + "/mirea.3gp";

        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(audioFile);
            mediaPlayer.prepare();
            mediaPlayer.setLooping(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        mediaPlayer.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        mediaPlayer.stop();
    }
}