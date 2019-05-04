package com.example.guesstheobject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    ArrayList<String> arrays;
    public void chosen(View view){

    }
    public class Downloadimage extends AsyncTask<String,Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {
            Bitmap result;
            URL url;
            HttpURLConnection httpURLConnection;
            try {
                url=new URL(urls[0]);
                httpURLConnection=(HttpURLConnection) url.openConnection();
                InputStream in=httpURLConnection.getInputStream();
                result= BitmapFactory.decodeStream(in);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }
    }
    public class DownloadTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... urls) {
            String result="";
            URL url;
            HttpURLConnection httpURLConnection;
            try {
                url=new URL(urls[0]);
                httpURLConnection=(HttpURLConnection) url.openConnection();
                InputStream in=httpURLConnection.getInputStream();
                InputStreamReader read=new InputStreamReader(in);
                int data=read.read();
                while(data!=-1){
                    result+=(char)data;
                    data=read.read();
                }
                return result;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String celebreUrl[]={};
        String names[]={};
        arrays=new ArrayList<String>();
        DownloadTask task=new DownloadTask();
        try {
            String result=task.execute("").get();
            Pattern p=Pattern.compile("img src");
            Matcher m=p.matcher(result);
            int i=0;
            while(m.find()){
                celebreUrl[i]=m.group(1);
                i++;
            }
            p=Pattern.compile("img src");
            m=p.matcher(result);
            i=0;
            while(m.find()){
                names[i]=m.group(1);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
