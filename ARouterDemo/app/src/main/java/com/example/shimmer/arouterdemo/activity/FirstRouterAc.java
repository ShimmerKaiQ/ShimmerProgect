package com.example.shimmer.arouterdemo.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.shimmer.arouterdemo.R;

/**
 * 类名称：FirstRouterAc
 * 类说明：路由跳转第一页
 * 创建人：Shimmer
 * 创建时间：2017/12/1 下午3:16
 */
@Route(path = "/demoapp/firstRouterAc")
public class FirstRouterAc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_content);
        initView();
    }

    private void initView(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("第一页");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                finish();
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "你点击了第一页的FloatingActionButton按钮", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
