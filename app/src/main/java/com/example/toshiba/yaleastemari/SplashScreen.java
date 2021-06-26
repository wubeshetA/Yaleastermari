package com.example.toshiba.yaleastemari;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
ImageView yaleAstemariBook, yaleAstemariText,cloud1,cloud2;
    TextView txtContactUs,txtAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        txtAbout = findViewById(R.id.txtAbout);
        txtAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SplashScreen.this.startActivity(new Intent(SplashScreen.this,AboutActivity.class));
                overridePendingTransition(R.anim.slide_in_bottom,R.anim.slide_out_top);
            }
        });
        txtContactUs = findViewById(R.id.txtContactUs);
        txtContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SplashScreen.this.startActivity(new Intent(SplashScreen.this,ContactPopUpActivity.class));
                overridePendingTransition(R.anim.slide_in_bottom,R.anim.slide_out_top);
            }
        });
        yaleAstemariText = findViewById(R.id.yaleAstemariText);
        yaleAstemariBook = findViewById(R.id.yaleAstemariBook);
        cloud1 = findViewById(R.id.cloud1);
        cloud2 = findViewById(R.id.cloud2);

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.splash_screen_anim1);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.splash_screen_anim2);
        Animation cloud1_anim = AnimationUtils.loadAnimation(this, R.anim.cloud1_animation);
        Animation cloud2_anim = AnimationUtils.loadAnimation(this, R.anim.cloud2_animation);

        cloud1.startAnimation(cloud1_anim);
        cloud2.startAnimation(cloud2_anim);

        yaleAstemariText.startAnimation(animation1);
        yaleAstemariBook.startAnimation(animation2);
        yaleAstemariBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SplashScreen.this.startActivity(new Intent(SplashScreen.this,HomeActivity.class));
               // SplashScreen.this.finish();      // this code makes the splash screen to not be opened again after the next activity is opened
            }
        });

    }
}
