package com.example.toshiba.yaleastemari;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ContactPopUpActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnCallAdmin,btnFacebook,btntwitter,btnEmail,btnTelegram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pop_up2);
        btnCallAdmin = (Button)findViewById(R.id.btnCallAdmin);
        btnFacebook = (Button)findViewById(R.id.btnFacebook);
        btntwitter = (Button)findViewById(R.id.btnTwitter);
        btnEmail = (Button)findViewById(R.id.btnEmail);
        btnTelegram = (Button)findViewById(R.id.btnTelegram);


        btnCallAdmin.setOnClickListener(this);
        btntwitter.setOnClickListener(this);
        btnFacebook.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnTelegram.setOnClickListener(this);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width * 0.6),(int)(height * 0.7));

    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCallAdmin:
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0985071739"));
                this.startActivity(intent);
                break;
            case R.id.btnFacebook:
                Intent browseFacebook = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.facebook.com/wbshet"));
                startActivity(browseFacebook);
                break;
            case R.id.btnTelegram:
                Intent browseTelegram = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.telegram.com"));
                startActivity(browseTelegram);
                break;
            case R.id.btnTwitter:
                Intent browseTwitter =  new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.twitter.com/wubeTwit"));
                startActivity(browseTwitter);
                break;
            case R.id.btnEmail:
                Intent sendEmail = new Intent(Intent.ACTION_SEND);
                sendEmail.setType("plain/text");
                sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"wubeane@gmail.com"});
                sendEmail.putExtra(Intent.EXTRA_SUBJECT,"to Contact the admin");

                startActivity(Intent.createChooser(sendEmail, "send mail..."));


                break;
        }

    }
}
