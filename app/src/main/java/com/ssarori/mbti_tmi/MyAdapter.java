package com.ssarori.mbti_tmi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    List<itemData> data; //리스트를 만드는데 itemdata 의 구조를 가지고 있음.

    public MyAdapter(Context context, List<itemData> data) {
        this.context = context; //this 를 붙이면 필드에 선언된 변수로 인식
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size(); //데이터의 사이즈만큼 리스트뷰의 항목이 만들어진다.
    } // 뿌려질 자료의 갯수

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null) {
            view = layoutInflater.inflate(R.layout.gridview_item,null); //따로만든 레이아웃을 인플레이트 시킴
        } // view 변수에 인플레이트 시킴
        ImageView ivPoster = (ImageView)view.findViewById(R.id.ivMenu);
        TextView tvTitle = (TextView)view.findViewById(R.id.tvTitle);

        itemData itemData = data.get(position); //값에 따른 위치에서 데이터를 가지고 온다.

        ivPoster.setImageResource(itemData.getImgID());
        tvTitle.setText(itemData.getTitle());

        return view;
    }
}
