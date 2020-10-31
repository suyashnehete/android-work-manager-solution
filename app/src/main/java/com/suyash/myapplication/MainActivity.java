package com.suyash.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static Button btn;
    static Handler handler = new Handler(Looper.getMainLooper());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
    }

    public void onClick(View v){
        OneTimeWorkRequest worker = new OneTimeWorkRequest.Builder(WorkManagerClass.class).build();
        WorkManager.getInstance().enqueue(worker);
    }

    public static void showToast(final String str, final Context context){
        handler.post(new Runnable() {
            @Override
            public void run() {
                btn.setText("Its Working");
                Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}