package ru.mirea.kuzin.mireaproj.ui.Music;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import ru.mirea.kuzin.mireaproj.R;

public class MusicPlayer extends Fragment {
    Button playButton;
    boolean musicPlay = false;
    View myGif;
    public MusicPlayer() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_player, container, false);
        playButton = view.findViewById(R.id.button);
        playButton.setOnClickListener(view1 -> PlayOrStopMusic());
        myGif = (view.findViewById(R.id.gifka));
        myGif.setVisibility(view.INVISIBLE);
        return view;
    }


    // Music Player
    public void onClickPlayMusic() {
        getActivity().startService(
                new Intent(getActivity(), MusicService.class));
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getActivity().findViewById(R.id.gifka).setVisibility(View.VISIBLE);
            }
        }, 4400);

    }
    public void onClickStopMusic() {
        getActivity().stopService(
                new Intent(getActivity(), MusicService.class));
        myGif.setVisibility(getView().INVISIBLE);
    }

    public  void  PlayOrStopMusic(){
        if (!musicPlay){
            onClickPlayMusic();
            musicPlay = true;
            playButton.setText("Stop");
        }
        else{
            onClickStopMusic();
            musicPlay = false;
            playButton.setText("Play");
        }
    }


    public void Method(View view) {
        if (!musicPlay){
            onClickPlayMusic();
            musicPlay = true;
            playButton.setText("Stop");
        }
        else{
            onClickStopMusic();
            musicPlay = false;
            playButton.setText("Play");
        }
    }
}