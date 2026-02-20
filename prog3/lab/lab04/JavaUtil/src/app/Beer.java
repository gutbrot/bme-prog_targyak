package app;

import java.io.Serializable;

public class Beer implements Serializable {
    protected String name;
    protected String style;
    protected double strength;

    public Beer(String name, String style, double strength){
        this.name = name;
        this.style = style;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }
    public String getStyle(){
        return style;
    }
    public double getStrength(){
        return strength;
    }

    @Override
    public String toString(){
        return (name + " " + style + " " + strength);
    }
}
