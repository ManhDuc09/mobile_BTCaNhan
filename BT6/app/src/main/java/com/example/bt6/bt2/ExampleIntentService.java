package com.example.bt6.bt2;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.Nullable;
public class ExampleIntentService extends IntentService{
    private static final String TAG = "ExampleIntentService";

    // Constructor
    public ExampleIntentService() {
        // Call superclass constructor with the name of the worker thread
        super("ExampleIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        // Perform a task in the background
        Log.d(TAG, "Task in progress");

        // Simulate a long running task by sleeping the thread for 5 seconds
        try {
            Thread.sleep(5000); // Ngủ 5 giây
        } catch (InterruptedException e) {
            // Print stack trace if an InterruptedException occurs
            e.printStackTrace();
        }

        Log.d(TAG, "Task completed");
    }
}
