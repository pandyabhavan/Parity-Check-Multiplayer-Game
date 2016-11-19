import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
       setRandomNum(new GameWorld().getGameLevel());
    }
    
    public void act() 
    {
        
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
