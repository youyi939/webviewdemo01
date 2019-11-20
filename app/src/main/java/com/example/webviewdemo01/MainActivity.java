package com.example.webviewdemo01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.webView);
        nav=findViewById(R.id.nav);


        WebSettings settings=webView.getSettings();
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setJavaScriptEnabled(true);
        //html,css,Javascript
        webView.loadUrl("http://johnyu.cn/my.html");
        webView.addJavascriptInterface(new MyService(this),"myService");

        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        webView.loadUrl("http://johnyu.cn/my.html");
                        break;
                    case  R.id.navigation_dashboard :
                        webView.loadUrl("https://www.baidu.com");
                        break;
                }
                return  true;
            }
        });


    }


    public void call(View view) {

        webView.evaluateJavascript("javascript:fun1('JohnYu')", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_nav_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_home:
                webView.loadUrl("http://johnyu.cn/my.html");
                break;
            case  R.id.navigation_dashboard :
                webView.loadUrl("https://www.baidu.com");
                break;
        }

        return true;
    }
}
