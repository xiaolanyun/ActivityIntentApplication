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
        Intent intent = getIntent();
        String b = intent.getStringExtra("name");
        user.setText("欢迎用户："+b);

        Button_visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlstr = EditText_browser.getText().toString();
                if(!urlstr.equals("")){
                    Log.d("yyj", "onClick: "+urlstr);
                    Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(urlstr));
                    startActivity(intent);
                }
                else {
                    urlstr = "http://www.baidu.com";
                    Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse(urlstr));
                    startActivity(intent);
                }
            }
        });

    }
}
