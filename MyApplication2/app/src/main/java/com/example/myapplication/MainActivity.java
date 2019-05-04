package com.example.myapplication;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;


import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaplayer;
    AudioManager audioManager;

    boolean x=true;
    public void play_pause(View view){
        if(x){
        mediaplayer.start();
        x=false;
            }
            else{
            mediaplayer.pause();
            x=true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaplayer=MediaPlayer.create(this,R.raw.audio);
        SeekBar controlVolume=(SeekBar)findViewById(R.id.seekBar);
        audioManager=(AudioManager)getSystemService(AUDIO_SERVICE);
        int maxVolume=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        controlVolume.setMax(maxVolume);
        controlVolume.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        controlVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        final SeekBar scrubber=(SeekBar)findViewById(R.id.scrubber);
        scrubber.setMax(mediaplayer.getDuration());
        scrubber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    mediaplayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                
            }
        });
       new Timer().scheduleAtFixedRate(new TimerTask() {
           @Override
           public void run() {
               scrubber.setProgress(mediaplayer.getCurrentPosition());
           }
       },0,1000);

    }
}
