import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
 
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
        addObject(ButtonFactory.getButton("StartG"), 300, 300);
        addObject(new TextField(), 300, 200);
        getBackground().setColor(Color.red);
        getBackground().setFont(new Font("", Font.BOLD, 25));
        getBackground().drawString("Welcome to the game!", 170, 50);
        getBackground().drawString("Please enter your name and click Start Game!", 10, 100);
        
    }
}
