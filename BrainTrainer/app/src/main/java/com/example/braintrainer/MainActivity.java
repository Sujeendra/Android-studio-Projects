package com.example.braintrainer;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> array=new ArrayList<Integer>();
    int locatetag;
    int score=0;
    int question=0;
    TextView scores;
    TextView result;
    TextView textquestion;
    TextView time;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Random rand;
    Button play;
    Button button;
    ConstraintLayout game;
    boolean tester=true;
    public void reset(){
        time.setText("30s");
        question=0;
        score=0;
        scores.setText("0 / 0");


    }
    public void start(View view){
        play.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);
        game.setVisibility(View.VISIBLE);
        newQuestion();
        CountDownTimer count=new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText(Integer.toString((int)millisUntilFinished/1000));

            }

            @Override
            public void onFinish() {
                play.setVisibility(View.VISIBLE);
                tester=false;
            }
        }.start();

    }
    public void PlayAgain(View view){
        tester=true;
        reset();
        start(findViewById(R.id.timerTextview));

    }
    public void Answerselector(View view){
        if(tester){
        question++;
        if((String.valueOf(view.getTag()).equals(String.valueOf(locatetag)))){
            score++;
            result.setText("CORRECT!");

        }
        else{
            result.setText("WRONG!");
        }
        scores.setText(Integer.toString(score)+"/"+Integer.toString(question));


        newQuestion();
        }
        else{
            tester=false;
        }
    }
    public void newQuestion(){

        int a=rand.nextInt(21);
        int b=rand.nextInt(21);
        result=findViewById(R.id.Correct);
        textquestion.setText(String.valueOf(a)+" + "+String.valueOf(b));
        locatetag=rand.nextInt(4);
        array.clear();
        scores=findViewById(R.id.score);
        for(int i=0;i<4;i++){
            if(i==locatetag){
                array.add(a+b);
            }
            else{
                int wrong=rand.nextInt(41);
                while((a+b)==wrong){
                    wrong=rand.nextInt(41);
                }
                array.add(wrong);
            }
        }
        button0.setText(Integer.toString(array.get(0)));
        button1.setText(Integer.toString(array.get(1)));
        button2.setText(Integer.toString(array.get(2)));
        button3.setText(Integer.toString(array.get(3)));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rand=new Random();
        textquestion=findViewById(R.id.question);
        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button=findViewById(R.id.button);
        play=findViewById(R.id.playagain);
        game=findViewById(R.id.gamelayout);
        game.setVisibility(View.INVISIBLE);
        button.setVisibility(View.VISIBLE);
        time=findViewById(R.id.timerTextview);


    }
}
