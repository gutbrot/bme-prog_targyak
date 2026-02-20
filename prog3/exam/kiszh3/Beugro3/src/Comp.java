import java.util.Comparator;

public class Comp<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T a, T b) {
        return a.compareTo(b);
    }
}
