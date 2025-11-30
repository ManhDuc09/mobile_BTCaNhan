package com.example.myapplication.Cau_23;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnViewWeb = findViewById(R.id.btn_view_web);
        Button btnDial = findViewById(R.id.btn_dial);
        Button btnViewContacts = findViewById(R.id.btn_view_contacts);
        Button btnSendSms = findViewById(R.id.btn_send_sms);
        Button btnGetImage = findViewById(R.id.btn_get_image);
        Button btnViewMap = findViewById(R.id.btn_view_map);
        Button btnMusicPlayer = findViewById(R.id.btn_music_player);

        btnViewWeb.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com.vn"));
            startActivity(intent);
        });


        btnDial.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+84123456789"));
            startActivity(intent);
        });

        btnViewContacts.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
            startActivity(intent);
        });

        btnSendSms.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:5551234"));

            intent.putExtra("sms_body", "Thứ bảy này đi chơi không?");
            startActivity(intent);
        });

        btnGetImage.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivity(intent);
        });

        // 6. Xem Bản đồ (Intent.ACTION_VIEW)
        btnViewMap.setOnClickListener(v -> {
            String url = "http://maps.google.com/maps?" +
                    "saddr=9.938083,-84.054430&daddr=9.926392,-84.055964";

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        // 7. Mở Trình phát nhạc (Explicit Action String)
        btnMusicPlayer.setOnClickListener(v -> {

            Intent intent = new Intent("android.intent.action.MUSIC_PLAYER");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
    }
}
