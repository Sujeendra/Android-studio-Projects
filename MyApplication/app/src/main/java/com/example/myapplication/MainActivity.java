package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
class DesignTest{
    int sum=1;
    int inc=1;
   int score;
    public boolean isSquare(){
        if (Math.sqrt(score)==Math.floor(Math.sqrt(score))){
            return true;
        }
        else{
            return false;
        }

    }
    public boolean isTriangle(){

        while(sum<score){
            inc++;
            sum+=inc;
        }
        if(sum==score){
            return true;
        }
        else{
            return false;
        }

    }
}


public class MainActivity extends AppCompatActivity {
    public void buttonpress(View view) {

        TextView n=(TextView) findViewById(R.id.nameeditText);

        Log.i("info", "Welcome");

        DesignTest object=new DesignTest();
        if (n.getText().toString().isEmpty()){
            Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();
        }

        else{object.score= Integer.parseInt(n.getText().toString());
            if (object.isSquare() && object.isTriangle()) {
                Toast.makeText(this, "Both", Toast.LENGTH_LONG).show();
            } else if (object.isSquare()) {
                Toast.makeText(this, "Square", Toast.LENGTH_LONG).show();
            } else if (object.isTriangle()) {
                Toast.makeText(this, "Triangle", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "None", Toast.LENGTH_LONG).show();
            }

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
