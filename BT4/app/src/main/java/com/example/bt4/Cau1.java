package com.example.bt4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.bt4.R;

public class Cau1 extends AppCompatActivity {

    private ImageView im;
    private Button btnPopupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Context Menu Setup
        im = findViewById(R.id.imageView);
        registerForContextMenu(im); // Đăng ký Context Menu cho ImageView

        // 2. Popup Menu Setup
        btnPopupMenu = findViewById(R.id.btn);

        // Bắt sự kiện click cho Button
        btnPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khởi tạo PopupMenu
                PopupMenu popupMenu = new PopupMenu(Cau1.this, btnPopupMenu);

                // Đẩy layout menu vào ứng dụng
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu()); // Giả định tên file là popup_menu.xml

                // Xử lý sự kiện click item của menu
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(Cau1.this, "Bạn vừa chọn popup menu: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        // Trả về false nếu muốn tiếp tục xử lý
                        return true;
                    }
                });

                // Hiển thị PopupMenu
                popupMenu.show();
            }
        });
    }

    // --- Xử lý Options Menu (Menu 3 chấm) ---

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Ánh xạ option_menu.xml vào Activity
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Xử lý sự kiện khi chọn Options Menu Item
        Toast.makeText(this, "Bạn chọn Options Menu: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }

    // --- Xử lý Context Menu (Nhấn giữ trên ImageView) ---

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.imageView) {
            // Ánh xạ context_menu.xml vào Context Menu
            getMenuInflater().inflate(R.menu.context_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        // Xử lý sự kiện khi chọn Context Menu Item
        Toast.makeText(this, "Bạn chọn Context Menu: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
}