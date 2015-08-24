package com.kute12457.ruchir.tab_activity;

import android.app.Activity;
import android.app.TabActivity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.VideoView;


public class MainActivity extends TabActivity {

    ToggleButton toggleButton, toggleButton2;
    MediaPlayer mySound;
    TabHost mTabHost = null;
    EditText name,phone,email,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySound = MediaPlayer.create(MainActivity.this,R.raw.song);
        mySound.setLooping(true);

        toggleButton = (ToggleButton)findViewById(R.id.toggleButton);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mySound.start();
                } else {
                    mySound.pause();
                }
            }
        });

        final VideoView vid = (VideoView) findViewById(R.id.videoView);
        String urlpath = "android.resource://" +getPackageName() + "/" + R.raw.video;
        vid.setVideoURI(Uri.parse(urlpath));
        vid.setMediaController(new MediaController(this));
        toggleButton2 = (ToggleButton)findViewById(R.id.toggleButton2);

        toggleButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    vid.start();
                } else {
                    vid.pause();
                }
            }
        });

        name = (EditText) findViewById(R.id.txtname);
        phone = (EditText) findViewById(R.id.txtphone);
        email = (EditText) findViewById(R.id.txtemail);
        address = (EditText) findViewById(R.id.txtpostaladdress);

        mTabHost = getTabHost();

        mTabHost.addTab(mTabHost.newTabSpec("tab_test1").setIndicator("Contacts", getResources().getDrawable(R.mipmap.contact)).setContent(R.id.contactsLayout));
        mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("Music", getResources().getDrawable(R.drawable.music)).setContent(R.id.musicLayout));
        mTabHost.addTab(mTabHost.newTabSpec("tab_test3").setIndicator("Video", getResources().getDrawable(R.drawable.video)).setContent(R.id.videoLayout));

        mTabHost.setCurrentTab(0);

        name.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Name: " + name.getText().toString(), Toast.LENGTH_LONG).show();

            }

        });

        phone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Phone: " + phone.getText().toString(), Toast.LENGTH_LONG).show();

            }

        });
        email.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Email: " + email.getText().toString(), Toast.LENGTH_LONG).show();

            }

        });
        address.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Address: " + address.getText().toString(), Toast.LENGTH_LONG).show();

            }

        });

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
}
