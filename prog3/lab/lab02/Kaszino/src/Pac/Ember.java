package Pac;
import  java.util.Scanner;

public class Ember extends Jatekos{
    public void lep(){
        System.out.println(asztal.getTet());
        System.out.println("Mennyivel emlejek?");
        Scanner scan = new Scanner(System.in);
        asztal.emel(scan.nextDouble());

    }
}
