package by.itstep.karnei;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MyArrayListTest {

    @Test
    public void toStringTest() throws Exception {
       /* MyList<String> myArrayList = new MyArrayList<>(1);
        String string = "It academy Step";
        myArrayList.pushFront("Step");
        myArrayList.pushFront("academy");
        myArrayList.pushFront("It");
        myArrayList.trimToSize();
        Assert.assertTrue(string == myArrayList.toString());
        //Assert.assertEquals("It academy Step" , myArrayList.toString());*/
    }

    @Test
    public void pushBackTest() throws Exception {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.pushBack("Academy");
        Assert.assertEquals(arrayList.getSize() - 1, arrayList.lastIndexOf("Academy"));
    }

    @Test
    public void popFrontTest() throws Exception {
        MyArrayList<String> arrayList = new MyArrayList<>();
        // Add items to the array arrayList
        arrayList.pushBack("It");
        arrayList.pushBack("academy");
        arrayList.pushBack("Step");
        arrayList.pushBack("Grodno");
        Assert.assertEquals(0, arrayList.indexOf("It"));

        // popFront
        arrayList.popFront();
        Assert.assertEquals(0, arrayList.indexOf("academy"));
    }

    @Test
    public void pushFrontTest() throws Exception {
        MyArrayList<String> arrayList = new MyArrayList<>(4);
        arrayList.pushFront("Step");
        Assert.assertEquals(0, arrayList.indexOf("Step"));
    }

    @Test
    public void insertTest() throws Exception {
        MyArrayList<Integer> arrayList = new MyArrayList<>(5);
        Assert.assertEquals(0, arrayList.getSize());
        arrayList.insert(5, 0);
        Assert.assertEquals(1, arrayList.getSize());
    }

    @Test
    public void removeAtTest() throws Exception {
        MyArrayList<String> arrayList = new MyArrayList<>();
        // Add items to the array arrayList
        arrayList.pushBack("It");
        arrayList.pushBack("academy");
        arrayList.pushBack("Step");
        arrayList.pushBack("Grodno");
        arrayList.insert("Alex", 3);

        Assert.assertEquals(5, arrayList.getSize());

        // removeAt element = "Alex" index = 3
        arrayList.removeAt(3);

        Assert.assertNotEquals(5, arrayList.getSize());
}

    @Test
    public void removeTest() throws Exception {
        MyArrayList<Integer> arrayList = new MyArrayList<>();

        // Add items to the array arrayList
        arrayList.pushBack(3);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        int size = arrayList.getSize();

        //remove (element)
        arrayList.remove(2);
        arrayList.trimToSize();
        Assert.assertNotEquals(1, arrayList.indexOf(2));
    }

    @Test
    public void removeAllTest() throws Exception {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        // Add items to the array arrayList
        arrayList.pushBack(3);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        int size = arrayList.getSize();

        //remove (element)
        arrayList.removeAll(2);

        Assert.assertTrue(arrayList.getSize() == 3);
    }

    @Test
    public void popBackTest() throws Exception {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        // Add items to the array arrayList
        arrayList.pushBack(3);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        int size = arrayList.getSize();

        arrayList.popBack();

        Assert.assertTrue(arrayList.getSize() == size - 1);
        Assert.assertTrue(arrayList.lastIndexOf(2) != size - 1);
        arrayList.clear();
    }

    @Test
    public void clearTest() throws Exception {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        // Add items to the array arrayList
        arrayList.pushBack(3);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.clear();

        Assert.assertTrue(arrayList.getSize() == 0);
    }

    @Test
    public void isEmphtyTest() {
        MyArrayList<String> arrayList = new MyArrayList<>();
        Assert.assertEquals(0, arrayList.getSize());
    }

    @Test
    public void trimToSizeTest() {
        int initialCapacity = 15;
        MyArrayList<Integer> arrayList = new MyArrayList<>(initialCapacity);
        arrayList.pushBack(3);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);

        arrayList.trimToSize();
    }

    @Test
    public void indexOfTest() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.pushBack(3);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);

        Assert.assertTrue(arrayList.indexOf(3) == 0);
    }

    @Test
    public void lastIndexOfTest() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.pushBack(3);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);

        Assert.assertTrue(arrayList.lastIndexOf(2) == arrayList.getSize() - 1);    }

    @Test
    public void reverseTest() {

    }

    @Test
    public void shuffleTets() {
    }
}