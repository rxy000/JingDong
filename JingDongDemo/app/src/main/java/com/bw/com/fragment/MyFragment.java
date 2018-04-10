package com.bw.com.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bw.com.jingdongdemo.LoginActivity;
import com.bw.com.jingdongdemo.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by ruixuyao on 2018/04/09.
 */

public class MyFragment extends Fragment{
    private SimpleDraweeView sdv;
    private TextView text_login;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_layout, null);
        sdv = view.findViewById(R.id.sdv);
        text_login = view.findViewById(R.id.text_login);
        Uri eri=Uri.parse("http://img2.imgtn.bdimg.com/it/u=3514174167,3487103301&fm=27&gp=0.jpg");
        sdv.setImageURI(eri);
        sdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(intent);
            }
        });
        text_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }
}
