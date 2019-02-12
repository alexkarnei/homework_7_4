package by.itstep.karnei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class MyArrayList<E> implements MyList<E> {

    /**
     * Initialize the encapsulated array.
     */
    private E[] data;

    /**
     * Current array capacity. InitialCapacity.
     */
    private static int capacity = 10;

    /**
     * Current number of existing array elements
     */
    private static int size = 0;


    /**
     * Constructor with an int parameter. Specifies the initial capacity
     * array. Accepts one parameter (sets capacity),
     * allocates memory for an array (size = 0).
     * @param  initialCapacity  the initial capacity of the list
     * @throws ExceptionInInitializerError if the specified initial capacity
     * is negative
     */

    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            this.data = (E[]) new Object[initialCapacity];
        } else {
            throw new ExceptionInInitializerError();
        }
    }
    /**
     * Constructs an empty array with an initial capacity of ten.
     */
    public MyArrayList() {
        this.data = (E[]) new Object[capacity];
    }



    /**
     * Setter for current number of existing array elements.
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Checking the entered parameter (index) to exit the array
     * @throws IndexOutOfBoundsException if the specified index
     * is not valid
     */

    private void chekIndex(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("Index is not valid");
    }

    /**
     * Checking the entered parameter (index) to exit the array & index > 0 always
     * @throws IndexOutOfBoundsException if the specified index
     * is not valid
     */

    private void chekIndexInsertElement(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index is not valid");
        }
    }

    /**
     * Resize array
     * @param newLength
     */

    private void resize(int newLength) {
        E[] temp = data;
        data = (E[]) new Object[newLength];
        System.arraycopy(temp, 0, data, 0, size);
    }

    /**
     * Override method with array space separated
     * Return String
     */

    public String toString() {
        String string = "";
        for (int i = 0; i < data.length; i++) {
            string += data[i];
            string += " ";
        }
        return string;
    }

    /**
     * Closed method! checks enough
     * there is a memory reserve for storing specified in parameter
     * number of items. If the parameter value is less than
     * current capacity, then nothing happens. If value
     * parameter is greater than the current capacity, the array re-creates
     * Xia, memory is allocated 1.5 times + 1 element more.
     * Existing elements are transferred to the new array.
     * @param capasity  & resize array
     */

    private void ensureCapasity(int capasity) {
        if ((capasity - size) <= 0)
            resize((int) (capasity * 1.5) + 1);
    }

    /**
     * Add an element to the end of the array. Must
     * be checking whether there is enough memory! If the memory is not
     * it is enough to increase the capacity of the data array
     * @param element
     * @throws ClassCastException
     * Return boolean
     */

    public boolean pushBack(E element) {
        try {
            if (size > data.length - 1) {
                ensureCapasity(data.length);
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

    /**
     * Remove the first element from the array
     * Create a new array and copy the elements starting
     * from the second element putting it in place of the first element.
     * @throws ClassCastException
     * Return boolean
     */

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


    /**
     * Insert a new element in the beginning of the array.
     * Create a new array and copy the elements starting
     * from the first element and putting it in place of
     * the second element. The added element is put on the
     * first place in the array.
     * @param element
     * @throws ClassCastException
     * Return boolean
     */

    public boolean pushFront(E element) {
        try {
            ensureCapasity(data.length);
            E[] temp = data;
            data = (E[]) new Object[temp.length];
            System.arraycopy(temp, 0, data, 1, temp.length - 1);
            data[0] = element;
            size++;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    /**
     * Insert new item into array as specified
     * index, with check for out of array
     * Create a new array. Copy into it the
     * elements from the left of the entered index,
     * insert the element, and copy the elements to
     * the right of the entered index
     * Return new array
     *
     * @param element
     * @param index
     * @throws ArrayIndexOutOfBoundsException
     * @throws ClassCastException
     */

    public boolean insert(E element, int index) {
        chekIndexInsertElement(index);
        ensureCapasity(data.length);
        try {
            E[] temp = data;
            if (index + 1 <= data.length) {
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
    /**
     * Removes the element finding on index position in this array.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return new array without this element
     */
    public boolean removeAt(int index) {
        chekIndex(index);
        E[] temp = data;
        data = (E[]) new Object[temp.length];
        System.arraycopy(temp, 0, data, 0, index);
        int otherElement = data.length - index - 1;
        size--;
        if (otherElement > 0)
            System.arraycopy(temp, index + 1, data, index, otherElement);

        return true;
    }
    /**
     * Removes the first element whose value matches the parameter
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param element which must be removed
     * @return new array without this element
     */
    public boolean remove(E element) {

        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(element)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }
    /**
     * Removes all element whose value matches the parameter
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param element which must be removed
     * @return new array without this elements
     */
    public void removeAll(E element) {
        for (int i = size - 1; i >= 0; i--) {
            if (element.equals(data[i])) {
                removeAt(i);
            }
        }
    }

    /**
     * Removes last element in array
     *
     *
     * @return new array without this elements
     */

    public void popBack() {
        removeAt(size - 1);
    }

    /**
     * Removes all of the elements from this array.  The array will
     * be empty after this call returns.
     */

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }
    /**
     * Returns true if this array contains no elements.
     *
     * @return true if no elements
     * @return false if there is at least one elements
     */
    public boolean isEmphty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Trims the capacity of this фккфн instance to be the
     * arrays current size.  An application can use this operation to minimize
     * the storage of an array instance.
     */

    public void trimToSize() {
        if (size < data.length) {
            data = (size == 0) ? (E[]) new Object[]{} : Arrays.copyOf(data, size);
        }
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this array, or -1 if this array does not contain the element.
     */

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this array, or -1 if this array does not contain the element.
     *
     */

    public int lastIndexOf(E element) {
        for (int i = size - 1; i >= 0; i--) {
            if (element.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Reordering of elements in an array
     * on the opposite.
     * Return new array
     *
     */

    public void reverse() {
        for (int i = 0; i < data.length / 2; i++) {
            E temp = data[data.length - i - 1];
            data[data.length - i - 1] = data[i];
            data[i] = temp;
        }
    }

    /**
     *
     * Random mixing elements of the array. Apply random.
     *
     */

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            int index = random.nextInt(i + 1);
            E temp = data[index];
            data[index] = data[i];
            data[i] = temp;
        }
    }

    @Override
public Iterator<E> iterator(){
        return new MyIterator<>(data);
        }
        }
