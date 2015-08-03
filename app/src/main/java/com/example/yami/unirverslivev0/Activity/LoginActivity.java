package com.example.yami.unirverslivev0.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.yami.unirverslivev0.R;

/**
 * Created by Yami on 7/23/2015.
 */
public class LoginActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void movingToHome(View view) {
        Intent homescreen = new Intent(this, MainActivity.class);
        startActivity(homescreen);
    }
}
