package com.ssarori.mbti_tmi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class SNActivity extends AppCompatActivity {

    ImageView ivS, ivN;
    TextView tvResult;
    String Result[];
    String answer;
    ActionBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_n);
        ivS = (ImageView)findViewById(R.id.ivS);
        ivN = (ImageView)findViewById(R.id.ivN);
        tvResult = (TextView)findViewById(R.id.tvResult);

        bar = getSupportActionBar();
        bar.setTitle("S감각과 N직관");

        InputStream inputS = getResources().openRawResource(R.raw.sn_raw);
        try {
            byte txt[] = new byte[inputS.available()];
            inputS.read(txt);
            String str = new String(txt);
            Result = str.split("#");

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),"파일을 읽어올 수 없습니다",Toast.LENGTH_SHORT).show();
        }

        ivS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int index;
                index = 0;
                answer = Result[index];
                tvResult.setText(answer);
            }
        });

        ivN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                                final int index;
                                                index = 0;
                                                answer = Result[index+1];
                                                tvResult.setText(answer);
            }
        });

    }
}
