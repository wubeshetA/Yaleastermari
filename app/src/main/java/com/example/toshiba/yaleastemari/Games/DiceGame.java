package com.example.toshiba.yaleastemari.Games;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import com.example.toshiba.yaleastemari.R;

import androidx.appcompat.app.AppCompatActivity;

public class DiceGame extends AppCompatActivity implements View.OnClickListener{

    ImageView computer_dice, player_dice,player_arrow,cpu_arrow;
    TextView txt_cpu,txt_player,txt_seekBar;
    int player_point, computer_point;
    Random random;
    Animation animation,fade;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_dice_game);
        txt_seekBar = (TextView)findViewById(R.id.txt_seekBar);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                player_point = 0;
                computer_point = 0;
                String p = ""+seekBar.getProgress();
                txt_seekBar.setText(p);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(),"በጨዋታ መሐከል መንካት\n አይቻልም：：",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        computer_dice = (ImageView)findViewById(R.id.computer_dice);
        player_dice = (ImageView)findViewById(R.id.player_dice);
        player_arrow = (ImageView)findViewById(R.id.player_arrow);
        cpu_arrow = (ImageView)findViewById(R.id.cpu_arrow);

        player_dice.setOnClickListener(this);
        computer_dice.setOnClickListener(this);
        fade = AnimationUtils.loadAnimation(this,R.anim.fade_dice_game);
       // player_arrow.startAnimation(fade_dice_game);
        //cpu_arrow.startAnimation(fade_dice_game);

        txt_cpu = (TextView) findViewById(R.id.txt_cpu);
        txt_player = (TextView) findViewById(R.id.txt_player);

        random = new Random();

    }

    private void changeComputerface(int computer_face) {
        switch (computer_face){
            case 1:
                computer_dice.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                computer_dice.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                computer_dice.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                computer_dice.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                computer_dice.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                computer_dice.setImageResource(R.drawable.dice_6);
                break;
        }
    }

    private void changePlayerface(int player_face) {
        switch (player_face){
            case 1:
                player_dice.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                player_dice.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                player_dice.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                player_dice.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                player_dice.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                player_dice.setImageResource(R.drawable.dice_6);
                break;
        }
    }


    @Override
    public void onClick(View view) {

            int player_face = random.nextInt(6) + 1;
            int computer_face = random.nextInt(6) +1;


            if (player_face > computer_face){
                player_point++;
                txt_player.setText("ተጨዋች1："+player_point);
            }
            else if (computer_face > player_face){
                computer_point++;
                txt_cpu.setText("ተጨዋች2："+computer_point);
            }
            if (player_point+computer_point == seekBar.getProgress()){
                if (player_point > computer_point) {
                    Toast.makeText(getApplicationContext(), "ተጨዋች1 አሸንፏል", Toast.LENGTH_SHORT).show();
                }
                else if (player_point < computer_point){
                    Toast.makeText(getApplicationContext(),"ተጨዋች2 አሸንፏል",Toast.LENGTH_SHORT).show();
                    }
                else{
                    Toast.makeText(getApplicationContext(),"እኩል",Toast.LENGTH_SHORT).show();
                }
                player_point = 0;
                computer_point = 0;
            }

            animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_dice_game);
            computer_dice.setAnimation(animation);
            player_dice.setAnimation(animation);
            changePlayerface(player_face);
            changeComputerface(computer_face);
            if (view.getId() == player_dice.getId()){
                cpu_arrow.setVisibility(View.VISIBLE);
                player_arrow.setVisibility(View.INVISIBLE);




            }
            if (view.getId() == computer_dice.getId()){
                cpu_arrow.setVisibility(View.INVISIBLE);
                player_arrow.setVisibility(View.VISIBLE);


            }
    }
}
