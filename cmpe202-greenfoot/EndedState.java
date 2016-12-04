/**
 * Write a description of class EndState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndedState extends State 
{
    GameState gameState;

    public EndedState (GameState gameState) {
        this.gameState = gameState;
    }
    
    public void moveToNextState() {
        // cannot move
    }
    
    public boolean canStart() {
        // do nothing
        return false;
    }
    
    public boolean canSubmit() {
        // do nothing
        return false;
    }
    
    public boolean canNext() {
        // do nothing
        return false;
    }
}
