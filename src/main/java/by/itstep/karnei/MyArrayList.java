package by.itstep.karnei;

import java.lang.reflect.Array;
import java.util.Arrays;


class MyArrayList<T> {

    private T[] data;
    private static int CAPACITY = 10;
    private int size;
    public int capacity;

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            data = (T[]) new Object[capacity];
        } else if (capacity == 0) {
            data = (T[]) new Object[0];
        }else {
            throw new ExceptionInInitializerError();
        }
    }

    public MyArrayList() {
        MyArrayList data = new MyArrayList(10);
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        String stringData = "";
        for (int i = 0; i < data.length; i++) {
            stringData += data[i];
            stringData += " ";
        }
        return stringData;
    }

    private void ensureCapacity(int capacity) {
        this.capacity = capacity;
        if (capacity > CAPACITY) {
            while (data.length > CAPACITY) {
                CAPACITY = (int) (CAPACITY * 1.5 + 1);
                this.data = (T[]) new Object[CAPACITY];
            }
        }
    }


}
