package com.ssarori.mbti_tmi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class allTypeActivity extends AppCompatActivity {

    ListView list1;
    String types[] = {"ESTJ / INFP", "ENTJ / ISFP", "ESTP / INFJ", "ESFP / INTJ", "ESFJ / INTP", "ENFJ / ISTP", "ENFP / ISTJ", "ENTP / ISFJ"};
    Integer images[] = {R.drawable.estj_infp, R.drawable.entj_isfp, R.drawable.estp_infj, R.drawable.esfp_intj, R.drawable.esfj_intp, R.drawable.enfj_istp, R.drawable.enfp_istj, R.drawable.entp_isfj};
    ArrayList<String> type;
    ImageView ivResult;
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_type);
        list1 = (ListView) findViewById(R.id.list1);
        ivResult = (ImageView) findViewById(R.id.ivResult);
        type = new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, types);
        list1.setAdapter(adapter);

        bar = getSupportActionBar();
        bar.setTitle("16가지 유형의 특성");

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            for (int i = 0; i < images.length; i++) {
                ivResult.setImageResource(images[position]);
            }
            }
        });
    }
}
