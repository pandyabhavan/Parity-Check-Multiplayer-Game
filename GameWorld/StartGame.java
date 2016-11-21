import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGame extends World
{

    /**
     * Constructor for objects of class StartGame.
     * 
     */
    button button =new button();
    public StartGame()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.addObject(button, 200,200);
    }
    
}
