package com.example.toshiba.yaleastemari;

import android.content.Context;
import android.content.SharedPreferences;
public class SharedPreferenceConfig {


    private SharedPreferences game1_sharedPreferences, game2_sharedPreferences,game3_sharedPreferences;
    SharedPreferences level1Star,level2Star,level3Star,level4Star,level5Star,level6Star;
    private Context context;
    public SharedPreferenceConfig(Context context){
        this.context = context;
        game1_sharedPreferences = context.getSharedPreferences("game1_status_preference",Context.MODE_PRIVATE);
        game2_sharedPreferences = context.getSharedPreferences("game2_status_preference",Context.MODE_PRIVATE);
        game3_sharedPreferences = context.getSharedPreferences("game3_status_preference",Context.MODE_PRIVATE);

        level1Star = context.getSharedPreferences("level1_starts_preference",Context.MODE_PRIVATE);
        level2Star = context.getSharedPreferences("level2_starts_preference",Context.MODE_PRIVATE);
        level3Star = context.getSharedPreferences("level3_starts_preference",Context.MODE_PRIVATE);
        level4Star = context.getSharedPreferences("level4_starts_preference",Context.MODE_PRIVATE);
        level5Star = context.getSharedPreferences("level5_starts_preference",Context.MODE_PRIVATE);
        level6Star = context.getSharedPreferences("level6_starts_preference",Context.MODE_PRIVATE);


    }

    //the follwing method write number of start the player won
    public void writeLevel1Stars(int stars){
        SharedPreferences.Editor editor = level1Star.edit();
        editor.putInt("level1_starts_preference",stars);
        editor.apply();
    }
    public void writeLevel2Stars(int stars){
        SharedPreferences.Editor editor = level2Star.edit();
        editor.putInt("level2_starts_preference",stars);
        editor.apply();
    }
    public void writeLevel3Stars(int stars){
        SharedPreferences.Editor editor = level3Star.edit();
        editor.putInt("level3_starts_preference",stars);
        editor.apply();
    }
    public void writeLevel4Stars(int stars){
        SharedPreferences.Editor editor = level4Star.edit();
        editor.putInt("level4_starts_preference",stars);
        editor.apply();
    }
    public void writeLevel5Stars(int stars){
        SharedPreferences.Editor editor = level5Star.edit();
        editor.putInt("level5_starts_preference",stars);
        editor.apply();
    }
    public void writeLevel6Stars(int stars){
        SharedPreferences.Editor editor = level6Star.edit();
        editor.putInt("level6_starts_preference",stars);
        editor.apply();
    }

    // the followig methods read the number of starts saved
    public int readLevel1Stars(){
        int  stars;
        stars = level1Star.getInt("level1_starts_preference",0);
        return stars;
    }
    public int readLevel2Stars(){
        int  stars;
        stars = level2Star.getInt("level2_starts_preference",0);
        return stars;
    }
    public int readLevel3Stars(){
        int  stars;
        stars = level3Star.getInt("level3_starts_preference",0);
        return stars;
    }
    public int readLevel4Stars(){
        int  stars;
        stars = level4Star.getInt("level4_starts_preference",0);
        return stars;
    }
    public int readLevel5Stars(){
        int  stars;
        stars = level5Star.getInt("level5_starts_preference",0);
        return stars;
    }
    public int readLevel6Stars(){
        int  stars;
        stars = level6Star.getInt("level6_starts_preference",0);
        return stars;
    }

    // the following methods store the status of the games unlock == true and lock == false
    public void writeGame1Status(boolean status){
        SharedPreferences.Editor editor = game1_sharedPreferences.edit();
        editor.putBoolean("game1_status_preference",status);
        editor.commit();
    }
    public boolean readGame1Status(){
        boolean status;
        status = game1_sharedPreferences.getBoolean("game1_status_preference",false);
        return status;
    }
    public void writeGame2Status(boolean status){
        SharedPreferences.Editor editor = game2_sharedPreferences.edit();
        editor.putBoolean("game2_status_preference",status);
        editor.commit();
    }
    public boolean readGame2Status(){
        boolean status;
        status = game2_sharedPreferences.getBoolean("game2_status_preference",false);
        return status;
    }
    public void writeGame3Status(boolean status){
        SharedPreferences.Editor editor = game3_sharedPreferences.edit();
        editor.putBoolean("game3_status_preference",status);
        editor.commit();
    }
    public boolean readGame3Status(){
        boolean status;
        status = game3_sharedPreferences.getBoolean("game3_status_preference",false);
        return status;
    }

}
