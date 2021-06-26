package com.example.toshiba.yaleastemari;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.io.InputStream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class TeretTeretActivity extends AppCompatActivity implements View.OnClickListener {
    final static float move = 200;
    public static float ratio = 15.0f;
    int baseDist;
    float baseRatio;
    Button btn_back_inTeretTeretActivity;
    public static FragmentManager fragmentManager;
    public FloatingActionButton ZoomIn;
    public FloatingActionButton ZoomOut;
    public static String text;
    public static String teret1,teret2,teret3,teret4,teret5,teret6,teret7,teret8;



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getPointerCount() == 2) {
            int action = event.getAction();
            int mainaction = action & MotionEvent.ACTION_MASK;
            if (mainaction == MotionEvent.ACTION_POINTER_DOWN) {
                baseDist = getDistance(event);
                baseRatio = ratio;
            } else {
                float scale = (getDistance(event) - baseDist) / move;
                float factor = (float) Math.pow(2, scale);
                ratio = Math.min(1024.0f, Math.max(0.1f, baseRatio * factor));
                TeretTeretBoardFragment.txt_teretReader.setTextSize(ratio+15);

            }
        }
        return true;
    }

    private int getDistance(MotionEvent event) {
        int dx = (int)(event.getX(0)-event.getX(1));
        int dy = (int)(event.getY(0)-event.getY(1));
        return (int)(Math.sqrt(dx*dx+dy*dy));
    }


    public String ReadTeretTxtFile(String file){
        try {
            InputStream inputStream = getAssets().open(file);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            text = new String(buffer);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return text;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_teret_teret);
        teret1 = ReadTeretTxtFile("teret1.txt");
        teret2 = ReadTeretTxtFile("teret2.txt");
        teret3 = ReadTeretTxtFile("teret3.txt");
        teret4 = ReadTeretTxtFile("teret4.txt");
        teret5 = ReadTeretTxtFile("teret5.txt");
        teret6 = ReadTeretTxtFile("teret6.txt");
        teret7 = ReadTeretTxtFile("teret7.txt");
        teret8 = ReadTeretTxtFile("teret8.txt");
        btn_back_inTeretTeretActivity = (Button)findViewById(R.id.btn_back_inTeretTeretActivity);
        btn_back_inTeretTeretActivity.setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();

//        ZoomIn = findViewById(R.id.floatingActionButtonPlus);
//
//        ZoomOut = findViewById(R.id.floatingActionButtonMinus);
//        ZoomOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TeretTeretBoardFragment.txt_teretReader.setTextSize(ratio+15);
//            }
//        });

        if (findViewById(R.id.teretTeretFaragmentContainer) != null){
            if (savedInstanceState != null){
                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            TeretTeretHomeFragment teretTeretHomeFragment = new TeretTeretHomeFragment();
            fragmentTransaction.add(R.id.teretTeretFaragmentContainer,teretTeretHomeFragment,null);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_inTeretTeretActivity:
                onBackPressed();
                break;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
       // HomeActivity.backgroundMusic.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
       // HomeActivity.backgroundMusic.pause();
    }
}
