import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameMachine extends Actor
{
    private static String state;
    
    public GameMachine () {
        
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getState() {
        return this.state;
    }
}
