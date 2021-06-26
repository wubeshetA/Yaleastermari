package com.example.toshiba.yaleastemari;

import android.media.AudioManager;
import android.media.SoundPool;
//import android.support.annotation.Dimension;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CountingNumbersActivity extends AppCompatActivity implements View.OnClickListener{
    LinearLayout arebic_number_conainer, geez_number_container;
    TextView txt_geez_number, txt_arebic_number;
    String[] geezNumberList;
    String[] amharicNumberList;
    Button[]  amhButton;
    Button[] geezButton;
    Button btn_back_countingNumber, btn_sound_countingNumber,btn_music_countingNumber;
    int [] ListOfImagesNumber;
    ImageView imageNumber,cloud1_inNumber,cloud2_inNumber;
    SoundPool soundNumber;
    int[] soundNumberArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_counting_numbers);

        soundNumber = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        soundNumberArray = new int[SoundPath.numbersSound.length];

        for (int i=0; i<SoundPath.numbersSound.length; i++){
            soundNumberArray[i]= soundNumber.load(this,SoundPath.numbersSound[i],1);
        }



        //TODO CODE STARTS HERE

        cloud1_inNumber = (ImageView)findViewById(R.id.cloud1_inNumber);
        cloud2_inNumber = (ImageView)findViewById(R.id.cloud2_inNumber);
        Animation cloud1_anim = AnimationUtils.loadAnimation(this, R.anim.cloud1_animation);
        Animation cloud2_anim = AnimationUtils.loadAnimation(this, R.anim.cloud2_animation);
        cloud1_inNumber.startAnimation(cloud1_anim);
        cloud2_inNumber.startAnimation(cloud2_anim);

        //starting the back,sound and music button
        Animation backandforthAnim = AnimationUtils.loadAnimation(this, R.anim.back_and_forth_backbutton);
        btn_back_countingNumber =(Button)findViewById(R.id.btn_back_incountingNumber);
        btn_sound_countingNumber =(Button)findViewById(R.id.btn_sound_incountingNumber);
      //  btn_music_countingNumber =(Button)findViewById(R.id.btn_music_incountingNumber);

        btn_back_countingNumber.startAnimation(backandforthAnim);
        btn_sound_countingNumber.startAnimation(backandforthAnim);
      //  btn_music_countingNumber.startAnimation(backandforthAnim);
        btn_back_countingNumber.setOnClickListener(this);

        arebic_number_conainer = (LinearLayout)findViewById(R.id.arebic_number_conainer);
        geez_number_container = (LinearLayout)findViewById(R.id.geez_number_container);
        txt_arebic_number = (TextView)findViewById(R.id.txt_arebic_number);
        txt_geez_number = (TextView)findViewById(R.id.txt_geez_number);
        imageNumber =(ImageView)findViewById(R.id.imageNumberContainer);
        ListOfImagesNumber = new int[]{R.drawable.num1,R.drawable.num2,R.drawable.num3,R.drawable.num4,R.drawable.num5,
                R.drawable.num6,R.drawable.num7,R.drawable.num8,R.drawable.num9,R.drawable.num10,R.drawable.num11,
                R.drawable.num12,R.drawable.num13,R.drawable.num14,R.drawable.num15,R.drawable.num16,R.drawable.num17,
                R.drawable.num18,R.drawable.num19,R.drawable.num20};

        amharicNumberList = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9","10","11","12","13","14","15","16","17","18","19","20"};
        geezNumberList = new String[]{"፩", "፪", "፫", "፬", "፭", "፮", "፯", "፰", "፱", "፲", "፲፩","፲፪","፲፫","፲፬","፲፭","፲፮","፲፯","፲፰","፲፱", "፳"};



        amhButton = new Button[amharicNumberList.length];
        geezButton = new Button[geezNumberList.length];
        for (int i=0; i < amharicNumberList.length;i++){ //here the condition may geexNumberList array
            amhButton[i] = new Button(this);
            geezButton[i] = new Button(this);

            amhButton[i].setTextSize(22);
            geezButton[i].setTextSize(22);
            amhButton[i].setText(amharicNumberList[i]);
            geezButton[i].setText(geezNumberList[i]);
            amhButton[i].setBackground(getResources().getDrawable(R.drawable.small_button_bg_circular));
            geezButton[i].setBackground(getResources().getDrawable(R.drawable.small_button_bg_circular));


            final int finalI = i;
            amhButton[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation animation = AnimationUtils.loadAnimation(CountingNumbersActivity.this, R.anim.scale_up_anim);
                    txt_geez_number.setText(geezButton[finalI].getText());
                    txt_arebic_number.setText(amhButton[finalI].getText());
                    imageNumber.setBackground(getResources().getDrawable(ListOfImagesNumber[finalI]));

//                    txt_arebic_number.startAnimation(animation);
//                    txt_geez_number.startAnimation(animation);
                    imageNumber.startAnimation(animation);
                    play_letters_sound(finalI);



                }
            });


            geezButton[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation animation = AnimationUtils.loadAnimation(CountingNumbersActivity.this, R.anim.scale_up_anim);
                    txt_geez_number.setText(geezButton[finalI].getText());
                    txt_arebic_number.setText(amhButton[finalI].getText());
                    imageNumber.setBackground(getResources().getDrawable(ListOfImagesNumber[finalI]));

//                    txt_arebic_number.startAnimation(animation);
//                    txt_geez_number.startAnimation(animation);
                    imageNumber.startAnimation(animation);
                    play_letters_sound(finalI);

                }
            });

            arebic_number_conainer.addView(amhButton[i]);
            geez_number_container.addView(geezButton[i]);

        }
    }
    private void  play_letters_sound(int i){
        soundNumber.play(soundNumberArray[i],3,3,1,0,1);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_back_incountingNumber:
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
        HomeActivity.backgroundMusic.pause();
    }
}
