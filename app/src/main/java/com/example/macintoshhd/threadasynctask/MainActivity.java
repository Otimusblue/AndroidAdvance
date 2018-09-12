package com.example.macintoshhd.threadasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButtonStart;
    private Button mButtonStop;
    private Boolean mStopLoop;
    private String TAG = "tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG,"Thread id : "+ Thread.currentThread().getId());

        mButtonStart = findViewById(R.id.btn_start);
        mButtonStop = findViewById(R.id.btn_stop);
        mButtonStart.setOnClickListener(this);
        mButtonStop.setOnClickListener(this);


    }
    @Override
    public void onClick(View view){

        switch (view.getId()){
            case R.id.btn_start :
                mStopLoop = true;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(mStopLoop){
                            Log.i(TAG,"Thread id in while loop : " + Thread.currentThread().getId());
                        }
                    }
                }).start();
//                while(mStopLoop){
//                    Log.i(TAG,"Thread id in while loop : " + Thread.currentThread().getId());
//                }

                break;
            case R.id.btn_stop :
                mStopLoop = false;
                Log.i(TAG,"Hieu dep trai");
                break;

        }
    }
}
