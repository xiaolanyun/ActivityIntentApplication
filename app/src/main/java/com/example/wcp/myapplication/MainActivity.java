package com.example.wcp.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //设置用户名，添加控件
    private TextView text_username = null;
    private Button button_add = null;
    private TextView text_password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_username=(EditText) findViewById(R.id.EditText_username);
        button_add=(Button) findViewById(R.id.button_add);
        text_password=(EditText) findViewById(R.id.EditText_password);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = text_username.getText().toString();
                if(text_username.getText().toString().equals("")||text_password.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"用户名密码输入不能为空",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    //传递参数，键值对
                    intent.putExtra("name", str);
                    startActivity(intent);
                }
            }
        });
    }
}
