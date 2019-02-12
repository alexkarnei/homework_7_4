package by.itstep.karnei;

import java.util.Iterator;

public class MyArrayList<E> implements MyList<E> {
    private E[] data;
    private static int capacity = 10;
    private static int size = 0;


    public MyArrayList(int insureCapacity) {
        if (insureCapacity >= 0) {
            this.data = (E[]) new Object[insureCapacity];
        } else {
            throw new ExceptionInInitializerError();
        }
    }

    public MyArrayList() {
        this.data = (E[]) new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("Index is not valid");
    }

    private void resize(int newLength) {
        E[] temp = data;
        data = (E[]) new Object[newLength];
        System.arraycopy(temp, 0, data, 0, size);
    }

    public String toString() {
        String string = "";
        for (int i = 0; i < data.length; i++) {
            string += data[i];
            string += " ";
        }
        return string;
    }

    private void ensureCapasity(int capasity) {

    }


    public boolean pushBack(E element) {
        try {
            if (size > data.length - 1) {
                resize((int) (capacity * 1.5) + 1);
                data[size++] = element;
            } else {
                data[size++] = element;
            }
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean popFront() {
        try {
            E[] temp = data;
            data = (E[]) new Object[temp.length];
            size--;
            System.arraycopy(temp, 1, data, 0, temp.length - 1);
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean pushFront(E element) {
        try {
            if (size + 1 > data.length) {
                E[] temp = data;
                data = (E[]) new Object[temp.length + 1];
                System.arraycopy(temp, 0, data, 1, temp.length);
                data[0] = element;
                size++;
            } else {
                E[] temp = data;
                data = (E[]) new Object[temp.length];
                System.arraycopy(temp, 0, data, 1, temp.length - 1);
                data[0] = element;
                size++;
            }
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean insert(E element, int index) {
        rangeCheck(index);
        try {
            E[] temp = data;
            if (index + 1 <= data.length && size + 1 <= data.length) {
                if (index > size) {
                    size = index + 1;
                } else {
                    size++;
                }
                data = (E[]) new Object[temp.length];
                System.arraycopy(temp, 0, data, 0, index);
                data[index] = element;
                int otherElement = temp.length - index - 1;
                System.arraycopy(temp, index, data, index + 1, otherElement);
                return true;
            } else {
                throw new ArrayIndexOutOfBoundsException("Out of bounds array");
            }
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean removeAt(int index) {
        rangeCheck(index);
        E[] temp = data;
        data = (E[]) new Object[temp.length];
        System.arraycopy(temp, 0, data, 0, index);
        int otherElement = data.length - index - 1;
        size--;
        if (otherElement > 0)
            System.arraycopy(temp, index + 1, data, index, otherElement);

        return true;
    }

    public boolean remove(E element) {

        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(element)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public void removeAll(E element) {
        for (int i = 0; i < data.length; i++) {
            if (element.equals(data[i])) {
                data[i] = null;
                size--;
            }
        }
    }

    public void popBack() {
        removeAt(size - 1);
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>(data);
    }
}
