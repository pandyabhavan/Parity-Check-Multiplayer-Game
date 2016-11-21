import greenfoot.*; 
import java.util.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayBoardWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayBoardWorld extends World
{
    private int bitX;
    private int bitY;
    /**
     * Constructor for objects of class PlayBoardWorld.
     * 
     */
    public PlayBoardWorld(List bitList , int randNum)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
       super(800, 600, 1);
       LevelOne levelOne = new LevelOne();
       addObject(levelOne, 400,300);
        System.out.println("Aaya kya");
       if (Greenfoot.mousePressed(bitList.get(randNum)))
       {
           System.out.println("Oye mil gaya");
        }
    }
    
    public void setBitX(int x)
    {
        bitX = x;
        System.out.println("Oye mil gaya "+x);
    }
    
    public void setBitY(int y)
    {
        bitY = y;
        System.out.println("Oye mil gaya "+y);
    }
    
    public int getBitX()
    {
        return bitX;
    }
    
    public int getBitY()
    {
        return bitY;
    }
}
