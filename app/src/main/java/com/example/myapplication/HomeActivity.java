package com.example.myapplication;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import com.example.myapplication.R;


public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // 设置主页显示欢迎消息
        TextView textView = new TextView(this);
        textView.setText("Welcome to the Home Page!");
        textView.setTextSize(24);
        setContentView(textView);
    }
}
