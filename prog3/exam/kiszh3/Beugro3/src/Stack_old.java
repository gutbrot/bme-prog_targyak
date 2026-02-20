import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack_old<T> {
    private LinkedList<T> list;
    private int max;

    public Stack_old(int max){
        this.max = max;
    }
    public void push(T t){
        list.addFirst(t); // list.add(0, t) is jó
        if(list.size() > max)
            list.removeLast(); // list.remove(list.size()-1)
    }
    public T pop() throws EmptyStackException{  // továbbra sincs ilyen exception
        if(list.isEmpty())
            throw new EmptyStackException();
        return list.removeFirst(); // list.remove(0)
    }
}