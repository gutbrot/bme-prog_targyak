package Pac;

public class Nyuszi extends Jatekos{
    public String szin;
    Nyuszi(String sz){
        szin = sz;
    }

    @Override
    public String toString() {
        return szin;
    }

    public void lep(){
        System.out.println(toString() + asztal.getKor());
        if(asztal.getTet() < 50){
            asztal.emel(5.);
        }else {
            System.out.println(asztal.getTet() + "Huha!");
        }
    }
}
