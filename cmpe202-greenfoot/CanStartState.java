/**
 * Write a description of class InitState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CanStartState extends State 
{
    GameState gameState;

    public CanStartState (GameState gameState) {
        this.gameState = gameState;
    }
    
    public void moveToNextState() {
        gameState.setState(gameState.getCanSubmitState());
    }
    
    public boolean canStart() {
        //startButton --> act
        return true;
    }
    
    public boolean canSubmit() {
        //do nothing
        return false;
    }
    
    public boolean canNext() {
        //do nothing
        return false;
    }
}
