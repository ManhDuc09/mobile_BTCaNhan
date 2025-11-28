package com.example.bt6.bt2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View; // Nên thêm View nếu dùng setOnClickListener

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bt6.R;
// import com.example.bt6.bt1.MainActivity; // Không cần thiết nếu không dùng

public class MainCau2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main_cau2);

        Button startServiceButton  =  findViewById(R.id.start_service_button);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        if (startServiceButton != null) {
            startServiceButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainCau2Activity.this ,ExampleIntentService.class);
                startService(intent);
            });
        }
    }
}