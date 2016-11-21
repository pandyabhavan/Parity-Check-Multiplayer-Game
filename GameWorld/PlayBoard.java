import greenfoot.*; 
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayBoard extends Board
{   
    private int randomNum;
    /**
     * Act - do whatever the PlayBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public PlayBoard()
    {
       setRandomNum(GameWorld.getGameLevel());
    }
    public PlayBoard(List<Bits> bitsList, int level, int randomNumber, int noOfGrid)
    {
        
        int ali = 0;
        System.out.println("reachedHere" + randomNum );
        PlayBoardWorld playWorld = new PlayBoardWorld(bitsList,randomNum);
         Greenfoot.setWorld(playWorld);
        for ( int i = 0 ; i<level ; i++)
        {
            for (int j = 0; j<level; j++)
            {
                
                 playWorld.addObject(bitsList.get(ali), (i*noOfGrid)+180, (j*noOfGrid)+80);
                 ali++;
           
            }
        }
        
    }
    
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
            System.out.println("Mouse Clicked Play Board");
        }
    }
    
    public void setRandomNum(int level)
    {
        randomNum = Greenfoot.getRandomNumber((level*level)-1);
    }
    
    public int getRandomNum()
    {
        return randomNum;
    }
}
