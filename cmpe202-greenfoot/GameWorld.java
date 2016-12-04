import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author Aaron Lam
 * @version 1.0 - updated 11-21-2016
 */
public class GameWorld extends World
{
    public int size = 300;
    private Card selectedCard;
    
    public int getSize() {
        return this.size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    
    public Card getSelectedCard() {
        return selectedCard;
    }
    public void setSelectedCard(Card card) {
        selectedCard = card;
    }
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1);
        
        addObject(new Timer(), 520, 20);
        
        Random rand = new Random();
        int i= 0, j=0;
        for (i = 40; i < size - 52; i += 52) {
            for (j = 80; j < size - 52; j += 52) {
                addObject (new Card(), i, j);
            }
            addObject (new BlankCard(), i, j);
        }
        
        for (j = 80; j < size; j+= 52) {
            addObject (new BlankCard(), i, j);
        }
        j += 10;
        addObject(new StartButton(), (size-20)/2, j);
        j += 50;
        addObject(new SubmitButton(), (size-20)/2, j);
        j += 50;
        addObject(new NextLevelButton(), (size-20)/2, j);
    }
    
    public GameWorld(int size)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1);
        this.size = size;
        
        addObject(new Timer(), 520, 20);
        
        Random rand = new Random();
        int i= 0, j=0;
        for (i = 40; i < size - 52; i += 52) {
            for (j = 80; j < size - 52; j += 52) {
                addObject (new Card(), i, j);
            }
            addObject (new BlankCard(), i, j);
        }
        
        for (j = 80; j < size; j+= 52) {
            addObject (new BlankCard(), i, j);
        }
        j += 10;
        addObject(ButtonFactory.getButton("Start"), (size-20)/2, j);
        j += 50;
        addObject(ButtonFactory.getButton("Submit"), (size-20)/2, j);
        j += 50;
        addObject(ButtonFactory.getButton("Next"), (size-20)/2, j);
    }
}
