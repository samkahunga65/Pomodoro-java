package org.example;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Gui extends JFrame {
    JButton startButton;
    JLabel timerLabel;
    String timerString;
    Boolean inPomodoro;
    ExecutorService executor;
    Boolean timerRunning;
    Boolean timerInContinua;
    CountdownTimer timer;
    Gui () {
        setSize(460,360);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Pomodoro");
        startButton = new JButton("Start");
        startButton.setBounds(180,90,100,33);
        timerLabel = new JLabel();
        timerLabel.setBounds(180, 33, 100, 30);
        timerLabel.setText("00:00");
        add(timerLabel);
        add(startButton);
        inPomodoro = false;
        timerRunning = false;
        timerInContinua = false;
        timer = null;
        executor = Executors.newFixedThreadPool(10);
        startButton.addActionListener(actionEvent -> {
            executor.submit(()->{
                startButtonClicked();
            });
        });
    }

    private void startButtonClicked() {
        if (timerRunning) {
            timerRunning = false;
            timer.pauseCountDownTimer();
            toggleStartButton();
            return;
        }
        timerRunning = true;
        if (timerInContinua) {
            timer.resumeTimer();
            toggleStartButton();
            return;
        }
        timerInContinua = true;
        toggleStartButton();
        timer = CountdownTimer.startCountDown(timerLabel);
    }
    private void toggleStartButton() {
        if (!timerRunning) {
            if (timerInContinua){
                startButton.setText("continue");
            }
            return;
        };
        startButton.setText("pause");
    }

}
