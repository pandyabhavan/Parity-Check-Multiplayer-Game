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
    private static int level = 5;
    private int randomNum = 0;
    private int noOfGrid=1;
    List<Bits> bitsList = new ArrayList<Bits>();
        ArrayList<White> whiteList = new ArrayList<White>();        
        ArrayList<Black> blackList = new ArrayList<Black>();
    
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
       
        String[][] bitsArray = null;
        int randomNumber;  
        White w = new White();
        int c = 5;
        int gridFive = 5     , gridSeven = 7 ,gridNine = 9;
        int totalLength = 500, countW = 0, countB=0, count = 0;
        noOfGrid = totalLength / gridFive;
        
        switch(c){
        case 5:
        bitsArray = new String[5][5];
        case 7:
        bitsArray = new String[7][7];
        case 9:
        bitsArray = new String[9][9];
        }
        
        for ( int i = 0 ; i<gridFive ; i++)
        {
            for (int j = 0; j<gridFive; j++)
            {
                
                randomNumber = Greenfoot.getRandomNumber(50);
                if (randomNumber % 3 ==0)
                {
                 
                 //whiteList.add(countW, new White());
                 //addObject(whiteList.get(countW), (i*noOfGrid)+180, (j*noOfGrid)+80);
                 //countW ++;
                 bitsList.add(count, new White());
                 addObject(bitsList.get(count), (i*noOfGrid)+180, (j*noOfGrid)+80);
                 count++;
                 
                }
                else
                {
                 /*
                 blackList.add(countB,new Black());
                 addObject(blackList.get(countB), (i*noOfGrid)+180, (j*noOfGrid)+80);
                 countB++;*/
                 bitsList.add(count, new Black());
                 addObject(bitsList.get(count), (i*noOfGrid)+180, (j*noOfGrid)+80);
                 count++;
                }
            }
        }
        System.out.println("Printing jst after setting up");
        for (int i = 0; i < bitsList.size(); i++)
        {System.out.println(bitsList.get(i).getClass().getSimpleName() + " At index = " +i);
            
        }
        
    }
    
    public static int getGameLevel()
    {
        return level;
    }
    
    public void setGame()
    {
        randomNum = new PlayBoard().getRandomNum();
        Bits bit;
        bit = bitsList.get(randomNum);
        String bitClass = bit.getClass().getSimpleName();
        System.out.println ( "Random number : " + randomNum + " selected bit = " +bitClass );
        if(bitClass.equalsIgnoreCase("White"))
        {
            bitsList.remove(randomNum);
            bitsList.add(randomNum, new Black());
            System.out.println ( "Changing white to black");
        }
        else
        {
            bitsList.remove(randomNum);
            bitsList.add(randomNum, new White());
            System.out.println ( "Changing black to white");
        }
        System.out.println("Printing jst before changing the world setting up");
        for (int i = 0; i < bitsList.size(); i++)
        {System.out.println(bitsList.get(i).getClass().getSimpleName() + " At index = " +i);
            
        }
        PlayBoard pb = new PlayBoard(bitsList, 5, randomNum, noOfGrid);
      
    }
    
    public void showGrid(List<Bits> bitsList, int level, int gridNo)
    {
        int gridCnt=1;
        
        for ( int i = 0 ; i<level ; i++)
        {
            for (int j = 0; j<level; j++)
            {
                 //addObject(thisList.get(1), (i*gridNo)+180, (j*gridNo)+80);
                 gridCnt++;
                
            }
        }
    }
    
}
