import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrderedList<T extends Comparable<T>> {
    private ArrayList<T> list;
    private Comparator<T> comp;

    public OrderedList() {
        this.list = new ArrayList<>();
        this.comp = new Comp<>();
    }

    public void push(T t) {
        list.add(t);
    }

    public T pop() {
        if (list.isEmpty())
            return null;
        T result = Collections.min(list, comp);
        list.remove(result);
        return result;
    }
}
