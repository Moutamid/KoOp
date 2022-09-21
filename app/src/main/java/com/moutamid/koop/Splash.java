package com.moutamid.koop;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 6000;
    MediaPlayer backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent homeIntent = new Intent(Splash.this, Starting_Activity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);

        backgroundMusic = MediaPlayer.create(Splash.this, R.raw.splash_sound);
        backgroundMusic.setLooping(false);
        backgroundMusic.setVolume(10.0f, 3.0f);
        backgroundMusic.start();
    }
}