import java.io.*;
import java.util.Scanner;

public class Main {
    static File wd;

    protected static void pwd(String[] cmd) {
        System.out.println(wd.getAbsolutePath());
    }

    protected static void ls(String[] cmd) {
        File[] files = wd.listFiles();
        if (files != null) { // not null
            if (cmd.length == 2 && cmd[1].equals(("-l"))) { // two parameters
                for (File f : files) {
                    System.out.println((f.isDirectory() ? "D " : "F ") + f.getName() + " " + f.getTotalSpace());
                }
            } else { // without parameters
                for (File f : files) {
                    System.out.println(f.getName());
                }
            }

        }
    }

    protected static void cd(String[] cmd) {
        if (cmd.length == 2 && cmd[1].equals("..")) {
            if (wd.getParentFile() != null) {
                wd = wd.getParentFile();
            }
        } else {
            File[] files = wd.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory() && f.getName().equals(cmd[1])) {
                        wd = f;
                        return;
                    }
                }
                System.out.println("Missing file");
            }
        }
    }

    protected static void mkdir(String[] cmd) throws SecurityException{ // exception handling??
        if(cmd.length == 2){
            String name = wd.getAbsolutePath() + File.separator +cmd[1];
            File temp = new File(name);
            if(!temp.mkdir()){
                System.out.println("Error");
            }
        }
    }

    protected static void cp(String[] cmd) throws FileNotFoundException, IOException {
        File source = new File(wd, cmd[1]);
        File dest = new File(wd, cmd[2]);

        try (
                FileInputStream fis = new FileInputStream(source);
                FileOutputStream fos = new FileOutputStream(dest)
        ) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        }
    }

    protected static void head(String[] cmd) throws FileNotFoundException {
        int n = 10;
        FileInputStream fis = null;
        Scanner scan = null;
        if(cmd.length == 3){
            String name = wd.getAbsolutePath() + File.separator + cmd[2];
            fis = new FileInputStream(name);
            scan = new Scanner(fis);
        }else{
            n = Integer.parseInt(cmd[2]);
            String name = wd.getAbsolutePath() + File.separator + cmd[3];
            fis = new FileInputStream(name);
            scan = new Scanner(fis);
        }
        for(int i = 0; i < n && scan.hasNextLine();  i++){
            String resultToPrint = scan.nextLine();
            System.out.println(resultToPrint);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner cin = new Scanner(System.in);
        wd = new File(System.getProperty("user.dir"));
        while (true) {
            String line = cin.nextLine();
            String[] cmd = line.split(" ");

            switch (cmd[0]) {
                case "exit" -> {
                    return;
                }
                case "pwd" -> pwd(cmd);
                case "ls" -> ls(cmd);
                case "cd" -> cd(cmd);
                case "mkdir" -> mkdir(cmd);
                case "cp" -> cp(cmd);
                case "head" ->head(cmd);
                default -> {
                }
            }
        }
    }
}