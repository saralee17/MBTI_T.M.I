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

public class TFActivity extends AppCompatActivity {

    ImageView ivT, ivF;
    TextView tvResult;
    String Result[];
    String answer;
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_f);
        ivT = (ImageView)findViewById(R.id.ivT);
        ivF = (ImageView)findViewById(R.id.ivF);
        tvResult = (TextView)findViewById(R.id.tvResult);

        bar = getSupportActionBar();
        bar.setTitle("T사고와 F감정");

        InputStream inputS = getResources().openRawResource(R.raw.tf_raw);
        try {
            byte txt[] = new byte[inputS.available()];
            inputS.read(txt);
            String str = new String(txt);
            Result = str.split("#");

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),"파일을 읽어올 수 없습니다",Toast.LENGTH_SHORT).show();
        }

        ivT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int index;
                index = 0;
                answer = Result[index];
                tvResult.setText(answer);
            }
        });

        ivF.setOnClickListener(new View.OnClickListener() {
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
