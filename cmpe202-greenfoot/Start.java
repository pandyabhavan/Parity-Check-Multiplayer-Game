import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends World
{

    /**
     * Constructor for objects of class Start.
     * 
     */
    public Start()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        int j = 20;
        addObject(ButtonFactory.getButton("Level1"), (600-20)/2, j+=50);
        addObject(ButtonFactory.getButton("Level2"), (600-20)/2, j+=50);
        addObject(ButtonFactory.getButton("Level3"), (600-20)/2, j+=50);
        
    }
}
