package com.example.toshiba.yaleastemari;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
EditText txt_password;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txt_password = (EditText)findViewById(R.id.txt_password);
        btn_login = (Button)findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txt_password.getText().toString().equals("wube13579")){
                    Intent intent = new Intent(Login.this, SplashScreen.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "pasword Incorrect \n give only for Wubeshet to open it",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
