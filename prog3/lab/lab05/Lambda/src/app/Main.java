package app;

import java.util.*;
import java.io.*;

public class Main {
    protected static Scanner cin = new Scanner(System.in  );
    protected static ArrayList<Beer> Beerlog = new ArrayList<Beer>();
    protected static File wd = new File(System.getProperty("user.dir"));
    protected static Map<String, Comparator<Beer>> comps;
    static {
        comps = new HashMap<>();
        comps.put("name", Comparator.comparing(Beer::getName));
        comps.put("style", Comparator.comparing(Beer::getStyle));
        comps.put("strength", Comparator.comparing(Beer::getStrength));
    }
    protected static void add(String[] cmd){
        Beer temp = new Beer(cmd[1], cmd[2], Double.parseDouble(cmd[3]));
        Beerlog.add(temp);
    }
    public static void list(String[] cmd){
        if(cmd.length > 1){
            Comparator<Beer> cmp = comps.get("name");

            if (comps.containsKey(cmd[1])) {
                cmp = comps.get(cmd[1]);
            }

            Beerlog.sort(cmp);

            for (Beer b : Beerlog) {
                System.out.println(b);
            }
        }else{
            for (Beer x : Beerlog) {
                System.out.println(x);
            }
        }

    }
    public static void load(String[] cmd) {
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

    public static void save(String[] cmd) {
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
    public static void search(String[] cmd){
        for(Beer b : Beerlog){
            if(b.getName().equals(cmd[1]))
                System.out.println(b);
        }
    }
    public static void find(String[] cmd){
        for(Beer b : Beerlog){
            if(b.getName().contains(cmd[1]))
                System.out.println(b);
        }
    }
    public static void delete(String[] cmd){
        Iterator<Beer> it = Beerlog.iterator();
        while (it.hasNext()) {
            Beer beer = it.next();
            if (beer.getName().equals(cmd[1])) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String line;
        String[] cmd;
        // statikus blokk?
        HashMap<String, Command> commands = new HashMap<>();
        commands.put("add", Main::add);
        commands.put("list", Main::list);
        commands.put("load", Main::load);
        commands.put("save", Main::save);
        commands.put("search", Main::search);
        commands.put("find", Main::find);
        commands.put("delete", Main::delete);
        while(true){
            line = cin.nextLine();
            cmd = line.split(" ");
            commands.get(cmd[0]).execute(cmd);
        }
    }
}
