package com.moutamid.koop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView wheel1;
    ImageView wheel2;
    ImageView wheel3;
    //osama
    Button play_btn;
    TextView textview1;
    TextView textview2;
    TextView textview3;
    TextView txt_1;
    TextView txt_2;
    TextView txt_3;
    String[] sector1 = {"01" , "02" , "03" , "04"};
    String[] sector2 = {"08" , "07" , "06" , "05"};
    String[] sector3 = {"12" , "11" , "10" , "09"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wheel1 = findViewById(R.id.wheel1);
        wheel2 = findViewById(R.id.wheel2);
        wheel3 = findViewById(R.id.wheel3);
        play_btn = findViewById(R.id.play_btn);
        textview1 = findViewById(R.id.textview1);
        textview2 = findViewById(R.id.textview2);
        textview3 = findViewById(R.id.textview3);
        txt_1 = findViewById(R.id.txt_1);
        txt_2 = findViewById(R.id.txt_2);
        txt_3 = findViewById(R.id.txt_3);

        Collections.reverse(Arrays.asList(sector1));

        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotate_wheel1();
                rotate_wheel2();
                rotate_wheel3();
            }
        });

    }

    private void rotate_wheel3() {
        Random random = new Random();
        final int degree = random.nextInt(360);

        RotateAnimation rotateAnimation =  new RotateAnimation(
                0,degree + 720,RotateAnimation.RELATIVE_TO_SELF,0.5f,
                RotateAnimation.RELATIVE_TO_SELF,0.5f
        );

        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());

        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                CalculatePoint3(degree);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        wheel3.startAnimation(rotateAnimation);
    }

    private void CalculatePoint3(int degree) {
        int initialPoint = 0;
        int endPoint = 90;
        int i = 0;
        String res = null;
        do {
            if (degree>initialPoint && degree<endPoint){
                res = sector3[i];
            }
            initialPoint += 90; endPoint += 90;
            i++;
        }while (res == null);
        textview3.setVisibility(View.GONE);
        txt_3.setVisibility(View.VISIBLE);
        textview3.setText("Value form 3rd Wheel = "+res);
        if (res.equals("09")){
            txt_3.setText("Heute mache ich nach jeder Mahlzeit die liegende Acht und entspanne meine Augen\n" +
                    "danach für 5 Minuten");
        }
        else if (res.equals("10")){
            txt_3.setText("Heute lese ich immer in meiner persönlichen harmonischen Distanz");
        }
        else if (res.equals("11")){
            txt_3.setText("Heute achte ich aktiv auf mein Blinzeln und werde dieses steigern und bewusst erleben");
        }
        else if (res.equals("12")){
            txt_3.setText("Heute werde ich aktiv mein Fern und Nah-Training durchführen");
        }
    }

    private void rotate_wheel2() {
        Random random = new Random();
        final int degree = random.nextInt(360);

        RotateAnimation rotateAnimation =  new RotateAnimation(
                0,degree + 720,RotateAnimation.RELATIVE_TO_SELF,0.5f,
                RotateAnimation.RELATIVE_TO_SELF,0.5f
        );

        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());

        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                CalculatePoint2(degree);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        wheel2.startAnimation(rotateAnimation);
    }

    private void CalculatePoint2(int degree) {
        int initialPoint = 0;
        int endPoint = 90;
        int i = 0;
        String res = null;
        do {
            if (degree>initialPoint && degree<endPoint){
                res = sector2[i];
            }
            initialPoint += 90; endPoint += 90;
            i++;
        }while (res == null);
        textview2.setVisibility(View.GONE);
        txt_2.setVisibility(View.VISIBLE);
        textview2.setText("Value form 2nd Wheel = "+res);
        if (res.equals("05")){
            txt_2.setText("Heute esse ich nur gesunde, natürliche Lebensmittel aus ökologischem Anbau");
        }
        else if (res.equals("06")){
            txt_2.setText("Heute esse ich besonders viel grünes Gemüse");
        }
        else if (res.equals("07")){
            txt_2.setText("Heute esse ich besonders viel oranges Gemüse");
        }
        else if (res.equals("08")){
            txt_2.setText("Heute esse ich keinen Zucker");
        }
    }

    private void rotate_wheel1() {
        Random random = new Random();
        final int degree = random.nextInt(360);

        RotateAnimation rotateAnimation =  new RotateAnimation(
                0,degree + 720,RotateAnimation.RELATIVE_TO_SELF,0.5f,
                RotateAnimation.RELATIVE_TO_SELF,0.5f
        );

        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());

        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                CalculatePoint(degree);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        wheel1.startAnimation(rotateAnimation);
    }

    private void CalculatePoint(int degree) {
        int initialPoint = 0;
        int endPoint = 90;
        int i = 0;
        String res = null;
        do {
            if (degree>initialPoint && degree<endPoint){
                res = sector1[i];
            }
            initialPoint += 90; endPoint += 90;
            i++;
        }while (res == null);
        textview1.setVisibility(View.GONE);
        txt_1.setVisibility(View.VISIBLE);
        textview1.setText("Value form 1st Wheel = "+res);
        if (res.equals("01")){
            txt_1.setText("Heute mache ich alle 2 Stunden eine Pause von 20 Minuten an der frischen Luft");
        }
        else if (res.equals("02")){
            txt_1.setText("Heute lege ich mein Handy zwei Stunden bevor ich ins Bett gehe zu Seite");
        }
        else if (res.equals("03")){
            txt_1.setText("Heute rauche ich keine Zigarette");
        }
        else if (res.equals("04")){
            txt_1.setText("Heute verbringe ich zwei Stunden mit einem Waldspaziergang");
        }
    }


}