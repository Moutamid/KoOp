package com.moutamid.koop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Starting_Activity extends AppCompatActivity {

    Button homePage , start;
    TextView textanim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        homePage = findViewById(R.id.btn_homepage);
        start = findViewById(R.id.btn_start);

        textanim = findViewById(R.id.text_anim);
        textanim.setAlpha(0f);
        textanim.animate().alpha(1f).setDuration(3000);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Starting_Activity.this , MainActivity.class);
                startActivity(intent);
            }
        });

        homePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://op2metrie.blog/";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}