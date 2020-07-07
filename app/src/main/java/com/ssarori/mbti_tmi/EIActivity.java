package com.ssarori.mbti_tmi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;

public class EIActivity extends AppCompatActivity {

    ImageView ivE, ivI;
    TextView tvResult;
    String Result[];
    String answer;
    ActionBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_i);
        ivE = (ImageView)findViewById(R.id.ivE);
        ivI = (ImageView)findViewById(R.id.ivI);
        tvResult = (TextView)findViewById(R.id.tvResult);
        bar = getSupportActionBar();
        bar.setTitle("E외향과 I내향");

        InputStream inputS = getResources().openRawResource(R.raw.ei_raw);
        try {
            byte txt[] = new byte[inputS.available()];
            inputS.read(txt);
            String str = new String(txt);
            Result = str.split("#");

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),"파일을 읽어올 수 없습니다",Toast.LENGTH_SHORT).show();
        }

        ivE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            final int index;
            index = 0;
            answer = Result[index];
            tvResult.setText(answer);
            }
        });

        ivI.setOnClickListener(new View.OnClickListener() {
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
