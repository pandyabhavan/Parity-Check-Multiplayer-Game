/**
 * Write a description of class State here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class State  
{
    public abstract void moveToNextState();
    public abstract boolean canStart();
    public abstract boolean canSubmit();
    public abstract boolean canNext();
}
