package com.example.toshiba.yaleastemari;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class EnqoqlishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enqoqlish);
    }
    @Override
    protected void onResume() {
        super.onResume();
        HomeActivity.backgroundMusic.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        HomeActivity.backgroundMusic.pause();
    }
}
