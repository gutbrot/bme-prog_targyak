package Pac;

public class Mester extends Jatekos{
    private int mesterFokozat;

    Mester(int m){
        mesterFokozat = m;
    }

    @Override
    public String toString() {
        return "Mester " + mesterFokozat;
    }

    @Override
    public void lep(){
        System.out.println(mesterFokozat + " " + asztal.getKor());
        asztal.emel(asztal.getTet()* mesterFokozat/100);
        ;
    }
}
