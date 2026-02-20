import java.util.Collections;
import java.util.LinkedList;

public class Dealer<T> {
    private LinkedList<T> deck = new LinkedList<>();
    public Dealer(LinkedList<T> t){
        this.deck = t;
    }
    public void prepare(){
        Collections.shuffle(this.deck);
    }
    public T deal(){
        return this.deck.removeFirst();
    }
    public void add(LinkedList<T> t){
        this.deck.addAll(t);
    }
}