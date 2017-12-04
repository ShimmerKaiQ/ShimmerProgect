package com.example.shimmer.arouterdemo.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.shimmer.arouterdemo.R;

/**
 * 类名称：StartFirstAc
 * 类说明：启动的第一个界面
 * 创建人：Shimmer
 * 创建时间：2017/12/1 下午1:59
 */
public class StartMainAc extends AppCompatActivity {

    private Toolbar toolbar;
    private Button btn_start_activity;

    /** 路由跳转 */
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_start_first);
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
//        if(isDebug()) { // 如果是要打包发布应用，一定要关闭路由的日志打印
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//        }
        ARouter.init(getApplication()); // 尽可能早，推荐在Application中初始化
        initView();
    }

    private void initView(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        btn_start_activity = findViewById(R.id.btn_start_activity);
        btn_start_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uri = Uri.parse("demorouterapp://shimmer.demo.arouter/demoapp/thirdRouterAc");
                ARouter.getInstance().build(uri).navigation(StartMainAc.this, new NavCallback() {

                    @Override
                    public void onArrival(Postcard postcard) {
                        Log.e("arouterDemo", "app进行原生路由跳转成功！path = " + postcard.getPath());
                    }
                });
            }
        });

        uri = getIntent().getData();
        if(uri != null){
            ARouter.getInstance().build(uri).navigation(this, new NavCallback() {

                @Override
                public void onArrival(Postcard postcard) {
                    Log.e("arouterDemo", "外部浏览器启动app进行路由跳转成功！path = " + postcard.getPath());
                }
            });
        }

    }
}
