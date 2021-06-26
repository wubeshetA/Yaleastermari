package com.example.toshiba.yaleastemari.Questions;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.toshiba.yaleastemari.R;
import com.example.toshiba.yaleastemari.SharedPreferenceConfig;


public class QuestionLevelFragment extends Fragment implements View.OnClickListener{
    Button btn_level1, btn_level2,btn_level3,btn_level4,btn_level5,btn_level6;
    Button btnLevel1_star,btnLevel2_star,btnLevel3_star,btnLevel4_star,btnLevel5_star,btnLevel6_star;
    public static String[][][] levelContainer;
    public static int levelSelector;
    public static String[][] selectedLevel;
    public static boolean gameStart;
    SharedPreferenceConfig sharedPreferenceConfig;
    QuestionLibrary questionLibrary = new QuestionLibrary();
    int[] starsImage;
    public int level1_stars;
    public int level2_stars;
    public int level3_stars;
    public int level4_stars;
    public int level5_stars;
    public int level6_stars;

    public QuestionLevelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_level, container, false);
        starsImage = new int[]{R.drawable.star0,R.drawable.star1,R.drawable.star2,R.drawable.star3,
                                 R.drawable.star4,R.drawable.star5};
        sharedPreferenceConfig = new SharedPreferenceConfig(view.getContext());
        btnLevel1_star = (Button)view.findViewById(R.id.btnLevel1_star);
        btnLevel2_star = (Button)view.findViewById(R.id.btnLevel2_star);
        btnLevel3_star = (Button)view.findViewById(R.id.btnLevel3_star);
        btnLevel4_star = (Button)view.findViewById(R.id.btnLevel4_star);
        btnLevel5_star = (Button)view.findViewById(R.id.btnLevel5_star);
        btnLevel6_star = (Button)view.findViewById(R.id.btnLevel6_star);
        level1_stars = sharedPreferenceConfig.readLevel1Stars();
        Log.d("message","==================================>>>>>>>>>"+level1_stars);
        btnLevel1_star.setBackground(getResources().getDrawable(starsImage[level1_stars]));

        level2_stars = sharedPreferenceConfig.readLevel2Stars();
        btnLevel2_star.setBackground(getResources().getDrawable(starsImage[level2_stars]));

        level3_stars = sharedPreferenceConfig.readLevel3Stars();
        btnLevel3_star.setBackground(getResources().getDrawable(starsImage[level3_stars]));

        level4_stars = sharedPreferenceConfig.readLevel4Stars();
        btnLevel4_star.setBackground(getResources().getDrawable(starsImage[level4_stars]));

        level5_stars = sharedPreferenceConfig.readLevel5Stars();
        btnLevel5_star.setBackground(getResources().getDrawable(starsImage[level5_stars]));

        level6_stars = sharedPreferenceConfig.readLevel6Stars();
        btnLevel6_star.setBackground(getResources().getDrawable(starsImage[level6_stars]));

        btn_level1 = (Button)view.findViewById(R.id.level1);
        btn_level2 = (Button)view.findViewById(R.id.level2);
        btn_level3 = (Button)view.findViewById(R.id.level3);
        btn_level4 = (Button)view.findViewById(R.id.level4);
        btn_level5 = (Button)view.findViewById(R.id.level5);
        btn_level6 = (Button)view.findViewById(R.id.level6);
        btn_level1.setOnClickListener(this);
        btn_level2.setOnClickListener(this);
        btn_level3.setOnClickListener(this);
        btn_level4.setOnClickListener(this);
        btn_level5.setOnClickListener(this);
        btn_level6.setOnClickListener(this);

        return view;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.level1:
                levelSelector = 1;
                selectedLevel = QuestionLibrary.choice_level1;
                startActivity(new Intent(getContext(), LetterQuestion.class));
                break;
            case R.id.level2:
                if (level1_stars == 5){
                levelSelector = 2;
                selectedLevel = QuestionLibrary.choice_level2;
                startActivity(new Intent(getContext(), LetterQuestion.class));}
                break;
            case R.id.level3:
                if (level2_stars == 5){
                    levelSelector = 3;
                    selectedLevel = QuestionLibrary.choice_level3;
                    startActivity(new Intent(getContext(), LetterQuestion.class));
                }

                break;
            case R.id.level4:
                if (level3_stars == 5){
                    levelSelector = 4;
                    selectedLevel = QuestionLibrary.choice_level4;
                    startActivity(new Intent(getContext(), LetterQuestion.class));
                }

                break;
            case R.id.level5:
                if (level4_stars == 5){
                    levelSelector = 5;
                    selectedLevel = QuestionLibrary.choice_level5;
                    startActivity(new Intent(getContext(), LetterQuestion.class));
                }

                break;
            case R.id.level6:
                if(level5_stars == 5){
                    levelSelector = 6;
                    selectedLevel = QuestionLibrary.choice_level6;
                    startActivity(new Intent(getContext(), LetterQuestion.class));
                }

                break;


        }
    }
}
