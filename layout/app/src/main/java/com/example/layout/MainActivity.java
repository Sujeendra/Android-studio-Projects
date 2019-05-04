package com.example.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    boolean flag=true;
    public void fade(View view){
        ImageView imageview=(ImageView)findViewById(R.id.imageView1);
        ImageView imageview1=(ImageView)findViewById(R.id.imageView2);
    if(flag){
        imageview.animate().alpha(0).setDuration(2000);
        imageview1.animate().alpha(1).setDuration(2000);
        flag=false;
    }
    else{
        imageview.animate().alpha(1).setDuration(2000);
        imageview1.animate().alpha(0).setDuration(2000);
        flag=true;
    }





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
