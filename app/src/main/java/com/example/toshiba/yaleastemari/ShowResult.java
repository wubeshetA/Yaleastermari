package com.example.toshiba.yaleastemari;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.toshiba.yaleastemari.Questions.LetterQuestion;

import androidx.appcompat.app.AppCompatActivity;

public class ShowResult extends AppCompatActivity {
    TextView txt_result;
    Button starButtons,btnCancel1;
    String thisLevelScore = ""+LetterQuestion.ScoreToShowresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        btnCancel1 = (Button)findViewById(R.id.btnCancel1);
        btnCancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        txt_result = (TextView)findViewById(R.id.txt_result);
        txt_result.setText(thisLevelScore);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width * 0.4),(int)(height * 0.6));
        starButtons = (Button)findViewById(R.id.starButtons);

        switch (thisLevelScore){
            case "0":
                starButtons.setBackgroundResource(R.drawable.star0);
                break;
            case "20":
                starButtons.setBackgroundResource(R.drawable.star_frame_animation1);
                AnimationDrawable animationDrawable1 = (AnimationDrawable)starButtons.getBackground();
                animationDrawable1.start();
                break;
            case "40":
                starButtons.setBackgroundResource(R.drawable.star_frame_animation2);
                AnimationDrawable animationDrawable2 = (AnimationDrawable)starButtons.getBackground();
                animationDrawable2.start();
                break;
            case "60":
                starButtons.setBackgroundResource(R.drawable.star_frame_animation3);
                AnimationDrawable animationDrawable3 = (AnimationDrawable)starButtons.getBackground();
                animationDrawable3.start();
                break;
            case "80":
                starButtons.setBackgroundResource(R.drawable.star_frame_animation4);
                AnimationDrawable animationDrawable4 = (AnimationDrawable)starButtons.getBackground();
                animationDrawable4.start();
                break;
        }






    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.start_show_result_anim100,R.anim.end_show_result_anim0);

    }
}