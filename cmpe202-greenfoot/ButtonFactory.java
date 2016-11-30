import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Button here.
 * 
 * @author Aaron Lam
 * @version 1.0 - updated 11-21-2016
 */
public abstract class ButtonFactory extends Actor
{
    // ButtonFactory
    String buttonText;
    boolean clicked;
    
    public ButtonFactory (String buttonText) {
        GreenfootImage textImg = new GreenfootImage(" "+buttonText+" ", 24, Color.black, new Color(0, 0, 0, 0));
        GreenfootImage image = new GreenfootImage(textImg.getWidth()+8, textImg.getHeight()+8);
        image.setColor(Color.darkGray);
        image.fill();
        image.setColor(Color.lightGray);
        image.fillRect(3, 3, image.getWidth()-6, image.getHeight()-6);
        image.setColor(Color.black);
        image.drawImage(textImg, (image.getWidth()-textImg.getWidth())/2, (image.getHeight()-textImg.getHeight())/2);
        setImage(image);
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
