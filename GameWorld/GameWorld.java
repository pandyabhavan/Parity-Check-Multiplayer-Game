import greenfoot.*; 
import java.util.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{

    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        prepare();
        workingOnit();
    }
    public void prepare()
    {
        LevelOne levelOne = new LevelOne();
        LevelTwo levelTwo = new LevelTwo();
        LevelThree levelThree = new LevelThree();
        Timer timerObject = new Timer (30,true);
        addObject(levelOne, 400,300); 
        addObject(timerObject, 725, 35);   
        
        

    }
    public void workingOnit()
    {
        ArrayList<White> whiteList = new ArrayList<White>();        
        ArrayList<Black> blackList = new ArrayList<Black>(); 
        int randomNumber;  
        White w = new White();
        
        
        
        int gridFive = 5     , gridSeven = 7 ,gridNine = 9;
        int totalLength = 500, noOfGrid, countW = 0, countB=0;
        noOfGrid = totalLength / gridFive;
        
        
        for ( int i = 0 ; i<gridFive ; i++)
        {
            for (int j = 0; j<gridFive; j++)
            {
                
                randomNumber = Greenfoot.getRandomNumber(50);
                if (randomNumber % 3 ==0)
                {
                 whiteList.add(countW, new White());
                 addObject(whiteList.get(countW), (i*noOfGrid)+180, (j*noOfGrid)+80);
                 countW ++;
                 //addObject(w, (i*noOfGrid)+200, (j*noOfGrid)+100);
                }
                else
                {
                 blackList.add(countB,new Black());
                 addObject(blackList.get(countB), (i*noOfGrid)+180, (j*noOfGrid)+80);
                 countB++;
                }
                
                
            }
        }
    }
    
}
