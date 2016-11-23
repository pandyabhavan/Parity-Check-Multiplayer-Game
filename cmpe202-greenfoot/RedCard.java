import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WhiteCard here.
 * 
 * @author Aaron Lam
 * @version 1.0 - updated 11-21-2016
 */
public class RedCard extends Card
{
    private int size = super.size;
    private String color = "Red";
    private boolean isFlip = false;
    private boolean selected = false;
    private GreenfootImage image = new  GreenfootImage(size, size);

    public RedCard () 
    {
        image.setColor(java.awt.Color.RED);
        image.fill();
        setImage(image);
    }

    public void flip() 
    {
        color = "Blue";
        isFlip = true;
    }

    public boolean isFlip() 
    {
        return isFlip;
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
        if (color == "Blue") {
            image.setColor(java.awt.Color.BLUE);
            image.fill();
            setImage(image);
        }
    }    
}
