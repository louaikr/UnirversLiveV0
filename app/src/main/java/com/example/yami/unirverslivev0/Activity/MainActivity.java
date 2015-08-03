package com.example.yami.unirverslivev0.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.yami.unirverslivev0.Fragments.HomeContentFragment;
import com.example.yami.unirverslivev0.Fragments.MesVideoContentFragment;
import com.example.yami.unirverslivev0.MapsActivity;
import com.example.yami.unirverslivev0.R;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_VIDEO_CAPTURE =1 ;
    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ImageButton imgbutt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()){

                    case R.id.Home:
                        HomeContentFragment homefragment = new HomeContentFragment();
                        android.support.v4.app.FragmentTransaction homefragmentTransaction = getSupportFragmentManager().beginTransaction();
                        homefragmentTransaction.replace(R.id.frame,homefragment);
                        homefragmentTransaction.commit();
                        return true;
                    //Replacing the main content with MesVideoContentFragment Which is our Inbox View;
                    case R.id.Diffusionlive:

                        Intent cam = new Intent(MainActivity.this,CameraActivity.class);
                        startActivity(cam);

                        return true;

                    // For rest of the options we just show a toast on click

                  case R.id.mesvideo:
                        Toast.makeText(getApplicationContext(),"Inbox Selected",Toast.LENGTH_SHORT).show();
                        MesVideoContentFragment mesvideofragment = new MesVideoContentFragment();
                        android.support.v4.app.FragmentTransaction mesvideofragmentTransaction = getSupportFragmentManager().beginTransaction();
                        mesvideofragmentTransaction.replace(R.id.frame,mesvideofragment);
                        mesvideofragmentTransaction.commit();
                        return true;
                    case R.id.decouvrir:
                        Toast.makeText(getApplicationContext(),"Drafts Selected",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.monprofil:
                        Intent myprofil = new Intent(MainActivity.this, MyProfil.class);
                        startActivity(myprofil);
                        return true;
                    case R.id.feedback:
                        Intent map = new Intent(MainActivity.this, MapsActivity.class);
                        startActivity(map);
                        return true;
                    case R.id.Logout:
                        Toast.makeText(getApplicationContext(),"Spam Selected",Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(),"Somethings Wrong",Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


        imgbutt=(ImageButton)findViewById(R.id.imageButton1);
        imgbutt.setOnClickListener(new videoRecord());



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Intent intent = null;
            Uri videoUri = intent.getData();
            VideoView mVideoView=null;
            mVideoView.setVideoURI(videoUri);
        }





    }

  class videoRecord implements ImageButton.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            takeVideoIntent.putExtra(android.provider.MediaStore.EXTRA_SCREEN_ORIENTATION, ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

}
