/**
 * Write a description of class GameStateMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameState  
{
    private static GameState gameState;

    State canStartState;
    State canSubmitState;
    State canNextState;
    State endedState;

    State state;

    private GameState() { }

    public static GameState getInstance() {
        if (gameState == null) {
            gameState = new GameState();
            gameState.init();
            return gameState;
        } else {
            return gameState;
        }
    }

    private void init () {
        canStartState = new CanStartState(this);
        canSubmitState = new CanSubmitState(this);
        canNextState = new CanNextState(this);
        endedState = new EndedState(this);
        state = canStartState;
    }
    
    public void moveToNextState() {
        state.moveToNextState();
    }
    
    public boolean canStart() {
        return state.canStart();
    }
    
    public boolean canSubmit() {
        return state.canSubmit();
    }
    
    public boolean canNext() {
        return state.canNext();
    }
    
    public State getState() {
        return state;
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
    public State getCanStartState() {
        return canStartState;
    }
    
    public State getCanSubmitState() {
        return canSubmitState;
    }
    
    public State getCanNextState() {
        return canNextState;
    }
    
    public State getEndedState() {
        return endedState;
    }
}
