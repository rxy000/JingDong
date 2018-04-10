package com.bw.com.jingdongdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private int i=3;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                i--;
                if(i==0){
                    handler.sendEmptyMessageDelayed(0,3000);
                }else{
                    Intent intent=new Intent(MainActivity.this,JingDongActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = getSharedPreferences("f", MODE_PRIVATE);
        boolean flag = sp.getBoolean("flag", false);
        if(flag){
            Intent intent=new Intent(MainActivity.this,JingDongActivity.class);
            startActivity(intent);
            finish();
        }else{
            handler.sendEmptyMessageDelayed(0,3000);
            SharedPreferences.Editor edit = sp.edit();
            edit.putBoolean("flag",true);
            edit.commit();
        }
    }
}
