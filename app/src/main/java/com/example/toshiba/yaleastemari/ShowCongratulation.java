package com.example.toshiba.yaleastemari;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.toshiba.yaleastemari.Games.DiceGame;
import com.example.toshiba.yaleastemari.Games.TicTacToeGame;
import com.example.toshiba.yaleastemari.Questions.LetterQuestion;
import com.example.toshiba.yaleastemari.Questions.QuestionLevelFragment;

import androidx.appcompat.app.AppCompatActivity;

public class ShowCongratulation extends AppCompatActivity {
    Button btnOpenGame,btnCancel1,starButton,game_icon_shower;
    TextView txt_result;
    String thisLevelScore = ""+LetterQuestion.ScoreToShowresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_congratulation);


        game_icon_shower = (Button)findViewById(R.id.game_icon_shower);
        starButton = (Button)findViewById(R.id.starButtons);
        starButton.setBackgroundResource(R.drawable.star_frame_animation);
        AnimationDrawable animationDrawable = (AnimationDrawable)starButton.getBackground();
        animationDrawable.start();
        btnOpenGame = (Button) findViewById(R.id.btnOpenGame);

        if (QuestionLevelFragment.levelSelector == 1){
           game_icon_shower.setBackground(getResources().getDrawable(R.drawable.tic_tac_toa_bg));
        }
        else if (QuestionLevelFragment.levelSelector == 2){
            game_icon_shower.setBackground(getResources().getDrawable(R.drawable.dice_game_bg));
        }

        btnOpenGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (QuestionLevelFragment.levelSelector == 1){
                    ShowCongratulation.this.startActivity(new Intent(ShowCongratulation.this, TicTacToeGame.class));
                }
                else if(QuestionLevelFragment.levelSelector == 2){
                     ShowCongratulation.this.startActivity(new Intent(ShowCongratulation.this, DiceGame.class));
                }
            }
        });
        btnCancel1 = (Button) findViewById(R.id.btnCancel1);
        btnCancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        txt_result = (TextView)findViewById(R.id.txt_congra_result);
        txt_result.setText(thisLevelScore);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width * 0.4),(int)(height * 0.6));
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.start_show_result_anim100,R.anim.end_show_result_anim0);
    }
}
