package com.example.bt6.bt1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bt6.R;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_cau1);

        // Nhận dữ liệu từ Intent
        String message = getIntent().getStringExtra("message");

        // Hiển thị dữ liệu lên TextView
        TextView textView = findViewById(R.id.text_view);
        textView.setText(message);

        // Button để quay lại MainActivity
        Button btnBack = findViewById(R.id.btn_back_to_main);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kết thúc activity hiện tại
            }
        });
    }
}
