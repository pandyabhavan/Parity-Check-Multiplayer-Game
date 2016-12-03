import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EventObserver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Observer
{
    private static Observer observer;
    private SingletonPlayer theSingletonPlayer;

    private Observer() {
        theSingletonPlayer = SingletonPlayer.getInstance();
    }

    public static Observer getInstance() {
        if (observer == null) {
            observer = new Observer();
        }
        return observer;
    }

    // make sure that player can only select 1 card
    Card currentSelected = null;
    public void cardSelected (Card card) {
        if (currentSelected == null) {
            currentSelected = card;
        } else {
            currentSelected.setSelected(false);
            currentSelected.unShuffle();
            currentSelected = card;
        }
    }  
    
    // notify player object
    public void submitted(boolean correct, int time) {
        theSingletonPlayer.submitted(correct, time);
    }
}
