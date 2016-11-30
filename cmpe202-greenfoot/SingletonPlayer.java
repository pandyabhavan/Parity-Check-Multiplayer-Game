import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SingletonPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SingletonPlayer extends Actor
{
    private static SingletonPlayer instance;
    
    private SingletonPlayer() {        
    }
    
    public static SingletonPlayer getInstance() {
        if (instance == null) {
            instance = new SingletonPlayer();
        }
        return instance;
    }
    
    /**
     * Act - do whatever the SingletonPlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
