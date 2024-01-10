package org.example;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
    public void setCentiSecondsCount(int centiSecondsCount) {
        this.centiSecondsCount = centiSecondsCount;
    }

    int centiSecondsCount;

    public void setCdTimer(Timer cdTimer) {
        this.cdTimer = cdTimer;
    }

    Timer cdTimer;
    JLabel element;
    Boolean paused;
    public CountdownTimer() {
        centiSecondsCount = 15000;
        paused = false;
        cdTimer = null;
        element = null;
    }

    public CountdownTimer pauseCountDownTimer() {
        System.out.println("paaused");
        if(cdTimer != null) cdTimer.cancel();
        return this;
    }
    public CountdownTimer resumeTimer () {
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                element.setText(clockFormatConverter(centiSecondsCount));
                int x = centiSecondsCount;
                setCentiSecondsCount(x-1);
            }
        };
        Timer t = new Timer();
        t.schedule(tt, 0, 100L);
        cdTimer = t;
        return this;
    }
    public static CountdownTimer startCountDown(JLabel element) {
        CountdownTimer countdownTimer = new CountdownTimer();
        countdownTimer.element = element;
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                element.setText(clockFormatConverter(countdownTimer.centiSecondsCount));
                int x = countdownTimer.centiSecondsCount;
                countdownTimer.setCentiSecondsCount(x-1);
            }
        };
        Timer t = new Timer();
        t.schedule(tt, 0, 100L);
        countdownTimer.setCdTimer(t);
        return countdownTimer;
    }

    private static String clockFormatConverter(int centiSecCount) {
        int mins, mill;
        mins = centiSecCount/10/60;
        mill = (centiSecCount/10)%60;
        if(mins < 10) mins = Integer.parseInt("0".concat(String.valueOf(mins)));
        if(mill < 10) mill = Integer.parseInt("0".concat(String.valueOf(mill)));
        return "".concat(String.valueOf(mins)).concat(":").concat(String.valueOf(mill));
    }
}
