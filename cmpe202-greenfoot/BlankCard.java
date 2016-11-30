import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlankCard here.
 * 
 * @author Aaron Lam
 * @version 1.0 - updated 11-21-2016
 */
public class BlankCard extends Actor
{
    private int size = 50;
    private String color = "";
    private boolean isFlip = false;
    private GreenfootImage image = new  GreenfootImage(size, size);

    public BlankCard () 
    {
        image.setColor(java.awt.Color.BLACK);
        image.drawRect(0, 0, size-1, size-1);
        setImage(image);
    }

    /**
     * Act - do whatever the BlackCard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {        
        if (Greenfoot.mouseClicked(this))
        {
            if(this.color == "") {
                image.setColor(java.awt.Color.RED);
                this.color = "Red";
            } else if (this.color == "Red") {
                image.setColor(java.awt.Color.BLUE);
                this.color = "Blue";
            } else {
                image.setColor(java.awt.Color.RED);
                this.color = "Red";
            }
            image.fill();
            setImage(image);
        }

    }   
}
