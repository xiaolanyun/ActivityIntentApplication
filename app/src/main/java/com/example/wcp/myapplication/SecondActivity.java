package com.example.wcp.myapplication;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private TextView user;
    private Button Button_visit = null;
    private EditText EditText_browser = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        user = findViewById(R.id.user);
        EditText_browser = findViewById(R.id.EditText_browser);
        Button_visit = findViewById(R.id.Button_visit);
        //获取界面1跳转
        Intent intent = getIntent();
        //接收界面1的传递参数，键值对中的健name
        String b = intent.getStringExtra("name");

        user.setText("欢迎："+b+"使用网址访问");
        user.setTextSize(18);

        Button_visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlstr = EditText_browser.getText().toString();
                if(!urlstr.equals("")&&(urlstr.contains("http://")||urlstr.contains("https://"))){
                    //Log.d("yyj", "onClick: "+urlstr);
                    Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(urlstr));
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"网址输入不能为空或者输入错误",Toast.LENGTH_SHORT).show();
                    //EditText_browser.setText("输入不合法，请重新输入");
//                    urlstr = "http://www.baidu.com";
//                    Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(urlstr));
//                    startActivity(intent);
                }
            }
        });

    }
}
