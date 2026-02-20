package app;

import java.util.*;
import java.io.*;

class NameComparator implements Comparator<Beer> {
    @Override
    public int compare(Beer b1, Beer b2) {
        return b1.getName().compareTo(b2.getName());
    }
}

class StyleComparator implements Comparator<Beer> {
    @Override
    public int compare(Beer b1, Beer b2) {
        return b1.getStyle().compareTo(b2.getStyle());
    }
}

class StrengthComparator implements Comparator<Beer> {
    @Override
    public int compare(Beer b1, Beer b2) {
        return Double.compare(b1.getStrength(), b2.getStrength());
    }
}

public class Main {
    protected static Scanner cin = new Scanner(System.in  );
    protected static ArrayList<Beer> Beerlog = new ArrayList<Beer>();
    protected static File wd = new File(System.getProperty("user.dir"));
    protected static void add(String[] cmd){
        Beer temp = new Beer(cmd[1], cmd[2], Double.parseDouble(cmd[3]));
        Beerlog.add(temp);
    }
    protected static void list(String[] cmd){
        if(cmd.length > 1){
            switch (cmd[1]){
                case "name" -> {
                    Collections.sort(Beerlog, new NameComparator());
                }
                case "style" -> {
                    Collections.sort(Beerlog, new StyleComparator());
                }
                case "strength" -> {
                    Collections.sort(Beerlog, new StrengthComparator());
                }
            }
        }
        for (Beer x : Beerlog) {
            System.out.println(x);
        }
    }
    protected static void load(String[] cmd) {
        if (cmd.length < 2) {
            System.out.println("Missing filename");
            return;
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(cmd[1]))) {
            ArrayList<Beer> loadedList = (ArrayList<Beer>) in.readObject();
            Beerlog = loadedList;
            System.out.println("Successfully loaded beer log from " + cmd[1]);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    protected static void save(String[] cmd) {
        if (cmd.length < 2) {
            System.out.println("Missing filename");
            return;
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(cmd[1]))) {
            out.writeObject(Beerlog);
            System.out.println("Successfully saved beer log to " + cmd[1]);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
    protected static void search(String[] cmd){
        for(Beer b : Beerlog){
            if(b.getName().equals(cmd[1]))
                System.out.println(b);
        }
    }
    protected static void find(String[] cmd){
        for(Beer b : Beerlog){
            if(b.getName().contains(cmd[1]))
                System.out.println(b);
        }
    }
    protected static void delete(String[] cmd){
        Iterator<Beer> it = Beerlog.iterator();
        while (it.hasNext()) {
            Beer beer = it.next();
            if (beer.getName().equals(cmd[1])) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
        Beer b1 = new Beer("Kobanyai", "light", 4.3);
        Beer b2 = new Beer("Delirium Red","belgian",8.5);
        System.out.println(b1.toString());
        System.out.println(b2.toString());

        while (true) {
            String line = cin.nextLine();
            String[] cmd = line.split(" ");
            switch (cmd[0]){
                case "exit" -> {
                    return;
                }
                case "add" -> {
                    add(cmd);
                }
                case "list" -> {
                    list(cmd);
                }
                case "search" -> {
                    search(cmd);
                }
                case "find" -> {
                    find(cmd);
                }
                case "save" -> {
                    save(cmd);
                }
                case "load" -> {
                    load(cmd);
                }
            }
        }
    }
}
