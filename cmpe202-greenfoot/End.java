import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.*;

/**
 * Write a description of class End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End extends World
{

    /**
     * Constructor for objects of class End.
     * 
     */
    public End()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1); 
        
        getBackground().setColor(Color.red);
        getBackground().setFont(new Font("", Font.BOLD, 25));
        String message = "Your Score: " + SingletonPlayer.getInstance().getScore();
        getBackground().drawString(message, 250, 50);
        
        NetAdaptor netAdaptor = NetAdaptor.getInstance();
        message = "High Score";
        getBackground().drawString(message, 250, 100);
        int i = 100;
        ArrayList<PlayerScore> highScore = netAdaptor.getHighScore();
        for(PlayerScore player : highScore) {
            message = player.getPlayername() + ": " + player.getScore();
            getBackground().drawString(message, 250, i += 50);
        }
    }
}
