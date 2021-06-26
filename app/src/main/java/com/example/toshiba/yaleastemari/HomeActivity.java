package com.example.toshiba.yaleastemari;

import android.content.Intent;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.toshiba.yaleastemari.Games.ChewataActivity;
import com.example.toshiba.yaleastemari.Questions.QuestionActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnHahu, btnAbc, btnNumbers,btnHisab, btnTeret, btnEnqoqlsh, btnImages, btnGame, btnAmharicLetterImage,
            btn_back_inHome,btn_sound_inHome,btn_music_inHome;
    ImageView cloud1_inhome,cloud2_inhome;
    public static MediaPlayer backgroundMusic;
    public static boolean[] isPlaying = new boolean[]{true};
//    isPlaying =
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        //TODO code starts here
        cloud2_inhome = findViewById(R.id.cloud2_inhome);
        cloud1_inhome = findViewById(R.id.cloud1_inhome);
isPlaying[0] = true;
        Animation cloud1_anim = AnimationUtils.loadAnimation(this, R.anim.cloud1_animation);
        Animation cloud2_anim = AnimationUtils.loadAnimation(this, R.anim.cloud2_animation);
        cloud2_inhome.startAnimation(cloud2_anim);
        cloud1_inhome.startAnimation(cloud1_anim);

// initializing the buttons

        btnHahu = findViewById(R.id.btn_hahu);
        btnAbc = findViewById(R.id.btn_abc);
        btnNumbers = findViewById(R.id.btn_numbers);
        btnHisab = findViewById(R.id.btn_hisab);
        btnTeret = findViewById(R.id.btn_teret);
        btnEnqoqlsh = findViewById(R.id.btn_enqoqlish);
        btnImages = findViewById(R.id.btn_image);
        btnGame = findViewById(R.id.btn_game);
        btnAmharicLetterImage = findViewById(R.id.btn_kg);

        //initializing the back and media buttons
        btn_back_inHome = (Button)findViewById(R.id.btn_back_inHome);
        btn_back_inHome.setOnClickListener(this);
        //btn_sound_inHome = (Button)findViewById(R.id.btn_sound_inHome);
        btn_music_inHome = (Button)findViewById(R.id.btn_music_inHome);
        /**
         * the following OnclickListnere is to start each activity
         */

        btnHahu.setOnClickListener(this);

        btnAbc.setOnClickListener(this);
        btnNumbers.setOnClickListener(this);
        btnHisab.setOnClickListener(this);
        btnTeret.setOnClickListener(this);
        btnEnqoqlsh.setOnClickListener(this);
        btnImages.setOnClickListener(this);
        btnGame.setOnClickListener(this);
        btnAmharicLetterImage.setOnClickListener(this);
        /**
         * the following thread object is to play the back and
         * the forth animation at the start of the appp
         */
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Animation backAndForthAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.back_and_forth);

                btnHahu.startAnimation(backAndForthAnim);
                btnAbc.startAnimation(backAndForthAnim);
                btnNumbers.startAnimation(backAndForthAnim);
                btnHisab.startAnimation(backAndForthAnim);
                btnTeret.startAnimation(backAndForthAnim);
                btnEnqoqlsh.startAnimation(backAndForthAnim);
                btnImages.startAnimation(backAndForthAnim);
                btnGame.startAnimation(backAndForthAnim);
                btnAmharicLetterImage.startAnimation(backAndForthAnim);
                Animation backandforthAnim = AnimationUtils.loadAnimation(HomeActivity.this, R.anim.back_and_forth_backbutton);
                btn_back_inHome.startAnimation(backandforthAnim);
              //  btn_sound_inHome.startAnimation(backandforthAnim);
                btn_music_inHome.startAnimation(backandforthAnim);

            }
        });
        thread.start();
        /**
         * the following is initializing the background music
         */

        if (backgroundMusic == null) {
            backgroundMusic = MediaPlayer.create(HomeActivity.this, R.raw.background_music);
            backgroundMusic.setVolume(5,5);
        }
        if (!HomeActivity.isPlaying[0]){
            btn_music_inHome.setBackground(getResources().getDrawable(R.drawable.btn_music_mute));}
        if (HomeActivity.isPlaying[0]){
            btn_music_inHome.setBackground(getResources().getDrawable(R.drawable.btn_music_normal));}

        btn_music_inHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying[0]){
                    btn_music_inHome.setBackground(getResources().getDrawable(R.drawable.btn_music_normal));
                    backgroundMusic.start();
                    isPlaying[0] = true;
                }
                else if (isPlaying[0]){
                    btn_music_inHome.setBackground(getResources().getDrawable(R.drawable.btn_music_mute));
                    backgroundMusic.pause();
                    isPlaying[0] = false;
                }

            }
        });

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == btnHahu.getId()){
            Intent hahuIntent = new Intent(this, AmharicLettersActivity.class);
            startActivity(hahuIntent);

        }
        else if (view.getId()== btnAbc.getId()){
            Intent abcIntent = new Intent(this, EnglishLettersActivity.class);
            startActivity(abcIntent);
        }
        else if (view.getId()== btnNumbers.getId()){
            Intent numbersIntent = new Intent(this, CountingNumbersActivity.class);
            startActivity(numbersIntent);
        }
        else if (view.getId()== btnHisab.getId()){
            Intent hisabIntent = new Intent(this, QuestionActivity.class);
            startActivity(hisabIntent);
        }
        else if (view.getId()== btnTeret.getId()){
            Intent teretIntent = new Intent(this, TeretTeretActivity.class);
            startActivity(teretIntent);
        }
        else if (view.getId()== btnEnqoqlsh.getId()){
            Intent enqoqlishIntent = new Intent(this, EnqoqlishActivity.class);
            //startActivity(enqoqlishIntent);
            Toast.makeText(this, "ፕሪሚየም ስለሆነ መጀመሪ ያዉርዱ::", Toast.LENGTH_SHORT).show();
        }
        else if (view.getId()== btnImages.getId()){
            Intent ImagesIntent = new Intent(this, ImagesActivity.class);
            startActivity(ImagesIntent);
        }
        else if (view.getId()== btnGame.getId()){
            Intent gameIntent = new Intent(this, ChewataActivity.class);
            startActivity(gameIntent);
        }
        else if (view.getId()== btnAmharicLetterImage.getId()){
            Intent AmharicLetterImageActivity = new Intent(this, AmharicLetterImageActivity.class);
            startActivity(AmharicLetterImageActivity);
        }else if (view.getId()== btn_back_inHome.getId()){
            onBackPressed();
        }

        }


    @Override
    protected void onPause() {
        super.onPause();
       backgroundMusic.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isPlaying[0]){
            backgroundMusic.start();
        }
        if (!HomeActivity.isPlaying[0]){
            btn_music_inHome.setBackground(getResources().getDrawable(R.drawable.btn_music_mute));}
        if (HomeActivity.isPlaying[0]){
            btn_music_inHome.setBackground(getResources().getDrawable(R.drawable.btn_music_normal));}



        // this is the problem where the sound and other

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        backgroundMusic.release();
    }

    @Override
    protected void onStop() {

        super.onStop();
        //Toast.makeText(getApplicationContext(),"music stopped called",Toast.LENGTH_SHORT).show();
       // backgroundMusic.stop();
    }
}


