/**
 * Write a description of class StartState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CanSubmitState extends State 
{
    GameState gameState;

    public CanSubmitState (GameState gameState) {
        this.gameState = gameState;
    }

    public void moveToNextState() {
        gameState.setState(gameState.getCanNextState());
    }

    public boolean canStart() {
        // do nothing
        return false;
    }

    public boolean canSubmit() {
        // submitButton --> act
        return true;
    }

    public boolean canNext() {
        // do nothing
        return false;
    }
}
