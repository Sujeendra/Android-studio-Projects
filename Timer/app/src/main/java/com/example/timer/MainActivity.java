package com.example.timer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    TextView text;
    SeekBar seekbar;
    Button button;
    CountDownTimer count;
    boolean countactive=false;
    public void control(){
        countactive=false;
        button.setText("GO!");
        seekbar.setProgress(30);
        seekbar.setEnabled(true);
        text.setText("0:30");
        count.cancel();
    }
    public void gobutton(View view){
        if(countactive){
            control();

        }
        else {
            countactive=true;
            button = findViewById(R.id.button);
            button.setText("STOP!");
            seekbar.setEnabled(false);
            count = new CountDownTimer(seekbar.getProgress() * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    updatetimer((int) millisUntilFinished / 1000);

                }

                @Override
                public void onFinish() {
                    MediaPlayer media=MediaPlayer.create(getApplicationContext(),R.raw.beep01a);
                    media.start();
                    control();

                }
            }.start();
        }
    }
    public void updatetimer(int timer){
        int minutes=timer/60;
        int seconds=timer%60;
        String actualsecond= Integer.toString(seconds);
        if(seconds<10){
            actualsecond="0"+Integer.toString(seconds);
        }
        text.setText(Integer.toString(minutes)+":"+actualsecond);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*final  Handler handler=new Handler();
        Runnable run=new Runnable() {
            @Override
            public void run() {
                Log.i("info","Print tick");
                handler.postDelayed(this,1000);
            }
        };
        handler.post(run);*/
        /*CountDownTimer count=new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Toast.makeText(MainActivity.this, String.valueOf(millisUntilFinished/1000), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
            }
        }.start();*/
        seekbar=findViewById(R.id.seekbar);
        text=findViewById(R.id.textView);
        seekbar.setMax(600);//600 in seconds i.e. 10min counter
        seekbar.setProgress(30);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updatetimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
