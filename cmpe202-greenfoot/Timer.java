import greenfoot.*;

/**
 * Write a description of class TimmerActor here.
 *     Count in game time
 *     Adapted for project from http://www.greenfoot.org/scenarios/8157
 * @author: Duta
 * @version: 2013/4/27
 */

public class Timer extends Actor {
    private boolean running = false;
    private int millisElapsed = 0;
    private long lastTime = 0;

    public void setRunning (boolean running)
    {
        this.running = running;
    }

    public int getTime() {
        return millisElapsed;
    }

    public Timer() {
        updateImage();
    }

    public void start() {
        millisElapsed = 0;
        lastTime = 0;
    }

    public void gamePaused() {
        lastTime = 0;
    }

    public void act() {
        if (running) {
            long time = System.currentTimeMillis();
            if(lastTime != 0) {
                long diff = time - lastTime;
                millisElapsed += diff;
            }
            lastTime = time;
            updateImage();
        }
    }

    public void updateImage() {
        // Calculate minutes & seconds elapsed
        int millis = millisElapsed % 1000;
        int secs = (millisElapsed / 1000) % 60;
        int mins = millisElapsed / 60000;
        // Convert these into text
        String millisText = String.format("%03d", millis);
        String secsText = String.format("%02d", secs);
        String minsText = "" + mins;
        String text = minsText + ":" + secsText + "." + millisText;
        // Update the image
        GreenfootImage img = new GreenfootImage(text, 25, null, null);
        setImage(img);
    }
}