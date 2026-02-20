package Pac;

abstract class Jatekos {
    protected Asztal asztal;

    public void lep(){

        System.out.println("Kör: " + asztal.getKor() + ", tét: " + asztal.getTet());
    }
    public void setAsztal(Asztal a){
        asztal = a;
        System.out.println("A jatekos az asztalhoz ult\n");
    }
}
