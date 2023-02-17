package com.example.venato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.venato.Activity.MainActivity;

public class LoaderApp extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;
    int value;
    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressbarid);
        textView=findViewById(R.id.textviewid);
        new Thread () {
            @Override
            public void run () {
                try
                {
                    startProgress();
                    // Thread logic here
                }
                finally
                {
                    //Intent sec = new Intent(LoaderApp.this, MainActivity.class);
                    //startActivity(sec);
                    // Thread exit logic here
                }
            }
        }.start ();



    }

    public void startProgress()
    {
        for(value=0;value<100;value=value+1)
        {
            try {
                Thread.sleep(40);
                progressBar.setProgress(value);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText(String.valueOf(value+"%"));
                }
            });
        }



    }
}