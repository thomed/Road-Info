package com.tew.thomas.roadinfo;

/**
 * Created by Thomas on 11/18/2015.
 */
public class Road {

    private String name;
    private String surface;
    private String restrictions;
    private String weather;

    public Road(String n, String s, String w, String r) {
        name = n;
        surface = s;
        restrictions = r;
        weather = w;
    }

    /**
     * Constructor for creating empty
     * @param n
     */
    public Road(){
    }

    /**
     * Constructor for creating road as error message
     * @param n
     */
    public Road(String n) {
        name = n;
    }

    @Override
    public String toString() {
        if(name == null) {
            return "";
        }
        if(surface == null) {
            return String.format("%s%n%s", "Could not refresh information", "Check the status of your connection");
        }
        return String.format("%s:%n\t\tSurface: %s%n\t\tWeather: %s%n\t\tRestrictions: %s%n", name, surface, weather, restrictions);
    }
}
