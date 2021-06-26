package com.example.toshiba.yaleastemari;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class AmharicLetterImageActivity extends AppCompatActivity implements View.OnClickListener{
    Button[] all_amharic_letters_gifImageView;
    LinearLayout amharic_letters_container;
    int[] all_amharic_letters_path;
    Button btn_back_inAmharicLetterImage, btn_sound_inAmharicLetterImage;
    SoundPool soundPool;
    int soundIdArray[];

    // setContentView(R.layout.activity_amharic_letter_image);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_amharic_letter_image);

        //Todo code start here
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);// initializing the sound pool class
        soundIdArray = new int[SoundPath.amharicLettersImageSound.length];//the number of the total sound
        addAllsoundsToSoundArray();

        Animation backandforthAnim = AnimationUtils.loadAnimation(this, R.anim.back_and_forth_backbutton);
        btn_back_inAmharicLetterImage = findViewById(R.id.btn_back_inAmharicLetterImage);
        btn_sound_inAmharicLetterImage = findViewById(R.id.btn_sound_inAmharicLetterImage);

        btn_back_inAmharicLetterImage.startAnimation(backandforthAnim);
        btn_sound_inAmharicLetterImage.startAnimation(backandforthAnim);
        btn_back_inAmharicLetterImage.setOnClickListener(this);

        amharic_letters_container = findViewById(R.id.amharic_lettersImage_container);

        all_amharic_letters_path = new int[]{R.drawable.image_he,R.drawable.image_le,R.drawable.image_hhe,R.drawable.image_me,
        R.drawable.image_se,R.drawable.image_re,R.drawable.image_sse,R.drawable.image_xe,R.drawable.image_qe,
                R.drawable.image_be,R.drawable.image_ve,R.drawable.image_te,R.drawable.image_che,R.drawable.image_hhhe,
                R.drawable.image_ne,R.drawable.image_ny,R.drawable.image_a,R.drawable.image_ke,R.drawable.image_khe,R.drawable.image_we,R.drawable.image_aa,
                R.drawable.image_ze,R.drawable.image_zze,R.drawable.image_ye,R.drawable.image_de,R.drawable.image_je,R.drawable.image_ge,
                R.drawable.image_tte,R.drawable.image_cche,R.drawable.image_ppe,R.drawable.image_tse,R.drawable.image_tzse,R.drawable.image_fe,R.drawable.image_pe};


        all_amharic_letters_gifImageView = new Button[35];
        int i=0;

        while(i<=33){
            all_amharic_letters_gifImageView[i]= new Button(getApplicationContext());
            all_amharic_letters_gifImageView[i].setBackground(getResources().getDrawable(all_amharic_letters_path[i]));

            final int finalI = i;
            all_amharic_letters_gifImageView[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        play_letters_sound(finalI);
                    }
                });
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
            final int finalI1 = i;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    amharic_letters_container.addView(all_amharic_letters_gifImageView[finalI1]);

                }
            });

            i++;
        }
    }
    public void addAllsoundsToSoundArray(){
        for (int i=0;i < SoundPath.amharicLettersImageSound.length; i++){
            soundIdArray[i] = soundPool.load(this,SoundPath.amharicLettersImageSound[i],1);
        }
    }

    private void  play_letters_sound(int i){
        soundPool.play(soundIdArray[i],1,1,1,0,1);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_inAmharicLetterImage:
                onBackPressed();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        HomeActivity.backgroundMusic.pause();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
