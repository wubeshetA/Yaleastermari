package com.example.toshiba.yaleastemari;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.annotation.Dimension;
import androidx.appcompat.app.AppCompatActivity;


public class AmharicLettersActivity extends AppCompatActivity {

    Button btn_back_inAmharic,btn_sound_inAmharic,btn_music_inAmharic;
    SoundPool soundPool;//
    SoundPool soundDiqala;//this is the sound of the diqalal letters
    // container for all the sound of for the amharic letters (path to the raw file)
    private int[][] soundIdArray;                  //used contain all the sounds id by plugin using the for loop
    LinearLayout[] sevenLayoutContainer;
    LinearLayout  first_letter_container,  second_letter_container, third_letter_container, fourth_letter_container, fifth_letter_container, sixth_letter_container, seventh_letter_container;
    TabHost tabHost;
    LinearLayout tab2;
    int[] soundDiqalaArray;
    boolean isPlaying;


//    public void getScreenDensity() {
//        Display d=getWindowManager().getDefaultDisplay();
//        Toast.makeText(this, String.format("%d", d.getWidth()),Toast.LENGTH_LONG).show();
//        int density = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_LONG_MASK;
//        switch (density){
//            case Configuration.SCREENLAYOUT_SIZE_LARGE:
//                Toast.makeText(this,"large screen",Toast.LENGTH_SHORT).show();
//                break;
//            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
//                Toast.makeText(this,"normal screen",Toast.LENGTH_SHORT).show();
//                break;
//            case Configuration.SCREENLAYOUT_SIZE_SMALL:
//                Toast.makeText(this,"small screen",Toast.LENGTH_SHORT).show();
//                break;
//            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
//                Toast.makeText(this,"xlarge screen",Toast.LENGTH_SHORT).show();
//                break;
//
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_amharic_letters);
        //TODO code starts here
        isPlaying = true;
//        getScreenDensity();
/**
 * the following tab initialization is used when tab 2 is pressed to switch to diqala hoheyat
 */
        tab2 = findViewById(R.id.tab2);
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        first_letter_container = (LinearLayout)findViewById(R.id.first_letter_container);
        second_letter_container = (LinearLayout)findViewById(R.id.second_letter_container);
        third_letter_container = (LinearLayout)findViewById(R.id.third_letter_container);
        fourth_letter_container = (LinearLayout)findViewById(R.id.fourth_letter_container);
        fifth_letter_container = (LinearLayout)findViewById(R.id.fifth_letter_container);
        sixth_letter_container = (LinearLayout)findViewById(R.id.sixth_letter_container);
        seventh_letter_container = (LinearLayout)findViewById(R.id.seventh_letter_container);

        btn_back_inAmharic = (Button)findViewById(R.id.btn_back_inAmharic);
        btn_sound_inAmharic = (Button)findViewById(R.id.btn_sound_inAmharic);

        btn_sound_inAmharic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying){
                    btn_sound_inAmharic.setBackground(getResources().getDrawable(R.drawable.btn_sound_mute));
                    isPlaying = false;

                }
                else if (!isPlaying){
                    btn_sound_inAmharic.setBackground(getResources().getDrawable(R.drawable.btn_sound_normal));
                    isPlaying = true;

                }
            }
        });

        //btn_music_inAmharic = (Button)findViewById(R.id.btn_music_inAmharic);

        btn_back_inAmharic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Animation backandforthAnim = AnimationUtils.loadAnimation(this, R.anim.back_and_forth_backbutton);
        btn_back_inAmharic.startAnimation(backandforthAnim);
        btn_sound_inAmharic.startAnimation(backandforthAnim);
        //   btn_music_inAmharic.startAnimation(backandforthAnim);

        sevenLayoutContainer = new LinearLayout[]{first_letter_container,second_letter_container,third_letter_container,
                fourth_letter_container, fifth_letter_container,sixth_letter_container,seventh_letter_container};



        /**
         * the following is tab used to consider the other type of amharic alphabets
         * like diqala hoheyat and yeqes school hoheyat
         */

        tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("creator");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("አማርኛ ሆሄያት");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("creator");
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator("ዲቃላ ሆሄያት");

        tabHost.addTab(tabSpec);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);// initializing the sound pool class
        soundDiqala = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundDiqalaArray = new int[]{};


        soundIdArray = new int[SoundPath.amharicLettersSoundPath.length][7];//the number of the total sound

        //the following is the pluger for each sound in to soundIdArray
        // this code would be method and will be called to the on create method
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                addAllsoundsToSoundArray();
            }
        });
        thread.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                addingAlltheLettersToView();
            }
        });
        thread2.start();


    }
    public void addAllsoundsToSoundArray(){
        for (int i=0;i<=SoundPath.amharicLettersSoundPath.length-1;i++){
            for (int j=0;j<=6;j++){
                soundIdArray[i][j]= soundPool.load(getApplicationContext(),SoundPath.amharicLettersSoundPath[i][j],1);
            }
        }
    }


    public  void addingAlltheLettersToView() {
        //the logical code starts here;

        for (int i = 0; i < ListOfLetters.all_letters.length;i++){
            for (int j =0; j <= 6;j++){
                final TextView btn = new TextView(AmharicLettersActivity.this);
                String letter = ListOfLetters.all_letters[i][j];
                btn.setText(letter);
                btn.setTextColor(getResources().getColor(R.color.amharic_letter));


                Display display=getWindowManager().getDefaultDisplay();
                int d = display.getWidth();
                if (d <= 850){
                    btn.setTextSize(Dimension.SP,38);
                    btn.setPadding(16,0,0,0);
                }
                else if(d >= 1300){
                    btn.setTextSize(Dimension.SP,47);
                    btn.setPadding(47,0,0,0);
                }
                else{
                    btn.setTextSize(Dimension.SP,40);
                    btn.setPadding(25,0,0,0);
                }

                //for small sized
  //              btn.setTextSize(Dimension.SP,37);
//                btn.setPadding(13,0,0,0);




                final int finalI = i;
                final int finalJ = j;


                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.letter_pressed);
                                btn.startAnimation(animation);
                                play_letters_sound(finalI, finalJ);
                    }
                });
                final int finalJ1 = j;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        sevenLayoutContainer[finalJ1].addView(btn);
                    }
                });


            }
        }
    }

    private void  play_letters_sound( int i, int j){
        if (isPlaying){

                    soundPool.play(soundIdArray[i][j],3,3,1,0,1);

        }

    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {

        super.onResume();
        HomeActivity.backgroundMusic.pause();
    }

    public void diqalaHoheytClicked(View view) {
        switch (view.getId()){
            case R.id.lua:
                soundDiqala.play(soundDiqalaArray[0],1,1,1,0,1);
                break;
            case R.id.mua:
                soundDiqala.play(soundDiqalaArray[1],1,1,1,0,1);
                break;
            case R.id.rua:
                soundDiqala.play(soundDiqalaArray[2],1,1,1,0,1);
                break;
            case R.id.sua:
                soundDiqala.play(soundDiqalaArray[3],1,1,1,0,1);
                break;
            case R.id.xua:
                soundDiqala.play(soundDiqalaArray[4],1,1,1,0,1);
                break;
            case R.id.bua:
                soundDiqala.play(soundDiqalaArray[5],1,1,1,0,1);
                break;
            case R.id.tua:
                soundDiqala.play(soundDiqalaArray[6],1,1,1,0,1);
                break;
            case R.id.cua:
                soundDiqala.play(soundDiqalaArray[7],1,1,1,0,1);
                break;
            case R.id.nua:
                soundDiqala.play(soundDiqalaArray[8],1,1,1,0,1);
                break;
            case R.id.nyua:
                soundDiqala.play(soundDiqalaArray[9],1,1,1,0,1);
                break;
            case R.id.zua:
                soundDiqala.play(soundDiqalaArray[10],1,1,1,0,1);
                break;
            case R.id.zyua:
                soundDiqala.play(soundDiqalaArray[11],1,1,1,0,1);
                break;
            case R.id.dua:
                soundDiqala.play(soundDiqalaArray[12],1,1,1,0,1);
                break;
            case R.id.ttua:
                soundDiqala.play(soundDiqalaArray[13],1,1,1,0,1);
                break;
            case R.id.tsua:
                soundDiqala.play(soundDiqalaArray[14],1,1,1,0,1);
                break;
            case R.id.fua:
                soundDiqala.play(soundDiqalaArray[15],1,1,1,0,1);
                break;


        }
    }
}
