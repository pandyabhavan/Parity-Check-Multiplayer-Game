import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Replay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Replay extends ButtonFactory
{
    String buttonText = "Replay";
    boolean clicked = false;

    public Replay ()
    {
        super("Replay");
    }

    /**
     * Act - do whatever the NextButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        if(Greenfoot.mouseClicked(this) && !clicked) 
        {
            

        }
    }

    public boolean gotClicked()
    {
        boolean wasClicked=clicked;
        clicked=false;
        return wasClicked;
    }

    public String getText()
    {
        return buttonText;
    }    
}
