package com.example.downloadingwebcontent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    public class DownloadTask extends AsyncTask<String,Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... urls) {
            URL url;
            Bitmap bitmap;
            HttpURLConnection httpURLConnection;
            try {
                url=new URL(urls[0]);
                httpURLConnection=(HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream in=httpURLConnection.getInputStream();
                bitmap= BitmapFactory.decodeStream(in);
                return bitmap;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            /*String string="";
            HttpURLConnection httpconnection=null;
            try {
                url = new URL(urls[0]);
                httpconnection = (HttpURLConnection) url.openConnection();
                InputStream in=httpconnection.getInputStream();
                InputStreamReader read=new InputStreamReader(in);
                int data=read.read();

                while(data!=-1){
                    string+=(char)data;
                    data=read.read();
                }
                return string;
            }
            catch(Exception e){
                return "Failed!";
            }*/

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void image(View view){
        DownloadTask task=new DownloadTask();
        Bitmap result;
        try{
            result=task.execute("https://images-na.ssl-images-amazon.com/images/I/71vntClRfjL._SX466_.jpg").get();
            ImageView image=findViewById(R.id.imageView);
            image.setImageBitmap(result);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
