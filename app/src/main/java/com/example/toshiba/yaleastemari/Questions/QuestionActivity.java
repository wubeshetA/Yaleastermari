package com.example.toshiba.yaleastemari.Questions;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.fragment.app.FragmentManager;

import com.example.toshiba.yaleastemari.R;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener{
Button haHuQuestion;
    FragmentManager fragmentManager;
    Button btn_back_inQuestionActivity,btnMusic_inQuestionActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_question);
        Animation backandforthAnim = AnimationUtils.loadAnimation(QuestionActivity.this, R.anim.back_and_forth_backbutton);

        fragmentManager = getSupportFragmentManager();
        haHuQuestion = (Button)findViewById(R.id.haHuQuestion);
        haHuQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction().replace(R.id.Levels_container,new QuestionLevelFragment())
                        .addToBackStack("").commit();
            }
        });
        btn_back_inQuestionActivity = (Button)findViewById(R.id.btn_back_inQuestionActivity);
        btn_back_inQuestionActivity.startAnimation(backandforthAnim);
        btn_back_inQuestionActivity.setOnClickListener(this);



      //  btnMusic_inQuestionActivity = (Button)findViewById(R.id.btnMusic_inQuestionActivity);
       // btnMusic_inQuestionActivity.setOnClickListener(this);
//        if (!HomeActivity.isPlaying[0]){
//            btnMusic_inQuestionActivity.setBackground(getResources().getDrawable(R.drawable.btn_music_mute));}
//        else if (HomeActivity.isPlaying[0]){
//            btnMusic_inQuestionActivity.setBackground(getResources().getDrawable(R.drawable.btn_music_normal));}

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back_inQuestionActivity:
                onBackPressed();
                break;

//            case R.id.btnMusic_inQuestionActivity:
//                if (!HomeActivity.isPlaying[0]){
//                    btnMusic_inQuestionActivity.setBackground(getResources().getDrawable(R.drawable.btn_music_normal));
//                    HomeActivity.backgroundMusic.start();
//                    HomeActivity.isPlaying[0] = true;
//                }
//                else if (HomeActivity.isPlaying[0]){
//                    btnMusic_inQuestionActivity.setBackground(getResources().getDrawable(R.drawable.btn_music_mute));
//                    HomeActivity.backgroundMusic.pause();
//                    HomeActivity.isPlaying[0] = false;
//                }
//                break;
        }

    }
}
