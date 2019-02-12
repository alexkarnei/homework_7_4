package by.itstep.karnei;

public interface MyList<E> extends Iterable<E> {

    boolean pushBack(E element);

    int getSize();

    boolean popFront();

    boolean pushFront(E element);

    boolean insert(E element, int index);

    boolean removeAt(int index);
    boolean remove(E element);
    void removeAll(E element);
    void popBack();
    void clear();
}
