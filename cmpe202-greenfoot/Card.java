import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Card here.
 * 
 * @author Aaron Lam
 * @version 1.0 - updated 11-21-2016
 */
public class Card extends Actor
{
    public int size = 50;
    private String color;
    private boolean isFlip = false;
    private boolean selected = false;
    private GreenfootImage image = new  GreenfootImage(size, size);

    public Card () {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            image.setColor(java.awt.Color.RED);
            color = "RED";
        } else {
            image.setColor(java.awt.Color.BLUE);
            color = "BLUE";
        }
        image.fill();
        setImage(image);
    }

    public void flip() {
        isFlip = true;
        if (color == "RED") {
            image.setColor(java.awt.Color.BLUE);
            color = "BLUE";
        } else {
            image.setColor(java.awt.Color.RED);
            color = "RED";
        }
        image.fill();
        setImage(image);
    }

    public boolean isFlip() {
        return isFlip;
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    public boolean isSelected() {
        return selected;
    }

    /**
     * Act - do whatever the BlackCard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            List<Card> cardList = this.getWorld().getObjects(Card.class);
            for(Card card : cardList) {
                card.setSelected(false);
            }
            this.selected = true;
        }
    }   
}
