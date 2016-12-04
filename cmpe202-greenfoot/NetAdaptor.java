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
    private static String url = "http://gameserver-ed4741ba-1.44437fad.cont.dockerapp.io:32778/gameserver";

    private NetAdaptor() {
        try {
            ClientResource client;
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
            ClientResource client = new ClientResource(url);
            Representation result_string = client.get();
            JSONObject result = new JSONObject( result_string.getText() ) ;
            return  (String) result.get("ack"); 
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return null;
    }

    public void writeHighScore(String playername, int score) {
        ClientResource client = new ClientResource(url);
        JSONObject json = new JSONObject();
        json.put("action", "setHighScore");
        json.put("playerName", playername);
        json.put("score", score);

        client.post(new JsonRepresentation(json), MediaType.APPLICATION_JSON);
    }

    public ArrayList<PlayerScore> getHighScore() {
        ClientResource client = new ClientResource(url);
        ArrayList<PlayerScore> toReturn = new ArrayList<>();
        
        JSONObject json = new JSONObject();
        json.put("action", "getHighScore");

        Representation result_string = client.post(new JsonRepresentation(json), MediaType.APPLICATION_JSON);
    
        try {
            JSONObject obj = new JSONObject(result_string.getText());
            JSONArray array = obj.getJSONArray("highScore");
            
            for (int i = 0; i < array.length(); ++i) {
                int score = array.getJSONObject(i).getInt("score");
				String playerName = array.getJSONObject(i).getString("playerName");
                toReturn.add(new PlayerScore(playerName, score));
            }
            
            return toReturn;
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return null;
    }
}
