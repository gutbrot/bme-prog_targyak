package Pac;

public class Robot extends Jatekos{
    private static int id = 0;
    private int i;
    Robot(){
        i = id++;
    }

    public void lep(){
        System.out.println("Jatekos neve: " + toString());
        System.out.println("Aktualis kor: " + asztal.getKor());
    }
    @Override
    public String toString(){
        return "Robot" + i;
    }
}
