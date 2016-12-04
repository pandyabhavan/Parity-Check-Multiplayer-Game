import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class StartGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGameButton extends Button
{
    String buttonText = "Start Game";

    public StartGameButton ()
    {
        super("Start Game");
    }

    /**
     * Act - do whatever the NextButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        if(Greenfoot.mouseClicked(this)) 
        {
            GameWorld gameWorld = new GameWorld();
            Greenfoot.setWorld(gameWorld);
            
            List<TextField> textFields = this.getWorld().getObjects(TextField.class);
            TextField textField = textFields.get(0);
            String name = textField.getText();
            
            SingletonPlayer player = SingletonPlayer.getInstance();
            player.setName(name);
            player.setScore(0);
            GameState gameState = GameState.getInstance();
            gameState.setState(gameState.getCanStartState());
        }
    }
}
