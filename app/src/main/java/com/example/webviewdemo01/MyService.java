package com.example.webviewdemo01;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;

public class MyService {
    private Context context;

    public MyService(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public String work(String s){
        return "Hello:"+s;
    }
    @JavascriptInterface
    public void jump(){
        Intent intent=new Intent();
        intent.setClass(context,OtherActivity.class);
        context.startActivity(intent);
    }
}
