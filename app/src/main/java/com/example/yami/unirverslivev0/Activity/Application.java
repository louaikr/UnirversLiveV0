package com.example.yami.unirverslivev0.Activity;



import com.parse.Parse;


/**
 * Created by TAUSY on 7/12/2015.
 */
public class Application extends android.app.Application {

        public Application() {
        }

        @Override
        public void onCreate() {
            super.onCreate();

            //ParseObject.registerSubclass(LoginActivity.class);
            //initialize parse
            Parse.enableLocalDatastore(this);

            Parse.initialize(this, "DQYH0sSmJrtdY1FwuFkx56ph0vgVehDF2uxDTHWy", "ZoDV5PZfE2fjiT0zAzrFU4rlxvdXjCscy1At1hqp");
        }

}
