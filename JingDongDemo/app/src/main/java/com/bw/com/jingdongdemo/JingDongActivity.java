package com.bw.com.jingdongdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextClock;

import com.bw.com.fragment.FindFragment;
import com.bw.com.fragment.HomeFragment;
import com.bw.com.fragment.MyFragment;
import com.bw.com.fragment.ShoppingFragment;
import com.bw.com.fragment.SortFragment;

public class JingDongActivity extends AppCompatActivity {
    private RadioGroup radio_group;
    private FrameLayout frame_layout;
    private RadioButton btn_home,btn_sort,btn_find,btn_shopping,btn_my;
    private void TextColor(RadioButton btn_home, RadioButton btn_sort,RadioButton btn_find,RadioButton btn_shopping,RadioButton btn_my){
        btn_home.setTextColor(Color.BLUE);
        btn_sort.setTextColor(Color.GRAY);
        btn_find.setTextColor(Color.GRAY);
        btn_shopping.setTextColor(Color.GRAY);
        btn_my.setTextColor(Color.GRAY);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jing_dong);
        radio_group = findViewById(R.id.radio_group);
        frame_layout = findViewById(R.id.frame_layout);
        btn_home = findViewById(R.id.btn_home);
        btn_sort = findViewById(R.id.btn_sort);
        btn_find = findViewById(R.id.btn_find);
        btn_shopping = findViewById(R.id.btn_shopping);
        btn_my = findViewById(R.id.btn_my);
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.btn_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new HomeFragment()).commit();
                        TextColor(btn_home,btn_sort,btn_find,btn_shopping,btn_my);
                        break;
                    case R.id.btn_sort:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new SortFragment()).commit();
                        TextColor(btn_sort,btn_find,btn_shopping,btn_my,btn_home);
                        break;
                    case R.id.btn_find:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new FindFragment()).commit();
                        TextColor(btn_find,btn_shopping,btn_my,btn_home,btn_sort);
                        break;
                    case R.id.btn_shopping:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new ShoppingFragment()).commit();
                        TextColor(btn_shopping,btn_my,btn_home,btn_sort,btn_find);
                        break;
                    case R.id.btn_my:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new MyFragment()).commit();
                        TextColor(btn_my,btn_home,btn_sort,btn_find,btn_shopping);
                        break;
                }
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new HomeFragment()).commit();
        btn_home.setChecked(true);
    }
}
