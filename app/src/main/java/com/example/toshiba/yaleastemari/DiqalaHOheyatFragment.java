package com.example.toshiba.yaleastemari;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Dimension;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiqalaHOheyatFragment extends Fragment {

    LinearLayout[] sevenLayoutContainer;
    LinearLayout  first_letter_container,  second_letter_container, third_letter_container,
            fourth_letter_container, fifth_letter_container, sixth_letter_container, seventh_letter_container;
    public DiqalaHOheyatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       final View view = inflater.inflate(R.layout.fragment_diqala_hoheyat, container, false);


//        first_letter_container = view.findViewById(R.id.dq_first_letter_container);
//        second_letter_container = view.findViewById(R.id.dq_second_letter_container);
//        third_letter_container = view.findViewById(R.id.dq_third_letter_container);
//        fourth_letter_container = view.findViewById(R.id.dq_fourth_letter_container);
//        fifth_letter_container = view.findViewById(R.id.dq_fifth_letter_container);
//        sixth_letter_container = view.findViewById(R.id.dq_sixth_letter_container);
//        seventh_letter_container = view.findViewById(R.id.dq_seventh_letter_container);

//        sevenLayoutContainer = new LinearLayout[]{first_letter_container,second_letter_container,third_letter_container,
//                fourth_letter_container, fifth_letter_container,sixth_letter_container,seventh_letter_container};
//
//
//        for (int i = 0; i < ListOfLetters.diqal_letter.length;i++){
//
//                final TextView btn = new TextView(view.getContext());
//                String letter = ListOfLetters.diqal_letter[i];
//                btn.setText(letter);
//
//                btn.setTextSize(Dimension.SP,37);
//                btn.setPadding(10,0,0,0);
//                final int finalI = i;
//
//
//                btn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        Animation animation = AnimationUtils.loadAnimation(view.getContext(),R.anim.letter_pressed);
//                        btn.startAnimation(animation);
//                    }
//                });
//
//
//                }
        return view;


    }

}
