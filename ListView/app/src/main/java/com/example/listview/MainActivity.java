package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;


import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    ListView list;
    public void generateTablenumber(int number){
        ArrayList<String> family=new ArrayList<String>();
        for(int j=1;j<11;j++){
            family.add(Integer.toString(j*number));
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,family);
        list.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.listSelector);
        SeekBar seekbar=findViewById(R.id.seekBar);
        seekbar.setMax(20);
        seekbar.setProgress(10);
        generateTablenumber(10);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                if(progress<min){
                    progress=min;
                    seekBar.setProgress(progress);
                }
                else{
                    progress=progress;
                }

                generateTablenumber(progress);
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
