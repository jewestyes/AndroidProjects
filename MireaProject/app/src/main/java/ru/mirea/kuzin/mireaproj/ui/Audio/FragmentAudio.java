package ru.mirea.kuzin.mireaproj.ui.Audio;

import android.Manifest;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.io.File;

import ru.mirea.kuzin.mireaproj.R;


public class FragmentAudio extends Fragment {
    private static int MICROPHONE_PERMISSION = 200;
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = (ConstraintLayout)inflater.inflate(R.layout.fragment_audio, container, false);

        Button btnPlay = (Button) v.findViewById(R.id.btnPlay);
        Button btnStop = (Button) v.findViewById(R.id.btnStop);
        Button bntRecord = (Button) v.findViewById(R.id.btnRecord);

        if(isMicrophonePresent())
        {
            getMicrophonePermission();
        }
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setDataSource(getRecordingFilePath());
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                    Toast.makeText(getActivity(), "Recording is Playing", Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaRecorder.stop();
                mediaRecorder.release();
                mediaRecorder = null;
                Toast.makeText(getActivity(), "Recording is Stoped", Toast.LENGTH_LONG).show();
            }
        });
        bntRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mediaRecorder = new MediaRecorder();
                    mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    mediaRecorder.setOutputFile(getRecordingFilePath());
                    mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                    mediaRecorder.prepare();
                    mediaRecorder.start();
                    Toast.makeText(getActivity(), "Recording is Started", Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        return v;
    }
    private boolean isMicrophonePresent(){
        return getActivity().getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE);
    }
    private void getMicrophonePermission(){
        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.RECORD_AUDIO},MICROPHONE_PERMISSION);
        }
    }
    private String getRecordingFilePath(){
        ContextWrapper contextWrapper = new ContextWrapper(getContext());
        File musicDirectory = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File file = new File(musicDirectory,"testRecordingFile" + ".mp3");
        return file.getPath();
    }
}