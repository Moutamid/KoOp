package com.moutamid.koop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Starting_Activity extends AppCompatActivity {

    Button homePage , start;
    MediaPlayer backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        homePage = findViewById(R.id.btn_homepage);
        homePage.setAlpha(0f);
        homePage.animate().alpha(1f).setDuration(1000);
        start = findViewById(R.id.btn_start);
        start.setAlpha(0f);
        start.animate().alpha(1f).setDuration(1000);

        //textanim = findViewById(R.id.text_anim);
        //textanim.setAlpha(0f);
        //textanim.animate().alpha(1f).setDuration(3000);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backgroundMusic = MediaPlayer.create(Starting_Activity.this, R.raw.home);
                backgroundMusic.setLooping(false);
                backgroundMusic.setVolume(10.0f, 3.0f);
                backgroundMusic.start();
                Intent intent = new Intent(Starting_Activity.this , MainActivity.class);
                startActivity(intent);
            }
        });

        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backgroundMusic = MediaPlayer.create(Starting_Activity.this, R.raw.home);
                backgroundMusic.setLooping(false);
                backgroundMusic.setVolume(10.0f, 3.0f);
                backgroundMusic.start();
                String url = "https://op2metrie.blog/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        final TypeWriterEffect tw = (TypeWriterEffect) findViewById(R.id.text_anim);
        tw.setText("");
        tw.setCharacterDelay(1);
        tw.animateText(" ??? Hallo und herzlich wilkommen bei der ersten deutschsprachigen APP f??r gesunde Augen.\n" +
                "Ich freue mich das sie nun t??glich hier vorbei schauen und sich die drei Vorschl??ge des Tages abholen wollen. Das Ziel ist es sich f??r diesen Tag an die Massnahmen zu halten.\n" +
                "Ich glaube fest dran das sie es schaffen. Bei Fragen zu diesem Thema empfehle ich das Buch: Augenblick mal zu lesen.  ??? ");
        backgroundMusic = MediaPlayer.create(Starting_Activity.this, R.raw.typing);
        backgroundMusic.setLooping(false);
        backgroundMusic.setVolume(10.0f, 3.0f);
        backgroundMusic.start();
        backgroundMusic.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                backgroundMusic = MediaPlayer.create(Starting_Activity.this, R.raw.typing);
                backgroundMusic.setLooping(false);
                backgroundMusic.setVolume(10.0f, 3.0f);
                backgroundMusic.start();
            }
        });
        super.onStart();
    }

}