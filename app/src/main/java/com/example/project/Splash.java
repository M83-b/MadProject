package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.window.SplashScreen;

public class Splash extends AppCompatActivity {
    Animation appear;
    Animation moveUp;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final boolean startNewMain = getIntent().getBooleanExtra("START_NEW_MAIN",true);
        setContentView(R.layout.activity_splash);
        appear = AnimationUtils.loadAnimation(this, R.anim.appear);
        moveUp = AnimationUtils.loadAnimation(this,R.anim.move_up);
        logo = findViewById(R.id.logo);
        logo.setAnimation(appear);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(startNewMain) {
                    Intent i = new Intent(Splash.this, MainActivity.class);
                    startActivity(i);
                }
                finish();
            }
        }, 1500);

    }
}