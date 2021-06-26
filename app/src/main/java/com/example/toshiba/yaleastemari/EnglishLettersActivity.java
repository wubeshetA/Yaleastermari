package com.example.toshiba.yaleastemari;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import com.felipecsl.gifimageview.library.GifImageView;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;

import androidx.appcompat.app.AppCompatActivity;

public class EnglishLettersActivity extends AppCompatActivity implements View.OnClickListener{
    GifImageView[] all_english_letters_gifImageView;
    LinearLayout english_letters_container;
    String[] all_english_letters_path;
    Button btn_back_inEnglishLetter, btn_sound_inEnglishLetter,btn_music_inEnglishLetter;
    SoundPool soundPool;
    int soundIdArray[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_english_letters);

        //Todo code start here
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);// initializing the sound pool class
        soundIdArray = new int[SoundPath.englishLettersSound.length];//the number of the total sound
        addAllsoundsToSoundArray();

        Animation backandforthAnim = AnimationUtils.loadAnimation(this, R.anim.back_and_forth_backbutton);
        btn_back_inEnglishLetter = (Button)findViewById(R.id.btn_back_inEnglishLetter);
        btn_sound_inEnglishLetter = (Button)findViewById(R.id.btn_sound_inEnglishLetter);

        btn_back_inEnglishLetter.startAnimation(backandforthAnim);
        btn_sound_inEnglishLetter.startAnimation(backandforthAnim);
        btn_back_inEnglishLetter.setOnClickListener(this);

        english_letters_container = findViewById(R.id.english_letters_container);

        all_english_letters_path = new String[]{"letter_a.gif","letter_b.gif","letter_c.gif",
                "letter_d.gif","letter_e.gif","letter_f.gif","letter_g.gif","letter_h.gif",
                "letter_i.gif","letter_j.gif","letter_k.gif","letter_l.gif","letter_m.gif",
                "letter_n.gif","letter_o.gif","letter_p.gif","letter_q.gif","letter_r.gif",
                "letter_s.gif","letter_t.gif","letter_u.gif","letter_v.gif","letter_w.gif",
                "letter_x.gif","letter_y.gif","letter_z.gif"};


        all_english_letters_gifImageView = new GifImageView[26];
        int i=0;
        while(i<=25){
            all_english_letters_gifImageView[i]= new GifImageView(getApplicationContext());
            try {
                InputStream inputStream = getAssets().open(all_english_letters_path[i]);
                byte[] bytes = IOUtils.toByteArray(inputStream);
                all_english_letters_gifImageView[i].setBytes(bytes);
                all_english_letters_gifImageView[i].startAnimation();
                final int finalI = i;
                all_english_letters_gifImageView[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        play_letters_sound(finalI);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
            final int finalI1 = i;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    english_letters_container.addView(all_english_letters_gifImageView[finalI1]);
                }
            });



            i++;
        }
}
    public void addAllsoundsToSoundArray(){
        for (int i=0;i < SoundPath.englishLettersSound.length; i++){
                soundIdArray[i] = soundPool.load(this,SoundPath.englishLettersSound[i],1);
        }
    }

    private void  play_letters_sound(int i){
        soundPool.play(soundIdArray[i],1,1,1,0,1);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_inEnglishLetter:
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
