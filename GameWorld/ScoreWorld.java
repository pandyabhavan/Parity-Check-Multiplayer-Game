import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreWorld extends World
{

    /**
     * Constructor for objects of class ScoreWorld.
     * 
     */
    public ScoreWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        GreenfootImage img = getBackground();
        img.scale(800,600);
        
    }
}
