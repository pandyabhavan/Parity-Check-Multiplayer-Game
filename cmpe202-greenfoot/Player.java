import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 *     Player is an observer
 *     Player will observe all the action happen on the GameWorld
 *         and call or act accordingly
 * 
 * @author Aaron Lam
 * @version 1.0 - updated 11-21-2016
 */
public class Player extends Actor
{
    private String username;
    private int score;
    private int time;
    private int level;
    
    private boolean login = false;
    
    public String getUsername () {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
