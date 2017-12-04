package com.example.shimmer.arouterdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.shimmer.arouterdemo.R;

/**
 * 类名称：ThirdRouterAc
 * 类说明：路由跳转第三页
 * 创建人：Shimmer
 * 创建时间：2017/12/1 下午3:28
 */
@Route(path = "/demoapp/thirdRouterAc")
public class ThirdRouterAc extends AppCompatActivity {

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
        toolbar.setTitle("第三页");
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
                Snackbar.make(view, "你点击了第三页的FloatingActionButton按钮", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
