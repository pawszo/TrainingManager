package exercise;

import screens.TrainingPanel;

import javax.swing.*;


import java.awt.*;

import static java.lang.Thread.sleep;

public class Timer extends JLabel implements Runnable{

    private static int count = 0;
    private static int count2 = 0;

    /** paused and started prevent multiple thread going on */
    public boolean paused;
    public boolean started;

    private TrainingPanel trainingPanel;

    public Runnable r1;
    public Thread t1;


    public Timer(TrainingPanel trainingPanel) {
        super("0.0", SwingConstants.CENTER);
        setBackground(Color.yellow);
        this.trainingPanel = trainingPanel;
        setFont(new Font("Serif", Font.PLAIN, 140));
        setText("" + count);
    }

    public void start() {
        if(paused == false) {
            started = true;
            init();
        } else {
            t1.resume();
            paused = false;
            started = true;
        }
    }

    public void pause() {
        t1.suspend();
        paused = true;
        started = false;

    }

    public void stop() {
        t1.suspend();
        paused = false;
        started = false;
        count = 0;
        count2 = 0;
        trainingPanel.getTimer().setText(count + "." + count2);
    }

    private void init() {
        r1 = new Timer(trainingPanel);
        t1 = new Thread(r1);
        t1.start();
    }


    private void tick() {
        if(count2 == 9) {
            count += 1;
            count2 = 0;
        } else {
            count2++;
        }

    }

    @Override
    public void run() {
        while(true) {
            System.out.println(count + "." + count2);
            trainingPanel.getTimer().setText(count + "." + count2);
            tick();
            try{
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
