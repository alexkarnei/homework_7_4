package by.itstep.karnei;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MyArrayListTest {

    @Test
    public void toStringTest() throws Exception {
        MyArrayList<String> arrayList = new MyArrayList<>(1);
        String string = "It academy Step";
        arrayList.pushFront("Step");
        arrayList.pushFront("academy");
        arrayList.pushFront("It");

        Assert.assertEquals(string, arrayList.toString());
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

        Assert.assertTrue(arrayList.isEmphty());

        arrayList.pushBack("It");
        arrayList.pushBack("academy");
        arrayList.pushBack("Step");
        arrayList.pushBack("Grodno");

        arrayList.clear();
        Assert.assertTrue(arrayList.isEmphty());
    }

    @Test
    public void trimToSizeTest() {

        MyArrayList<Integer> arrayList = new MyArrayList<>();
        int initialCapasity = arrayList.getCapacity();

        arrayList.pushBack(3);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);

        arrayList.trimToSize();

        // Capacity after run metod trimToSize()
        int capasity = arrayList.getCapacity();

        Assert.assertTrue(capasity < initialCapasity);
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

        Assert.assertTrue(arrayList.lastIndexOf(2) == arrayList.getSize() - 1);
    }

    @Test
    public void reverseTest() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.pushBack(3);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);

        //Initialize the string we will expect after executing the method reverse
        String string = "2 1 2 1 2 3";

        arrayList.reverse();
        Assert.assertEquals(string, arrayList.toString());
    }

    @Test
    public void shuffleTest() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.pushBack(3);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);

        System.out.println("\nTask 5 shuffle Test start\n");
        System.out.println("Initial Array : "+arrayList.toString());
        arrayList.shuffle();
        System.out.println("Array after shuffle : "+arrayList.toString());
    }

    @Test
    public void equalsTest() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.pushBack(3);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.trimToSize();

        MyArrayList<Integer> newArray = new MyArrayList<>();

        newArray.pushBack(3);
        newArray.pushBack(2);
        newArray.pushBack(1);
        newArray.pushBack(2);
        newArray.pushBack(1);
        newArray.pushBack(2);
        newArray.trimToSize();

       Assert.assertTrue(arrayList.equals(newArray));
       arrayList.shuffle();
       Assert.assertFalse(arrayList.equals(newArray));
    }

    @Test
    public void getElementTest(){
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.pushBack(3);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);

        System.out.println("\nTask 6 getElementAt Test start\n");
        System.out.println("Initial Array : "+arrayList.toString());
        System.out.println("Array element under index : "+arrayList.getElementAt(2));

    }

    @Test
    public void cloneTest() throws CloneNotSupportedException {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.pushBack(3);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.pushBack(1);
        arrayList.pushBack(2);

        System.out.println("\nTask 6 clone Test start\n");
        System.out.println("Initial Array : "+arrayList.toString());
        MyArrayList<Integer> data = arrayList.clone();
        System.out.println("Clone initial Array : "+ data);

    }
}