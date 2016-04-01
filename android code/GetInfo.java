package com.tew.thomas.roadinfo;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;



/**
 * Created by Thomas on 3/13/2016.
 */
public class GetInfo extends AsyncTask<String,  Void, String> {

    URL roadInfo;
    URLConnection connection;
    BufferedReader in;
    ArrayList<Road> roads = new ArrayList<>();
    Boolean finished = false;

    protected void onPreExecute() {

    }

    protected String doInBackground(String... urls) {
        makeURL();
        //System.out.println("URL MADE");
        parseInfo();
        System.out.println("INFO PARSED");
        finished = true;
        return "Executed";
    }

    protected ArrayList<Road> getRoads() {
        return roads;
    }

    protected void onPostExecute() {
        finished = true;
    }

    protected boolean getIsFinished() {
        return finished;
    }

    /**
     * @return True if URL grab successful, false if not.
     */
    public boolean makeURL() {
        try {
            roadInfo = new URL("http://511.commuterlink.utah.gov/tats.web.report/");
            connection = roadInfo.openConnection();
            connection.connect();
            return true;
        }
        catch(IOException e){
            //e.printStackTrace();
            return false;
        }
    }

    public void parseInfo() {
        try {
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        }
        catch(IOException io) {
            io.printStackTrace();
        }


        String currentLine = "";
        String[] info;

            while (currentLine != null) {
                try {
                    currentLine = in.readLine();
                    if(currentLine == null) {
                        break;
                    }
                    if (currentLine.contains("Little Cottonwood")) {
                        info = currentLine.split("<td>|</td>");
                        roads.add(new Road(info[1], info[5],info[7], info[9]));
                        System.out.println("road added");
                    }
                } catch (Exception e) {
                    // could not refresh message
                    roads.add(new Road(""));
                    roads.add(new Road());
                    System.out.println("Could not refresh information");
                    break;
                }
            }
        }
}
