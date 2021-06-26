package com.example.toshiba.yaleastemari;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class TeretTeretBoardFragment extends Fragment implements View.OnTouchListener{


    public TeretTeretBoardFragment() {
        // Required empty public constructor
    }
    public static TextView txt_teretReader;
           TextView txt_teretTitle;
    public ImageButton fb_plus;
    public ImageButton fb_minus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teret_teret_board, container, false);
        txt_teretReader = view.findViewById(R.id.txt_teretReader);

        txt_teretTitle = (TextView)view.findViewById(R.id.txt_teretTitle);
        txt_teretReader.setText(TeretTeretHomeFragment.teretText);
        txt_teretReader.setTextSize(TeretTeretActivity.ratio);

        txt_teretTitle.setText(TeretTeretHomeFragment.teretTitle);
        fb_minus = view.findViewById(R.id.fb_minus);
        fb_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_teretReader.getTextSize();
                txt_teretReader.setTextSize(TeretTeretActivity.ratio-3);
                TeretTeretActivity.ratio -= 3;

                //Toast.makeText(getContext(), txt_teretReader.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        fb_plus = view.findViewById(R.id.fb_plus);
        fb_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_teretReader.getTextSize();
                txt_teretReader.setTextSize(TeretTeretActivity.ratio+3);
                TeretTeretActivity.ratio += 3;
               // Toast.makeText(getContext(), txt_teretReader.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

}



