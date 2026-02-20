package Pac;

public class Main {
    public static void main(String[] args) {
//        Kezdo kezdo1 = new Kezdo("Bela");
//        Kezdo kezdo2 = new Kezdo("Margit");
//        Robot robot1 = new Robot();
//        Robot robot2 = new Robot();
//        Asztal asztal = new Asztal();
//        asztal.addJatekos(kezdo1);
//        asztal.addJatekos(kezdo2);
//        asztal.addJatekos(robot1);
//        asztal.addJatekos(robot2);
//        asztal.ujJatek();
//        for (int i = 0; i < 5; i++) {
//            asztal.kor();
//        }

//        Asztal uresAsztal = new Asztal();
//        try{
//            for (int i = 0; i < 5; i++) {
//                uresAsztal.kor();
//            }
//        }catch (NincsJatekos e){
//            return;
//        }finally {
//            System.out.println("Hiba lekezelve");
//        }

        Asztal nyusziMester = new Asztal();
        Nyuszi ny = new Nyuszi("piros");
        Mester me = new Mester(5);
        Ember em = new Ember();
        nyusziMester.addJatekos(ny);
        nyusziMester.addJatekos(me);
        nyusziMester.addJatekos(em);
        nyusziMester.ujJatek();
        for (int i = 0;i < 10; i++){
            nyusziMester.kor();
        }


    }
}