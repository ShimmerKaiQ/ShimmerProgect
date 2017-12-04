package com.example.shimmer.arouterdemo.impl;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 类名称：PathReplaceServiceImpl
 * 类说明：重写路由跳转
 * 创建人：Shimmer
 * 创建时间：2017/12/1 下午2:59
 */
@Route(path = "/return/changePath") // 必须标明注解,可以随便命名
public class PathReplaceServiceImpl implements PathReplaceService {

    @Override
    public void init(Context context) {

    }

    @Override
    public String forString(String path) {
        return path;
    }

    @Override
    public Uri forUri(Uri uri) {
        return changeUri(uri);
    }

    /**
     * 方法名：
     * 描述：拦截跳转路径进行指定向修改
     * 创建人：Shimmer
     * 创建时间：2017/12/1  下午3:36
     */
    private Uri changeUri(Uri uri) {
        PathReplaceService pService = ARouter.getInstance().navigation(PathReplaceService.class);
        if (null != pService) {
            if ("/demoapp/FourRouterAc".equals(uri.getPath())) { // 跳转进入首页-逻计服务
                uri = pService.forUri(Uri.parse("demorouterapp://shimmer.demo.arouter/demoapp/secondRouterAc"));
                Log.e("arouterDemo","重写跳转方法修改path="+ uri.getPath() +"=====>跳转进入SecondRouterAc");
            }
        }
        return uri;
    }

}
