package screens;


import exercise.Timer;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

public class TrainingPanel extends JPanel implements ActionListener {

    private Timer timer;
    JButton startTimer, stopTimer, pauseTimer;
    private JPanel buttonPanel;
   // private double count;

    public TrainingPanel(Dimension dim) {
        setSize(dim);
        setOpaque(false);
        setBackground(new Color(74, 255, 233, 177));
        setLayout(new GridLayout(2, 1, 30, 30));
        createTimer();
        buttonPanel = addButtons();
        add(buttonPanel);

    }

    public void createTimer() {
        timer = new Timer(this);
        add(timer);
    }

    private JPanel addButtons() {
        startTimer = new JButton("Start");
        startTimer.addActionListener(this);
        stopTimer = new JButton("Stop");
        stopTimer.addActionListener(this);
        pauseTimer = new JButton("Pause");
        pauseTimer.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.add(startTimer);
        panel.add(pauseTimer);
        panel.add(stopTimer);
        return panel;
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startTimer) { if(timer.started == false) timer.start(); }
        if(e.getSource() == stopTimer) { timer.stop(); }
        if(e.getSource() == pauseTimer) { if(timer.paused == false) timer.pause(); }



    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
