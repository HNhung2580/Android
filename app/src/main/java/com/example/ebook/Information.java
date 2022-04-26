package com.example.ebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Information extends AppCompatActivity {
    TextView txtInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        txtInfo = findViewById(R.id.textviewInfo);
        String info = "This application was created by Vũ Thị Hồng Nhung and Lương Thị Thùy Giang\n"+"Application information: Story store application for children\n" +
                "This is a good app to educate and entertain children";
        txtInfo.setText(info);
    }
}