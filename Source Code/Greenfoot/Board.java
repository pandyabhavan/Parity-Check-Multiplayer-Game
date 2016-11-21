import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends World
{
    private ArrayList<ArrayList <Card>> cardMatrix;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Board()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        ArrayList<Card> cardList = new ArrayList<>(800/50);
        ArrayList<ArrayList<Card>> cardMatrix = new ArrayList<>(600/50);
        
    }
    
    public void init() {
        
    }
}
