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
            case "Start" : return new StartButton();
            case "Next"  : return new NextLevelButton ();
            case "Submit": return new SubmitButton();
            case "Replay": return new ReplayButton();
            case "Level1": return new Level1Button();
            case "Level2": return new Level2Button();
            case "Level3": return new Level3Button();
        }
        return null;
    }
}
