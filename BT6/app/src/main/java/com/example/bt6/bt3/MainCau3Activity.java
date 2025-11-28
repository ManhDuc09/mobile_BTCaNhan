package com.example.bt6.bt3;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;


import com.example.bt6.R;

public class MainCau3Activity extends AppCompatActivity implements View.OnClickListener {


    public static class Key {
        public static final String ACTION_PLUS_NUMBER = "com.example.action_add_number";
        public static final String NUMBER_A = "nuber_a"; // Nên sửa thành "number_a"
        public static final String NUMBER_B = "nuber_b"; // Nên sửa thành "number_b"
    }

    private EditText edtA, edtB;
    private Button btn;
    private CalculatorReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cau3); // Đảm bảo bạn đã có file activity_main.xml

        // Khởi tạo giao diện
        edtA = (EditText) findViewById(R.id.edit_text1); // Thay R.id.edit_text_1 bằng ID thực tế của bạn
        edtB = (EditText) findViewById(R.id.edit_text2); // Thay R.id.edit_text_2 bằng ID thực tế của bạn
        btn = (Button) findViewById(R.id.btn); // Thay R.id.btn_plus bằng ID thực tế của bạn
        btn.setOnClickListener(this);


        receiver = new CalculatorReceiver();

        IntentFilter filter = new IntentFilter();
        filter.addAction(Key.ACTION_PLUS_NUMBER);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // API 33+
            // Sử dụng cờ bảo mật cho Android 13 trở lên
            registerReceiver(receiver, filter, Context.RECEIVER_NOT_EXPORTED);
        } else {
            // Cách cũ cho các phiên bản Android cũ hơn
            registerReceiver(receiver, filter);
        }
    }
    @Override
    protected void onDestroy() {
        // Hủy đăng ký Receiver
        unregisterReceiver(receiver);
        super.onDestroy();
    }
    @Override
    public void onClick(View v) {
        // LOG 1: Bắt đầu xử lý sự kiện nhấn nút
        Log.d("DEBUG_APP", "1. Nút Plus đã được nhấn.");

        if (v.getId() == R.id.btn) {
            try {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());

                Log.d("DEBUG_APP", "2. Dữ liệu hợp lệ: A=" + a + ", B=" + b);

                // ... Tạo Intent và setPackage(getPackageName()) ...
                Intent intent = new Intent();
                intent.setAction(Key.ACTION_PLUS_NUMBER);
                intent.setPackage(getPackageName()); // Rất quan trọng!

                intent.putExtra(Key.NUMBER_A, a);
                intent.putExtra(Key.NUMBER_B, b);

                sendBroadcast(intent);
                Log.d("DEBUG_APP", "3. Đã gửi Broadcast thành công.");

            } catch (NumberFormatException e) {
                // LOG 4: Bắt lỗi nhập liệu
                Log.e("DEBUG_APP", "4. Lỗi: Số không hợp lệ hoặc ô trống.");
                Toast.makeText(this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }

    }
}