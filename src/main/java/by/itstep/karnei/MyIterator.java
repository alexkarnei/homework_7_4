package by.itstep.karnei;

import java.util.Iterator;

public class MyIterator<E> implements Iterator<E> {
    private int index = 0;
    private E[] data;

    public MyIterator(E[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return index < data.length;
    }

    @Override
    public E next() {
        return data[index++];
    }

    @Override
    public void remove() {
    }
}
