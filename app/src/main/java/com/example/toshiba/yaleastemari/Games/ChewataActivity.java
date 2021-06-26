package com.example.toshiba.yaleastemari.Games;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.toshiba.yaleastemari.R;
import com.example.toshiba.yaleastemari.SharedPreferenceConfig;

import androidx.appcompat.app.AppCompatActivity;

public class ChewataActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnGame1, btnGame2, btnGame3, btnGame4, btnGame5, btnGame6, btnGame7, btnGame8, btnGame9,
            btn_back_inChewata,btn_sound_inChewata,btn_music_inChewata;
    SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_chewata);


        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());



        Animation backandforthAnim = AnimationUtils.loadAnimation(this, R.anim.back_and_forth_backbutton);
        btn_back_inChewata = (Button)findViewById(R.id.btn_back_inChewata);
        btn_sound_inChewata = (Button)findViewById(R.id.btn_sound_inChewata);
       // btn_music_inChewata = (Button)findViewById(R.id.btn_music_inChewata);

        btn_back_inChewata.startAnimation(backandforthAnim);
        btn_sound_inChewata.startAnimation(backandforthAnim);
    //    btn_music_inChewata.startAnimation(backandforthAnim);
        btn_back_inChewata.setOnClickListener(this);

        //initializing the nine game buttons
        btnGame1  = (Button) findViewById(R.id.btnGame1);
        btnGame2  = (Button) findViewById(R.id.btnGame2);
        btnGame3  = (Button) findViewById(R.id.btnGame3);
        btnGame4  = (Button) findViewById(R.id.btnGame4);
        btnGame5  = (Button) findViewById(R.id.btnGame5);
        btnGame6  = (Button) findViewById(R.id.btnGame6);
        btnGame7  = (Button) findViewById(R.id.btnGame7);
        btnGame8  = (Button) findViewById(R.id.btnGame8);
        btnGame9  = (Button) findViewById(R.id.btnGame9);

        btnGame1.setEnabled(sharedPreferenceConfig.readGame1Status());
        btnGame2.setEnabled(sharedPreferenceConfig.readGame2Status());
        btnGame3.setEnabled(sharedPreferenceConfig.readGame3Status());
        btnGame4.setEnabled(false);
        btnGame5.setEnabled(false);
        btnGame6.setEnabled(false);
        btnGame7.setEnabled(false);
        btnGame8.setEnabled(false);
        btnGame9.setEnabled(false);

        btnGame1.setOnClickListener(this);
        btnGame2.setOnClickListener(this);
        btnGame3.setOnClickListener(this);
        btnGame4.setOnClickListener(this);
        btnGame5.setOnClickListener(this);
        btnGame6.setOnClickListener(this);
        btnGame7.setOnClickListener(this);
        btnGame8.setOnClickListener(this);
        btnGame9.setOnClickListener(this);

        //================checking for game status======================
        btnGame1.setEnabled(sharedPreferenceConfig.readGame1Status());
        if (sharedPreferenceConfig.readGame1Status()){
            btnGame1.setBackground(getResources().getDrawable(R.drawable.tic_tac_toa_bg));

        }
        if (sharedPreferenceConfig.readGame2Status()){
            btnGame2.setBackground(getResources().getDrawable(R.drawable.dice_game_bg));

        }



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_back_inChewata:
                onBackPressed();
                break;
            case R.id.btnGame1:
                Intent game1 = new Intent(this, TicTacToeGame.class);
                startActivity(game1);
                break;
            case R.id.btnGame2:
                Intent game2 = new Intent(this, DiceGame.class);
                startActivity(game2);
                break;

        }

    }




}
