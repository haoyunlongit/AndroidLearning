package com.example.myapplication;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class myFutureTask extends FutureTask {
    public myFutureTask(Callable callable) {
        super(callable);
    }

    public myFutureTask(Runnable runnable, Object result) {
        super(runnable, result);
    }
}
