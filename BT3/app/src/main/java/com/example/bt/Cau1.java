package com.example.bt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bt.R;

public class Cau1 extends AppCompatActivity {

    private View.OnClickListener corkyListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // do something when the button is clicked
            Toast.makeText(Cau1.this, "Sự kiện click Button", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cau1);
         Button button = (Button)findViewById(R.id.btn);

         button.setOnClickListener(corkyListener);
    }
}