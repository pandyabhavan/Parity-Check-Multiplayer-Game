import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class ButtonFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonFactory
{
    private static HashMap<String, Button> buttonsMap = new HashMap<>();
    
    public static Button getButton (String buttonText) {
        if (buttonsMap.containsKey(buttonText)) {
            return buttonsMap.get(buttonText);
        } else {
            Button button = buildButton (buttonText);
            buttonsMap.put(buttonText, button);
            return button;
        }
    }
    
    public static Button buildButton (String buttonText) {
        switch (buttonText) {
            case "StartG": return new StartGameButton ();
            case "Start" : return new StartButton();
            case "Submit": return new SubmitButton();
            case "Next"  : return new NextLevelButton ();
        }
        return null;
    }
}
