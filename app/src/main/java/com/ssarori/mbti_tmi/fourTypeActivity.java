package com.ssarori.mbti_tmi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class fourTypeActivity extends AppCompatActivity {
    TabLayout tabs;
    ViewPager viewPager1;
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_type);
        tabs = (TabLayout)findViewById(R.id.tabs);
        viewPager1 = (ViewPager)findViewById(R.id.viewPager1);
        tabs.addTab(tabs.newTab().setText("NF기질"));
        tabs.addTab(tabs.newTab().setText("NT기질"));
        tabs.addTab(tabs.newTab().setText("SJ기질"));
        tabs.addTab(tabs.newTab().setText("SP기질"));

        bar = getSupportActionBar();
        bar.setTitle("4가지 기질 별 특성");

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),4); // 탭의 갯수만큼 뷰페이져를 호출해 어뎁터에 연결시키겠다.
        viewPager1.setAdapter(adapter); //어뎁터를 장착시키다.

        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager1)); //탭을 선택하면 뷰페이져도 같이 움직이겠다.
        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs)); //뷰페이져가 체인지 되면 탭도 체인지 되겠다.
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {
        int numTabs; //Tab 의 갯수를 담는 변수

        public MyPagerAdapter(@NonNull FragmentManager fm, int numTabs) {
            super(fm);
            this.numTabs = numTabs;
        } // 생성자, 프레그먼트를 장착시킴(어뎁터에 의해)

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Fragment1 tab1 = new Fragment1();
                    return tab1;
                case 1:
                    Fragment2 tab2 = new Fragment2();
                    return tab2;
                case 2:
                    Fragment3 tab3 = new Fragment3();
                    return tab3;
                case 3:
                    Fragment4 tab4 = new Fragment4();
                    return tab4;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return numTabs;
        }
    }
}
