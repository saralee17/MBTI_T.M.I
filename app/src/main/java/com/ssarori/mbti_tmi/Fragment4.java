package com.ssarori.mbti_tmi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Fragment4 extends Fragment {

    String result[];
    public Fragment4() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_4, container, false);
        ImageView ivBack = (ImageView) view.findViewById(R.id.ivBack);
        TextView tvResult = (TextView) view.findViewById(R.id.tvResult);
        ivBack.setImageResource(R.drawable.sp);

        InputStream inputS = getResources().openRawResource(R.raw.sp_raw);
        byte txt[] = new byte[0];
        try {
            txt = new byte[inputS.available()];
            inputS.read(txt);
            String str = new String(txt);
            result = str.split("#");
            ivBack.setImageResource(R.drawable.sp);
            tvResult.setText(result[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = new String(txt);
        return view;
    }
}
