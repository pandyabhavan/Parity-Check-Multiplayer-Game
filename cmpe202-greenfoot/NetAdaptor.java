import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

/**
 * Write a description of class Communicator here.
 *     Communicator class is used to communicate with the server
 * @author Aaron Lam
 * @version 1.0 - update 11-23-2016
 */
public class NetAdaptor extends Actor
{
    private static NetAdaptor instance;
    private static String url = "docker url";
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

    public JSONObject getJSONObject() {
        Representation result_string = client.get();
        try {
            return new JSONObject(result_string.getText()); 
        } catch (Exception e) {
            System.out.println("getJSONObject ERROR: " + e);
        }
        return null;
    }

}
