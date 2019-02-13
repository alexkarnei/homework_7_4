package by.itstep.karnei;

public interface MyList<E> extends Iterable<E> {

    boolean pushBack(E element);

    int getSize();

    String toString();

    boolean popFront();

    boolean pushFront(E element);

    boolean insert(E element, int index);

    boolean removeAt(int index);

    boolean remove(E element);

    void removeAll(E element);

    void popBack();

    void clear();

    boolean isEmphty();

    void trimToSize();

    int indexOf(E element);

    int lastIndexOf(E element);

    void reverse();

    void shuffle();

    boolean equals(Object obj);

}
