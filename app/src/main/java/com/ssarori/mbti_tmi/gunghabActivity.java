package com.ssarori.mbti_tmi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class gunghabActivity extends AppCompatActivity {

    Spinner spinMBTI1, spinMBTI2;
    String MBTI[] = {"ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP", "ESTP", "ESFP", "ENFP", "ENTP", "ESTJ", "ESFJ", "ENFJ", "ENTJ"};

    String[][] arr = {
            {"INFP&ISFP", "INFP&ESFP", "INFP&ISTP", "INFP&ESTP", "INFP&ISFJ", "INFP&ESFJ", "INFP&ISTJ", "INFP&ESTJ",
                    "ENFP&ISFP", "ENFP&ESFP", "ENFP&ISTP", "ENFP&ESTP", "ENFP&ISFJ", "ENFP&ESFJ", "ENFP&ISTJ", "ENFP&ESTJ", "INFJ&ISFP",
                    "INFJ&ESFP", "INFJ&ISTP", "INFJ&ESTP", "INFJ&ISFJ", "INFJ&ESFJ", "INFJ&ISTJ", "INFJ&ESTJ", "ENFJ&ESFP", "ENFJ&ISTP",
                    "ENFJ&ESTP", "ENFJ&ISFJ", "ENFJ&ESFJ", "ENFJ&ISTJ", "ENFJ&ESTJ", "ISFP&INFP", "ISFP&ENFP", "ISFP&INFJ", "ESFP&INFP",
                    "ESFP&ENFP", "ESFP&INFJ", "ESFP&ENFJ", "ISTP&INFP", "ISTP&ENFP", "ISTP&INFJ", "ISTP&ENFJ", "ESTP&INFP", "ESTP&ENFP",
                    "ESTP&INFJ", "ESTP&ENFJ", "ISFJ&INFP", "ISFJ&ENFP", "ISFJ&INFJ", "ISFJ&ENFJ", "ESFJ&INFP", "ESFJ&ENFP", "ESFJ&INFJ",
                    "ESFJ&ENFJ", "ISTJ&INFP", "ISTJ&ENFP", "ISTJ&INFJ", "ISTJ&ENFJ", "ESTJ&INFP", "ESTJ&ENFP", "ESTJ&INFJ", "ESTJ&ENFJ"},
            {"INTJ&ISFJ", "INTJ&ESFJ", "INTJ&ISTJ", "INTJ&ESTJ", "INTP&ISFJ", "INTP&ESFJ", "INTP&ISTJ", "ENTP&ISFJ",
                    "ENTP&ESFJ", "ENTP&ISTJ", "ENTP&ESTJ", "ISFP&ISFP", "ISFP&ESFP", "ISFP&ISTP", "ISFP&ESTP", "ESFP&ISFP", "ESFP&ESFP",
                    "ESFP&ISTP", "ESFP&ESTP", "ISTP&ISFP", "ISTP&ESFP", "ISTP&ISTP", "ISTP&ESTP", "ESTP&ISFP", "ESTP&ESFP", "ESTP&ISTP",
                    "ESTP&ESTP", "ISFJ&INTJ", "ISFJ&INTP", "ISFJ&ENTP", "ESFJ&INTJ", "ESFJ&INTP", "ESFJ&ENTP", "ISTJ&INTJ", "ISTJ&INTP",
                    "ISTJ&ENTP", "ESTJ&INTJ", "ESTJ&ENTP"},
            {"INTJ&ISFP", "INTJ&ESFP", "INTJ&ISTP", "INTJ&ESTP", "ENTJ&ISFP", "ENTJ&ESFP", "ENTJ&ISTP", "ENTJ&ESTP",
                    "ENTJ&ISFJ", "ENTJ&ESFJ", "ENTJ&ISTJ", "ENTJ&ESTJ", "INTP&ISFP", "INTP&ESFP", "INTP&ISTP", "INTP&ESTP", "ENTP&ISFP",
                    "ENTP&ESFP", "ENTP&ISTP", "ENTP&ESTP", "ISFP&INTJ", "ISFP&ENTJ", "ISFP&INTP", "ISFP&ENTP", "ISFP&ISFJ", "ISFP&ISTJ",
                    "ESFP&INTJ", "ESFP&ENTJ", "ESFP&INTP", "ESFP&ENTP", "ESFP&ESFJ", "ESFP&ESTJ", "ISTP&INTJ", "ISTP&ENTJ", "ISTP&INTP",
                    "ISTP&ENTP", "ISTP&ISFJ", "ISTP&ISTJ", "ESTP&INTJ", "ESTP&ENTJ", "ESTP&INTP", "ESTP&ENTP", "ESTP&ESFJ", "ESTP&ESTJ",
                    "ISFJ&ENTJ", "ISFJ&ISFP", "ISFJ&ISTP", "ESFJ&ENTJ", "ESFJ&ESFP", "ESFJ&ESTP", "ISTJ&ENTJ", "ISTJ&ISFP", "ISTJ&ISTP",
                    "ESTJ&ENTJ", "ESTJ&ESFP", "ESTJ&ESTP"},
            {"ENFJ&ENFJ", "ENFJ&ENFP", "ENFJ&ENTJ", "ENFJ&ENTP", "ENFJ&INFJ", "ENFJ&INTJ", "ENFJ&INTP", "ENFP&ENFJ",
                    "ENFP&ENFP", "ENFP&ENTJ", "ENFP&ENTP", "ENFP&INFP", "ENFP&INTP", "ENTJ&ENFJ", "ENTJ&ENFP", "ENTJ&ENTJ", "ENTJ&ENTP",
                    "ENTJ&INFJ", "ENTJ&INTJ", "ENTP&ENFJ", "ENTP&ENFP", "ENTP&ENTJ", "ENTP&ENTP", "ENTP&INFP", "ENTP&INTP", "ESFJ&ESFJ",
                    "ESFJ&ESTJ", "ESFJ&ISFJ", "ESFJ&ISTJ", "ESTJ&ESFJ", "ESTJ&ESTJ", "ESTJ&ISFJ", "ESTJ&ISTJ", "INFJ&ENFJ", "INFJ&ENTJ",
                    "INFJ&INFJ", "INFJ&INFP", "INFJ&INTJ", "INFJ&INTP", "INFP&ENFP", "INFP&ENTP", "INFP&INFJ", "INFP&INFP", "INFP&INTJ",
                    "INFP&INTP", "INTJ&ENFJ", "INTJ&ENTJ", "INTJ&INFJ", "INTJ&INFP", "INTJ&INTJ", "INTJ&INTP", "INTP&ENFJ", "INTP&ENFP",
                    "INTP&ENTP", "INTP&INFJ", "INTP&INFP", "INTP&INTJ", "INTP&INTP", "ISFJ&ESFJ", "ISFJ&ESTJ", "ISFJ&ISFJ", "ISFJ&ISTJ",
                    "ISTJ&ESFJ", "ISTJ&ESTJ", "ISTJ&ISFJ", "ISTJ&ISTJ"},
            {"INFP&ENFJ", "INFP&ENTJ", "ENFP&INFJ", "ENFP&INTJ", "INFJ&ENFP", "INFJ&ENTP", "ENFJ&INFP", "ENFJ&ISFP",
                    "INTJ&ENFP", "INTJ&ENTP", "ENTJ&INFP", "ENTJ&INTP", "INTP&ENTJ", "INTP&ESTJ", "ENTP&INFJ", "ENTP&INTJ", "ISFP&ENFJ",
                    "ISFP&ESFJ", "ISFP&ESTJ", "ESFP&ISFJ", "ESFP&ISTJ", "ISTP&ESFJ", "ISTP&ESTJ", "ESTP&ISFJ", "ESTP&ISTJ", "ISFJ&ESFP",
                    "ISFJ&ESTP", "ESFJ&ISFP", "ESFJ&ISTP", "ISTJ&ESFP", "ISTJ&ESTP", "ESTJ&INTP", "ESTJ&ISFP", "ESTJ&ISTP"}
    };
    Integer testImg[] = {R.drawable.terrable, R.drawable.bad, R.drawable.half, R.drawable.good, R.drawable.supergood};
    String testResult[] = {"커플궁합 : 0%\n 궁합 최악! 다시 생각해보자", "커플궁합 : 30%\n 최악은 아니지만 좋은것도 아님", "커플궁합 : 50%\n 안 맞는 부분도 있지만 맞는 부분도 있음",
            "커플궁합 : 70%\n 아주 좋은 관계가 될 수 있음", "커플궁합 : 100%\n 네 맘이 내 맘 ! 우리는 천생연분"};
    ImageView ivResult;
    TextView tvResult;
    Button btnResult;
    String result;
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunghab);
        spinMBTI1 = (Spinner) findViewById(R.id.spinMBTI1);
        spinMBTI2 = (Spinner) findViewById(R.id.spinMBTI2);
        ivResult = (ImageView) findViewById(R.id.ivResult);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnResult = (Button) findViewById(R.id.btnResult);

        bar = getSupportActionBar();
        bar.setTitle("MBTI 궁합보기");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, MBTI);
        spinMBTI1.setAdapter(adapter);
        spinMBTI2.setAdapter(adapter);

        registerForContextMenu(ivResult);
        registerForContextMenu(tvResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = spinMBTI1.getSelectedItem().toString() + "&" + spinMBTI2.getSelectedItem().toString();

                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        if (result.equals(arr[i][j])) {
                            ivResult.setImageResource(testImg[i]);
                            tvResult.setText(testResult[i]);
                            break;
                        }
                    }
                }
            }
        });
    }
}