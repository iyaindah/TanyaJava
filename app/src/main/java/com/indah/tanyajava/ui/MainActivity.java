package com.indah.tanyajava.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.indah.tanyajava.R;

public class MainActivity extends AppCompatActivity {

    Animation zoomInAnimation, bottomAnimation;
    ImageView image;
    TextView title, subTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //        animation
        zoomInAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_bottom);

        image = findViewById(R.id.logo);
        title = findViewById(R.id.text_apps);
        subTitle = findViewById(R.id.text_sub_apps);

        image.setAnimation(zoomInAnimation);
        title.setAnimation(bottomAnimation);
        subTitle.setAnimation(bottomAnimation);

        int SPLASH_SCREEN = 5000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, SelectTypeUser.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}