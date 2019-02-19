package com.liakhovskyi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ListTest {

    private List<Integer> integerArrayList = new ArrayList<>();
    private List<Integer> integerLinkedList = new LinkedList<>();


    @Before
    public void init() {
        integerArrayList.add(10);
        integerArrayList.add(20);
        integerArrayList.add(30);
        integerArrayList.add(40);
        integerArrayList.add(50);

        integerLinkedList.add(10);
        integerLinkedList.add(20);
        integerLinkedList.add(30);
        integerLinkedList.add(40);
        integerLinkedList.add(50);
    }

    @Test
    public void testListReturnProperElementFromIndex() {
        int expectedResult1 = 30;
        int actualResult1 = integerArrayList.get(2);
        assertEquals(expectedResult1, actualResult1);

        int expectedResult2 = 40;
        int actualResult2 = integerLinkedList.get(3);
        assertEquals(expectedResult2, actualResult2);
    }

    @Test
    public void testListReturnProperSizeAfterAddingNewElement() {
        int expectedSize1 = 5;
        int actualSize1 = integerArrayList.size();
        assertEquals(expectedSize1, actualSize1);

        integerArrayList.add(60);
        integerArrayList.add(70);

        int expectedSizeAfter1 = 7;
        int actualSizeAfter1 = integerArrayList.size();
        assertEquals(expectedSizeAfter1, actualSizeAfter1);

        int expectedSize2 = 5;
        int actualSize2 = integerLinkedList.size();
        assertEquals(expectedSize2, actualSize2);

        integerLinkedList.add(60);
        integerLinkedList.add(70);

        int expectedSizeAfter2 = 7;
        int actualSizeAfter2 = integerLinkedList.size();
        assertEquals(expectedSizeAfter2, actualSizeAfter2);
    }

    @Test
    public void testListReturnProperSizeAfterRemoveElement() {
        int expectedSize1 = 5;
        int actualSize1 = integerArrayList.size();
        assertEquals(expectedSize1, actualSize1);

        integerArrayList.remove(0);

        int expectedSizeAfter1 = 4;
        int actualSizeAfter1 = integerArrayList.size();
        assertEquals(expectedSizeAfter1, actualSizeAfter1);

        int expectedSize2 = 5;
        int actualSize2 = integerLinkedList.size();
        assertEquals(expectedSize2, actualSize2);

        integerLinkedList.remove(0);

        int expectedSizeAfter2 = 4;
        int actualSizeAfter2 = integerLinkedList.size();
        assertEquals(expectedSizeAfter2, actualSizeAfter2);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testListThrowIndexExceptionInGetMethodOfArrayList() {
        integerArrayList.get(5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testListThrowIndexExceptionInGetMethodOfLinkedList() {
        integerLinkedList.get(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testListThrowIndexExceptionInRemoveMethodOfArrayList() {
        integerArrayList.remove(999);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testListThrowIndexExceptionInRemoveMethodOfLinkedList() {
        integerArrayList.remove(-999);
    }
}