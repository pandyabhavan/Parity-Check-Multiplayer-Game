import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Command here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Command 
{
    public int nextLevel (GameWorld world) {
        int size = world.size;
        if (size == 600) {
            return -1;
        } else {
            return size + 100;
        }
    }

    public void startTimer(GameWorld world) {
        List <Timer> timer = world.getObjects(Timer.class);
        timer.get(0).setRunning(true);
        timer = null;
    }

    public void stopTimer(GameWorld world) {
        List <Timer> timer = world.getObjects(Timer.class);
        timer.get(0).setRunning(false);
        timer = null;

    }

    public void flipRandomCard(GameWorld world) {
        List<Card> cardList = world.getObjects(Card.class);
        
        for(Card card : cardList) {
            card.shuffle();
        }
        Random rand = new Random();
        int index = rand.nextInt(cardList.size());
        cardList.get(index).flip();

        Greenfoot.delay(50);

        for(Card card : cardList) {
            card.unShuffle();
        }
    }
}
