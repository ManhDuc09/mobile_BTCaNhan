package com.example.bt6.bt3;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

// Kế thừa từ BroadcastReceiver
public class CalculatorReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction()) {
            case MainCau3Activity.Key.ACTION_PLUS_NUMBER:
                 int a = intent.getIntExtra(MainCau3Activity.Key.NUMBER_A, 0);
                int b = intent.getIntExtra(MainCau3Activity.Key.NUMBER_B, 0);

                 Toast.makeText(context, "Result: " + (a + b), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}