package com.example.basicphrase;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public void phrase(View view){
        Button button=(Button)view;
        Log.i("info",button.getTag().toString());
        MediaPlayer mediaplayer=MediaPlayer.create(this,getResources().getIdentifier(button.getTag().toString(),"raw",getPackageName()));
        mediaplayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
