/**
 * Write a description of class SubmitState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CanNextState extends State 
{
    GameState gameState;

    public CanNextState (GameState gameState) {
        this.gameState = gameState;
    }

    public void moveToNextState() {
        gameState.setState(gameState.getCanStartState());
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
        // nextButton --> act
        return true;
    }
}
