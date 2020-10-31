package com.suyash.myapplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class WorkManagerClass extends Worker {
    Context context;
    public WorkManagerClass(@NonNull Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        MainActivity.showToast("I am in Worker Class", context);
        return Result.success();
    }
}
