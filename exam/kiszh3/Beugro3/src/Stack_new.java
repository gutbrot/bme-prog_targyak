import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack_new<T> {
    private int max;
    private List<T> stack;

    public Stack_new(int max){
        this.max = max;
        this.stack = new ArrayList<>(); // nincs olyan, hogy SomeList??
    }
    public void push(T t){
        if(stack.size() == this.max){
            stack.remove(stack.getFirst()); // stack.get(0) is jó
        }
        stack.add(t);
    }
    public T pop() throws EmptyStackException { // nincs EmptyException ??
        if(stack.isEmpty()){  // stack.size() == 0
            throw new EmptyStackException();
        }
        return this.stack.removeLast();
    }
}