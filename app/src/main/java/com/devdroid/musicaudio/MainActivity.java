package com.devdroid.musicaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btnPlay, btnPause, btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.play);
        btnPause = findViewById(R.id.pause);
        btnStop = findViewById(R.id.stop);

        MediaPlayer player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        // Path from where audio is played
        String audioPath = "android.resource://"+getPackageName()+"/raw/believe";

        // Path is parse in URI
        Uri audioURI = Uri.parse(audioPath);
        try {
            player.setDataSource(this,audioURI);
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.start();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.pause();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.pause();
                player.seekTo(0);
            }
        });
    }

}