import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;

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

    public void changeColor(Color color) {
        image.setColor(color);
        image.fill();
        setImage(image);
    }

    public void shuffle () {
        image.setColor(java.awt.Color.WHITE);
        image.fill();
        setImage(image);
    }

    public void unShuffle() {
        if (isFlip) {
            if (color == "RED") {
                image.setColor(java.awt.Color.BLUE);
                color = "BLUE";
            } else {
                image.setColor(java.awt.Color.RED);
                color = "RED";
            }
        } else {
            if (color == "RED") {
                image.setColor(java.awt.Color.RED);
            } else {
                image.setColor(java.awt.Color.BLUE);
            }
        }
        image.fill();
        image.setTransparency(255);
        setImage(image);
    }

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
            select();
        }
    }   

    public void select() {
        Observer observer = Observer.getInstance();
        observer.cardSelected(this);
        Color color = image.getColor();
        image.setColor(java.awt.Color.BLACK);
        image.fill();

        image.setTransparency(200);

        image.setColor(color);
        image.fillRect(3, 3, size-6, size-6);
        setImage(image);

        this.selected = true;
    }
}
