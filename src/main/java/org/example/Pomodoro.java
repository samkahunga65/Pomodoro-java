package org.example;


import java.util.Timer;
import java.util.TimerTask;

public class Pomodoro {
    Pomodoro() {
        long startTime = System.currentTimeMillis();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("yy");
            }
        }, 25 * 60 * 1000, 25 * 60 * 1000);
    }
}
