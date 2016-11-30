import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EventObserver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Observer extends Actor
{
    private static Observer observer;

    private Observer() {

    }

    public static Observer getObserver() {
        if (observer == null) {
            observer = new Observer();
        }
        return observer;
    }

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
}
