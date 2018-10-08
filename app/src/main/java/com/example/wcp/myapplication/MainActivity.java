package com.example.wcp.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text_username = null;
    private Button button_add = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_username=(EditText) findViewById(R.id.EditText_username);
        button_add=(Button) findViewById(R.id.button_add);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = text_username.getText().toString();
                Intent intent = new Intent (MainActivity.this,SecondActivity.class);
                intent.putExtra( "name",str);
                startActivity(intent);
            }
        });
    }
}
