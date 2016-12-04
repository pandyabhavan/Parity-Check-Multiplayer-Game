import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.net.* ;
import java.util.* ;
import java.io.* ;
import org.json.* ;
import org.restlet.resource.*;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.data.* ;

/**
 * Write a description of class Communicator here.
 *     Communicator class is used to communicate with the server
 * @author Aaron Lam
 * @version 1.0 - update 11-23-2016
 */
public class NetAdaptor extends Actor
{
    private static NetAdaptor instance;
    private static String url = "http://gameserver-ed4741ba-1.ba56d9f4.cont.dockerapp.io:32773/gameserver";
    private ClientResource client;

    private NetAdaptor() {
        try {
            client = new ClientResource(url);
        } catch (Exception e) {
            System.out.println("NetAdaptor ERROR: " + e);
        }
    }

    public static NetAdaptor getInstance() {
        if (instance == null) {
            instance = new NetAdaptor();
        }
        return instance;
    }

    public String getAck() {
        try {
            Representation result_string = client.get();
            JSONObject result = new JSONObject( result_string.getText() ) ;
            return  (String) result.get("ack"); 
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return null;
    }

    public boolean isHighScore(int score) {
        ArrayList<PlayerScore> players = getHighScore();
        PlayerScore player = players.get(players.size()-1);
        if (player.getScore() < score) {
            return true;
        }
        return false;
    }

    public void writeHighScore(String playername, int score) {
        if (!isHighScore(score)) {
            return;
        }
        JSONObject json = new JSONObject();
        json.put("action", "setHighScore");
        json.put("playername", playername);
        json.put("score", score);

        client.post(new JsonRepresentation(json), MediaType.APPLICATION_JSON);
    }

    public ArrayList<PlayerScore> getHighScore() {
        ArrayList<PlayerScore> toReturn = new ArrayList<>();
        try {
            JSONObject json = new JSONObject();
            json.put("action", "getHighScore");
            client.post(new JsonRepresentation(json), MediaType.APPLICATION_JSON);
            
            Representation result_string = client.get();
            JSONObject result = new JSONObject(result_string.getText());
            JSONArray playerScore = result.getJSONArray("highScore");
            
            int size = playerScore.length();
            for (int i = 0; i < size; ++i) {
                String playername = playerScore.getJSONObject(i).getString("playername");
                int score = playerScore.getJSONObject(i).getInt("score");
                toReturn.add(new PlayerScore (playername, score));
            }
            return toReturn;
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return null;
    }
}
