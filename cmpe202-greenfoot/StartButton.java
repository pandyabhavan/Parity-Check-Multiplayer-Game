import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.*;

/**
 * Write a description of class StartButton here.
 *     When the player is ready to start the game
 *     He/She will press the Start Button to start playing.
 * 
 * @author Aaron Lam
 * @version 1.0 - updated 11-21-2016
 */
public class StartButton extends Button
{
    String buttonText = "Start";
    boolean clicked = false;

    public StartButton ()
    {
        super("Start");
    }

    /**
     * Act - do whatever the NextButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        GameState gameState = GameState.getInstance();
        if(Greenfoot.mouseClicked(this) && gameState.canStart()) 
        {
            gameState.moveToNextState();
            Random rand = new Random();
            List <Timer> timer = this.getWorld().getObjects(Timer.class);
            timer.get(0).setRunning(true);
            timer = null;

            List<Card> cardList = this.getWorld().getObjects(Card.class);
            for(Card card : cardList) {
                card.shuffle();
            }
            
            int index = rand.nextInt(cardList.size());
            cardList.get(index).flip();
            
            Greenfoot.delay(50);
            
            for(Card card : cardList) {
                card.unShuffle();
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
