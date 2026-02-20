package Pac;
import java.util.*;

public class Asztal {
    private Jatekos[] jatekosok = new Jatekos[0];
    private double tet;
    private  int kor;
    private double goal;

    public void ujJatek(){
        Random r = new Random();
        tet = 0;
        kor = 0;
        goal = r.nextDouble(0,101);

    }
    public void addJatekos(Jatekos j){
        if(jatekosok.length <= 10){
            Jatekos[] temp = new Jatekos[jatekosok.length+1];
            for (int i = 0; i < jatekosok.length; i++){
                temp[i] = jatekosok[i];
            }
            temp[jatekosok.length] = j;
            jatekosok = temp;
            j.asztal = this;
        }else{
            System.out.println("Nincs hely az asztalnal!");
        }
    }
    public int getKor(){
        return kor;
    }
    public void emel(double f){
        tet += f;
    }
    public void kor() throws NincsJatekos{
        if (jatekosok == null || jatekosok.length == 0) {
            throw new NincsJatekos("Nem ul senki sem az asztalnal");
        }
        kor++;
        for (int i = 0; i < jatekosok.length; i++){
            jatekosok[i].lep();
            if(goal <= tet && tet<= goal*1.1){
                System.out.println("Nyert a " + i + ". jatekos!");
                return;
            }
        }
        System.out.println("Az aktualis tet: " + tet);
    }
    public double getTet(){
        return tet;
    }
}