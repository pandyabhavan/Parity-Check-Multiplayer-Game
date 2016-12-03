import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3Button extends Button
{
    public Level3Button(){
        super("Level 3");
    }
    
    /**
     * Act - do whatever the Level1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            GameWorld gameWorld = new GameWorld(500);
            Greenfoot.setWorld(gameWorld);
        }
    }    
}