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
        System.out.println("reachedHere" + randomNumber );
        PlayBoardWorld playWorld = new PlayBoardWorld(bitsList,randomNumber);
         Greenfoot.setWorld(playWorld);
        for ( int i = 0 ; i<level ; i++)
        {
            for (int j = 0; j<level; j++)
            {
                 int x = (i*noOfGrid)+180;
                 int y = (j*noOfGrid)+80;
                 playWorld.addObject(bitsList.get(ali), x, y);
                 if(ali==randomNumber)
                 {
                     
                     playWorld.setBitX(x);
                     System.out.println("i =" +x);
                     playWorld.setBitY(y);
                     System.out.print(" and j =" +y);
                 }
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
