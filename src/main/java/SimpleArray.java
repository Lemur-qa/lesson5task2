import java.sql.SQLOutput;
import java.util.Iterator;

public class SimpleArray<E> implements Simple<E> {
    public static void main(String[] args) {
        Simple<String> strings = new SimpleArray<>();
        strings.add("first");
        strings.add("second");
        strings.add("third");
        strings.update(1, "word");

        System.out.println(strings.get(0));
        System.out.println(strings.size());

    }

    private E[] values;

    SimpleArray() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        E[] temp = values;
        values = (E[]) new Object[temp.length + 1];
        System.arraycopy(temp, 0, values, 0, temp.length);
        values[values.length - 1] = e;
        return true;
    }

    @Override
    public void delete(int index) {

    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }
}
