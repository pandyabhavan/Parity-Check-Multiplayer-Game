import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

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
        GreenfootImage textImg=new GreenfootImage(" "+buttonText+" ", 24, Color.black, new Color(0, 0, 0, 0));
        GreenfootImage image=new GreenfootImage(textImg.getWidth()+8, textImg.getHeight()+8);
        image.setColor(Color.darkGray);
        image.fill();
        image.setColor(Color.lightGray);
        image.fillRect(3, 3, image.getWidth()-6, image.getHeight()-6);
        image.setColor(Color.black);
        image.drawImage(textImg, (image.getWidth()-textImg.getWidth())/2, (image.getHeight()-textImg.getHeight())/2);
        setImage(image);
    }

    /**
     * Act - do whatever the NextButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        if(Greenfoot.mouseClicked(this)) 
        {
            String text = "CLICKED";
            buttonText=text;
            GreenfootImage textImg=new GreenfootImage(" "+text+" ", 24, Color.black, new Color(0, 0, 0, 0));
            GreenfootImage image=new GreenfootImage(textImg.getWidth()+8, textImg.getHeight()+8);
            image.setColor(Color.darkGray);
            image.fill();
            image.setColor(Color.lightGray);
            image.fillRect(3, 3, image.getWidth()-6, image.getHeight()-6);
            image.setColor(Color.black);
            image.drawImage(textImg, (image.getWidth()-textImg.getWidth())/2, (image.getHeight()-textImg.getHeight())/2);
            setImage(image);
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
