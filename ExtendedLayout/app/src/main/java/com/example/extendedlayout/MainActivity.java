package com.example.extendedlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public void animation(View view){
        ImageView image=(ImageView)findViewById(R.id.imageView);
        image.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView image=(ImageView)findViewById(R.id.imageView);
        image.setX(-100);
        image.animate().translationX(100).rotation(1800).setDuration(2000);

    }
}
