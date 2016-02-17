package com.geo.networkcommunication;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button btnGet;
    private WebView wView;
    public static final int SHOW_DATA = 0X123;
    private String detail = "";

    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            if (message.what == SHOW_DATA){
                wView.loadDataWithBaseURL("",detail, "text/html","UTF-8","");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setView();
    }

    private void initView(){
        btnGet = (Button) findViewById(R.id.btnGet);
        wView = (WebView) findViewById(R.id.wView);
    }

    private void setView(){
        btnGet.setOnClickListener(this);
        wView.getSettings().setDomStorageEnabled(true);
    }



    @Override
    public void onClick(View view){
        if (v.getId() == R.id.btnGet) {
            GetByHttpClient();
        }
    }

    private void GetByHttpClient() {
        new Thread()
        {
            public void run()
            {
//                try {
//                    HttpClient httpClient = new DefaultHttpClient();
//                    HttpGet httpGet = new HttpGet("http://www.w3cschool.cc/python/python-tutorial.html");
//                    HttpResponse httpResponse = httpClient.execute(httpGet);
//                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
//                        HttpEntity entity = httpResponse.getEntity();
//                        detail = EntityUtils.toString(entity, "utf-8");
//                        handler.sendEmptyMessage(SHOW_DATA);
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                GetByHttpClient();
            }
        }.start();
    }
}
