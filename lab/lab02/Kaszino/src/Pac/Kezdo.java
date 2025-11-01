package Pac;

public class Kezdo  extends Jatekos{
    private String nev;
    Kezdo(String n){
        nev = n;
    }
    public void lep(){
        System.out.println("Jatekos neve: " + toString());
        System.out.println("Aktualis kor: " + asztal.getKor());
        if(asztal.getKor() % 2 == 1){
            asztal.emel(1.0);
        }else{
            asztal.emel(0.0);
        }
    }
    public String toString(){
        return nev;
    }
}
