package com.example.yami.unirverslivev0.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.yami.unirverslivev0.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Yami on 7/23/2015.
 */
public class LauncherActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        int timeout = 2000; // make the activity visible for 4 seconds

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                finish();
                Intent homepage = new Intent(LauncherActivity.this, HomeActivity.class);
                startActivity(homepage);

            }
        }, timeout);
    }
}
