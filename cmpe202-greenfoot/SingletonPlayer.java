import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SingletonPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SingletonPlayer
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
    
    public void submitted (boolean correct, int time) {
        if (correct) {
            System.out.println("CORRECT");
        } else {
            System.out.println("!CORRECT");
        }
    }
}
