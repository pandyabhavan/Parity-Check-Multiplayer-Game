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
    
    private static int level;
    private static int score;
    private static String name;
    
    public int getLevel() {
        return this.level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }   
    
    public int getScore() {
        return this.score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void addScore(int score) {
        this.score += score;
    }
    
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
