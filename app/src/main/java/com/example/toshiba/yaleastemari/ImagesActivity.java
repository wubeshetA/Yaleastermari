package com.example.toshiba.yaleastemari;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ImagesActivity extends AppCompatActivity {
CanvasView canvasView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        canvasView = (CanvasView)findViewById(R.id.mycanvas);



    }

    public void clearCanvas(View v){
        canvasView.clearCanvas();
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
