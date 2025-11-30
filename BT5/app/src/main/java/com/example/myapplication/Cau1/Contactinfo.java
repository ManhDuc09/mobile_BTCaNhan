package com.example.myapplication.Cau1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Contactinfo extends AppCompatActivity {

    TextView txtName, txtEmail, txtProject;
    Button finishBtn;

    // Định nghĩa Listener cho nút Finish
    private View.OnClickListener finishClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Kết thúc Activity hiện tại, quay về Activity trước đó (MainActivity)
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactinfo);

        // Ánh xạ các View
        txtName = findViewById(R.id.name);
        txtEmail = findViewById(R.id.email);
        txtProject = findViewById(R.id.project);
        finishBtn = findViewById(R.id.button_finish);

        // Gán sự kiện cho nút Finish
        finishBtn.setOnClickListener(finishClick);

        // 1. Lấy Intent đã được gửi đến Activity này
        Intent intent = getIntent();

        // 2. Trích xuất Bundle từ Intent
        Bundle bundle = intent.getExtras();

        // Kiểm tra nếu Bundle tồn tại
        if (bundle != null) {
            // 3. Lấy giá trị chuỗi (String) từ Bundle bằng các Key đã dùng
            String name = bundle.getString("nameKey");
            String email = bundle.getString("emailKey");
            String project = bundle.getString("projectKey");

            // 4. Hiển thị dữ liệu lên TextView
            txtName.setText(name);
            txtEmail.setText(email);
            txtProject.setText(project);
        }
    }
}