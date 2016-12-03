import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1Button extends Button
{
    public Level1Button(){
        super("Level 1");
    }
    
    /**
     * Act - do whatever the Level1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            GameWorld gameWorld = new GameWorld(300);
            Greenfoot.setWorld(gameWorld);
        }
    }    
}
