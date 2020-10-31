package com.suyash.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static Handler handler = new Handler(Looper.getMainLooper());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        OneTimeWorkRequest worker = new OneTimeWorkRequest.Builder(WorkManagerClass.class).build();
        WorkManager.getInstance().enqueue(worker);
    }

    public static void showToast(final String str, final Context context){
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}