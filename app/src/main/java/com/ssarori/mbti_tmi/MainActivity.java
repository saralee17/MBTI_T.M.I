package com.ssarori.mbti_tmi;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView1;
    MyAdapter adapter;
    List<itemData> data;
    Integer imgID[] = {R.drawable.menu01, R.drawable.menu02, R.drawable.menu03, R.drawable.menu04, R.drawable.menu05,
            R.drawable.menu06, R.drawable.menu07, R.drawable.menu08, R.drawable.menu09, R.drawable.menu10};
    String title[] = {"MBTI 검사하기", "MBTI 궁합보기", "E외향과 I내향", "P인식과 J판단", "S감각과 N직관",
            "T사고와 F감정", "연애능력치 테스트", "친구 MBTI 리스트", "4가지 기질 별 특성", "16가지 유형의 특성"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView1 = (GridView) findViewById(R.id.gridView1);
        data = new ArrayList<>();
        for (int i = 0; i < imgID.length; i++) {
            data.add(new itemData(imgID[i], title[i]));
        }
        adapter = new MyAdapter(this, data);
        gridView1.setAdapter(adapter);

        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent mintent;
            switch (position) {
                case 0:
                    Uri uri1 = Uri.parse("https://www.16personalities.com/ko/");
                    mintent = new Intent(Intent.ACTION_VIEW, uri1);
                    startActivity(mintent); //해당 액티비티 호출
                    break;
                case 1:
                    mintent = new Intent(getApplicationContext(), gunghabActivity.class);
                    startActivity(mintent);
                    break;
                case 2:
                    mintent = new Intent(getApplicationContext(), EIActivity.class);
                    startActivity(mintent);
                    break;
                case 3:
                    mintent = new Intent(getApplicationContext(), PJActivity.class);
                    startActivity(mintent);
                    break;
                case 4:
                    mintent = new Intent(getApplicationContext(), SNActivity.class);
                    startActivity(mintent);
                    break;
                case 5:
                    mintent = new Intent(getApplicationContext(), TFActivity.class);
                    startActivity(mintent);
                    break;
                case 6:
                    Uri uri2 = Uri.parse("http://mbti.glam.am/intro");
                    mintent = new Intent(Intent.ACTION_VIEW, uri2);
                    startActivity(mintent); //해당 액티비티 호출
                    break;
                case 7:
                    mintent = new Intent(getApplicationContext(), recordActivity.class);
                    startActivity(mintent);
                    break;
                case 8:
                    mintent = new Intent(getApplicationContext(), fourTypeActivity.class);
                    startActivity(mintent);
                    break;
                case 9:
                    mintent = new Intent(getApplicationContext(), allTypeActivity.class);
                    startActivity(mintent);
                    break;
                }
            }
        });
    }
}
