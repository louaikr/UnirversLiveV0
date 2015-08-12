package com.example.yami.unirverslivev0.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.yami.unirverslivev0.R;

/**
 * Created by Yami on 7/23/2015.
 */
public class HomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_home);
    }

    public void movingToLogin(View view) {
        Intent loginscreen = new Intent(this, LoginActivity.class);
        startActivity(loginscreen);
    }

    public void movingTosignup(View view) {
        Intent signupscreen = new Intent(this, SignupActivity.class);
        startActivity(signupscreen);
    }
}



