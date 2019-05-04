package com.example.videoandaudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView videoview=(VideoView)findViewById(R.id.videoView);
        videoview.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.demo);
        MediaController mediacontrol=new MediaController(this);
        mediacontrol.setAnchorView(videoview);
        videoview.setMediaController(mediacontrol);

        videoview.start();
    }
}
