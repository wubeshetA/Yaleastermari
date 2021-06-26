package com.example.toshiba.yaleastemari;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class TeretTeretHomeFragment extends Fragment implements View.OnClickListener {
    public static String teretText,teretTitle;
    public TeretTeretHomeFragment() {
        // Required empty public constructor
    }
    Button btnTerert1,btnTerert2,btnTerert3,btnTerert4,btnTerert5,btnTerert6,btnTerert7,btnTerert8;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_teret_teret_home, container, false);

        btnTerert1 = (Button)view.findViewById(R.id.btn_teret1);
        btnTerert2 = (Button)view.findViewById(R.id.btn_teret2);
        btnTerert3 = (Button)view.findViewById(R.id.btn_teret3);
        btnTerert4 = (Button)view.findViewById(R.id.btn_teret4);
        btnTerert5 = (Button)view.findViewById(R.id.btn_teret5);
        btnTerert6 = (Button)view.findViewById(R.id.btn_teret6);
        btnTerert7 = (Button)view.findViewById(R.id.btn_teret7);
        btnTerert8 = (Button)view.findViewById(R.id.btn_teret8);

        btnTerert1.setOnClickListener(this);
        btnTerert2.setOnClickListener(this);
        btnTerert3.setOnClickListener(this);
        btnTerert4.setOnClickListener(this);
        btnTerert5.setOnClickListener(this);
        btnTerert6.setOnClickListener(this);
        btnTerert7.setOnClickListener(this);
        btnTerert8.setOnClickListener(this);



        return view;
    }
//    TeretTeretActivity t = new TeretTeretActivity();
    @Override
    public void onClick(View v) {
        TeretTeretActivity.fragmentManager.beginTransaction()
                .replace(R.id.teretTeretFaragmentContainer, new TeretTeretBoardFragment())
                .addToBackStack(null).commit();
        switch (v.getId()){
            case R.id.btn_teret1:
                teretText = TeretTeretActivity.teret1;
                teretTitle = "ስንዝሮ";

                break;
            case R.id.btn_teret2:
                teretText = TeretTeretActivity.teret2;
                teretTitle = "በሬና አህያ";
                break;
            case R.id.btn_teret3:
                teretText = TeretTeretActivity.teret3;
                teretTitle = "ውሻና አህያ";
                break;
            case R.id.btn_teret4:
                teretText = TeretTeretActivity.teret4;
                teretTitle = "የጅቦች ሃዘን";
                break;
            case R.id.btn_teret5:
                teretText = TeretTeretActivity.teret5;
                teretTitle = "ድሃውና ሃብታሙ";
                break;
            case R.id.btn_teret6:
                teretText = TeretTeretActivity.teret6;
                teretTitle = "የእንስሳቱ ንጉሥ";
                break;
            case R.id.btn_teret7:
                teretText = TeretTeretActivity.teret7;
                teretTitle = "ነብርና ድኩላ";
                break;
            case R.id.btn_teret8:
                teretText = TeretTeretActivity.teret8;
                teretTitle = "እናት ጦጣ እና አባት ዝንጀሮ";
                break;


        }
    }
}
