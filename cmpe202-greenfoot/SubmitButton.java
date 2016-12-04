import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.*;

/**
 * Write a description of class SubmitButton here.
 *     SubmitButton will submit the result to the current game to server
 * @author Aaron Lam
 * @version 1.0 - updated 11-21-2016
 */
public class SubmitButton extends Button
{
    String buttonText = "Submit";
    boolean clicked;

    public SubmitButton ()
    {
        super("Submit");
    }

    /**
     * Act - do whatever the NextButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        GameState gameState = GameState.getInstance();
        if(Greenfoot.mouseClicked(this) && gameState.canSubmit()) 
        {
            gameState.moveToNextState();
            clicked = true;
            boolean correct = false;
            List<Card> cardList = this.getWorld().getObjects(Card.class);
            
            for(Card card : cardList) {
                if (card.isFlip() && card.isSelected()) {
                    // correct
                    correct = true;                    
                }
                else if (card.isFlip()) {
                    card.changeColor(java.awt.Color.YELLOW);
                }
            }

            
            List<Timer> timerList = this.getWorld().getObjects(Timer.class);
            
            Timer timer = timerList.get(0);
            
            timer.setRunning(false);
            int timeElapsed = timer.getTime();
            
            SingletonPlayer player = SingletonPlayer.getInstance();
            int size = ((GameWorld) this.getWorld()).size;
            if (correct) {
                int score = (size * size) / (timeElapsed/1000);
                System.out.println(score);
                player.addScore(score);
            }
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
