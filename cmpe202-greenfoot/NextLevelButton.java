import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class NextButton here.
 *     NextLevelButton will move Player to the next level
 *     
 * @author Aaron Lam
 * @version 1.0 - updated 11-21-2016
 */
public class NextLevelButton extends Button
{
    String buttonText = "Next Level";
    boolean clicked;

    public NextLevelButton ()
    {
        super("Next Level");
    }
    

    /**
     * Act - do whatever the NextButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        GameState gameState = GameState.getInstance();
        if(Greenfoot.mouseClicked(this) && gameState.canNext()) 
        {
            gameState.moveToNextState();
            int size = ((GameWorld) this.getWorld()).size;
            if (size >= 600) {
                gameState.setState(new EndedState (gameState));
                End gameWorld = new End();
                Greenfoot.setWorld(gameWorld);
            } else {
                GameWorld gameWorld = new GameWorld(size + 100);
                Greenfoot.setWorld(gameWorld); 
            }
        }
    }

    public boolean gotClicked()
    {
        boolean wasClicked=clicked;
        clicked = false;
        return wasClicked;
    }

    public String getText()
    {
        return buttonText;
    }
}
