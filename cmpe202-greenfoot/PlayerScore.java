/**
 * Write a description of class PlayerScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerScore 
{
    private String playername;
    private int score;
    
    public PlayerScore (String playername, int score) {
        this.playername = playername;
        this.score = score;
    }
    
    public void setPlayername(String playername) {
        this.playername = playername;
    }
    
    public String getPlayername() {
        return this.playername;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public int getScore() {
        return this.score;
    }
}
