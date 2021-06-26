package com.example.toshiba.yaleastemari.Questions;

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
import android.widget.TextView;

import com.example.toshiba.yaleastemari.R;
import com.example.toshiba.yaleastemari.SharedPreferenceConfig;
import com.example.toshiba.yaleastemari.ShowCongratulation;
import com.example.toshiba.yaleastemari.ShowResult;
import com.example.toshiba.yaleastemari.SoundPath;

import java.util.ArrayList;
import java.util.Collections;

public class LetterQuestion extends AppCompatActivity {
    QuestionLibrary questionLibrary = new QuestionLibrary();
    Button buttonChoice1,buttonChoice2,buttonChoice3,buttonChoice4,buttonChoice5,buttonChoice6;
    Button btn_back_inLetterQuestion,btnSound_inLetterQuestion;
    TextView txt_score,txt_level;
    int score;
    public static int ScoreToShowresult;
    String answer;
    int questionNumber = 0;
    private int[][] soundIdArray;
    MediaPlayer mediaPlayer;
    SharedPreferenceConfig sharedPreferenceConfig;
    String[][] selectedLevel;
    public String level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_letter_question);

        QuestionLevelFragment.gameStart = true;
        Animation backandforthAnim = AnimationUtils.loadAnimation(LetterQuestion.this, R.anim.back_and_forth_backbutton);
        //the following onclick listner is used to repeate the sound in the question
        //

        btn_back_inLetterQuestion = (Button)findViewById(R.id.btn_back_inLetterQuestion) ;
        btn_back_inLetterQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnSound_inLetterQuestion = (Button)findViewById(R.id.btnSound_inLetterQuestion) ;

        btnSound_inLetterQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_question_sound(questionNumber-1);
            }
        });

        selectedLevel = QuestionLevelFragment.selectedLevel;
        soundIdArray = new int[6][5];
        addAllsoundsToSoundArray();
        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());

        //sound stuff end here
        txt_level = (TextView)findViewById(R.id.txt_level);
        level = ""+QuestionLevelFragment.levelSelector;
        txt_level.setText(level);
        txt_score = (TextView)findViewById(R.id.txt_score);
        buttonChoice1 = (Button)findViewById(R.id.choice1);
        buttonChoice2 = (Button)findViewById(R.id.choice2);
        buttonChoice3 = (Button)findViewById(R.id.choice3);
        buttonChoice4 = (Button)findViewById(R.id.choice4);
        buttonChoice5 = (Button)findViewById(R.id.choice5);
        buttonChoice6 = (Button)findViewById(R.id.choice6);
        /**
         * initilizing the animation of the buttons
         */

        btn_back_inLetterQuestion.startAnimation(backandforthAnim);
        btnSound_inLetterQuestion.startAnimation(backandforthAnim);
        buttonChoice1.startAnimation(backandforthAnim);
        buttonChoice2.startAnimation(backandforthAnim);
        buttonChoice3.startAnimation(backandforthAnim);
        buttonChoice4.startAnimation(backandforthAnim);
        buttonChoice5.startAnimation(backandforthAnim);
        buttonChoice6.startAnimation(backandforthAnim);
        updateQuestion();
        /**
         * Start of Button Listener for Button1
         * each amharic letter question have 6 choice
         * all the questions are sound
         * and all the choice are written on the button and the user choose the correct answer
         */
        final Button[] choicebuttons = new Button[]{buttonChoice1,buttonChoice2,buttonChoice3,buttonChoice4,buttonChoice5,buttonChoice6};
        for (int i = 0;i<6;i++){
            final int finalI = i;
            choicebuttons[finalI].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(choicebuttons[finalI].getText() == answer){
                        score = score + 20;

                        updateScore(score);
                        updateQuestion();
                       // Toast.makeText(LetterQuestion.this, "correct",Toast.LENGTH_SHORT).show();
                    }
                    else{
                       // Toast.makeText(LetterQuestion.this, "wrong",Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }
                }
            });
        }

    }

    /**
     * the following method add all the sound to soundArray array
     * since load method in SoundPool class return int the soundArray array is integer value collector
     * since in the soundArray array there is "yetua Nat" sound at index of 0 the following method starts from 1.
     */

    private void addAllsoundsToSoundArray() {
        for (int i = 0; i < SoundPath.selectedQuestionLettersSound.length; i++) {
            for (int j = 0; j < SoundPath.selectedQuestionLettersSound[i].length; j++) {
                soundIdArray[i][j] = SoundPath.selectedQuestionLettersSound[i][j];
            }
        }
    }

    private void updateQuestion()  {
//        QuestionActivity.btnSound_inQuestionActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                play_question_sound(questionNumber);
//            }
//        });
        ScoreToShowresult = score;
        if (questionNumber == 5){
            int s = score/20;
            switch (level){
                case "1":
                    if(s > sharedPreferenceConfig.readLevel1Stars()){
                        sharedPreferenceConfig.writeLevel1Stars(s);

                    }
                    if (score == 100){
                        sharedPreferenceConfig.writeGame1Status(true);
                        showCongratulation();
                        score = 0;
                        questionNumber = 0;

                        return;
                    }
                    else {
                        showResult(score);
                        score = 0;
                        questionNumber = 0;
                        return;
                    }

                case "2":
                    if(s > sharedPreferenceConfig.readLevel2Stars()){
                        sharedPreferenceConfig.writeLevel2Stars(s);
                    }
                    if (score == 100){
                        sharedPreferenceConfig.writeGame2Status(true);
                        showCongratulation();
                        score = 0;
                        questionNumber = 0;
                        return;
                    }
                    else {
                        showResult(score);
                        score = 0;
                        questionNumber = 0;
                        return;
                    }

                case "3":
                    if(s > sharedPreferenceConfig.readLevel3Stars()){
                        sharedPreferenceConfig.writeLevel3Stars(s);
                    }

                    if (score == 100){
                        showCongratulation();
                        score = 0;
                        questionNumber = 0;
                        return;
                    }
                    else {
                        showResult(score);
                        score = 0;
                        questionNumber = 0;
                        return;
                    }
                case "4":
                    if(s > sharedPreferenceConfig.readLevel4Stars()){
                        sharedPreferenceConfig.writeLevel4Stars(s);
                    }

                    if (score == 100){
                        showCongratulation();
                        score = 0;
                        questionNumber = 0;
                        return;
                    }
                    else {
                        showResult(score);
                        score = 0;
                        questionNumber = 0;
                        return;
                    }
                case "5":
                    if(s > sharedPreferenceConfig.readLevel5Stars()){
                        sharedPreferenceConfig.writeLevel5Stars(s);
                    }
                    if (score == 100){
                        showCongratulation();
                        score = 0;
                        questionNumber = 0;
                        return;
                    }
                    else {
                        showResult(score);
                        score = 0;
                        questionNumber = 0;
                        return;
                    }
                case "6":
                    if(s > sharedPreferenceConfig.readLevel6Stars()) {
                        sharedPreferenceConfig.writeLevel6Stars(s);
                    }
                    if (score == 100){
                        showCongratulation();
                        score = 0;
                        questionNumber = 0;
                        return;
                    }
                    else {
                        showResult(score);
                        score = 0;
                        questionNumber = 0;
                        return;
                    }
            }

        }
        else {
            ArrayList<String> choice = new ArrayList<>();
            for (int i=0;i<selectedLevel[questionNumber].length;i++){
                choice.add(selectedLevel[questionNumber][i]);
            }
            Collections.shuffle(choice);

                buttonChoice1.setText(choice.get(0));
                buttonChoice2.setText(choice.get(1));
                buttonChoice3.setText(choice.get(2));
                buttonChoice4.setText(choice.get(3));
                buttonChoice5.setText(choice.get(4));
                buttonChoice6.setText(choice.get(5));
                Animation animation = AnimationUtils.loadAnimation(LetterQuestion.this, R.anim.scale_up_anim);
                buttonChoice1.startAnimation(animation);
                buttonChoice2.startAnimation(animation);
                buttonChoice3.startAnimation(animation);
                buttonChoice4.startAnimation(animation);
                buttonChoice5.startAnimation(animation);
                buttonChoice6.startAnimation(animation);
                answer = QuestionLibrary.CorrectAnswer[Integer.parseInt(level)-1][questionNumber];
                play_question_sound(questionNumber);
                questionNumber++;



        }
    }

    private void showResult(int result) {

        Intent intent  = new Intent(this, ShowResult.class);
        startActivity(intent);
        overridePendingTransition(R.anim.start_show_result_scale0,R.anim.end_show_result_scale100);


    }

    private void showCongratulation() {

        Intent intent  = new Intent(this, ShowCongratulation.class);
        startActivity(intent);
        overridePendingTransition(R.anim.start_show_result_scale0,R.anim.end_show_result_scale100);
    }

    private void  play_question_sound(final int index){

        mediaPlayer = MediaPlayer.create(this,soundIdArray[Integer.parseInt(level)-1][index]);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
                mediaPlayer = MediaPlayer.create(LetterQuestion.this,R.raw.post_fidel);
                mediaPlayer.start();
            }
        });
        mediaPlayer.start();
    }

    private void updateScore(int score) {
        txt_score.setText(""+score);
    }
}
