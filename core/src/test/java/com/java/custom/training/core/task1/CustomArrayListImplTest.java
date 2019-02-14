package com.java.custom.training.core.task1;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomArrayListImplTest {
    private CustomArrayList<Integer> customArrayList;

    @Before
    public void setUp() {
        customArrayList = new CustomArrayListImpl<Integer>();
    }

    @Test
    public void shouldAddPositive() {
        assertTrue(customArrayList.add(6));
        assertEquals(1, customArrayList.size());

    }

    @Test
    public void shouldAddNegative() {
        customArrayList.add(null);
        assertEquals(0, customArrayList.size());
    }

    @Test
    public void shouldClear() {
        customArrayList.add(9);
        customArrayList.add(9);
        customArrayList.add(9);
        customArrayList.clear();
        assertNull(customArrayList.get(0));
    }

    @Test
    public void shouldSizeWithNonNullObjects() {
        customArrayList.add(9);
        customArrayList.add(9);
        customArrayList.add(9);
        assertEquals(3, customArrayList.size());
    }

    @Test
    public void shouldSizeWithNullObjects() {
        assertEquals(0, customArrayList.size());
    }

    @Test
    public void shouldIsEmpty() {
        assertTrue(customArrayList.isEmpty());
    }

    @Test
    public void shouldIsEmptyAfterClear(){
        customArrayList.add(9);
        customArrayList.add(9);
        customArrayList.add(9);
        customArrayList.clear();
        assertTrue(customArrayList.isEmpty());
    }

    @Test
    public void shouldContainsPositive() {
        customArrayList.add(9);
        customArrayList.add(29);
        customArrayList.add(39);
        assertTrue(customArrayList.contains(29));
    }

    @Test
    public void shouldContainsNegative(){
        customArrayList.add(9);
        customArrayList.add(29);
        customArrayList.add(39);
        assertFalse(customArrayList.contains(100));
    }

    @Test
    public void shouldRemovePositive() {
        customArrayList.add(9);
        customArrayList.add(29);
        customArrayList.add(39);
        assertTrue(customArrayList.remove(39));
    }

    @Test
    public void shouldRemoveNegative() {
        customArrayList.add(9);
        customArrayList.add(29);
        customArrayList.add(39);
        assertFalse(customArrayList.remove(123));
    }

    @Test
    public void shouldGetPositive(){
        customArrayList.add(9);
        customArrayList.add(29);
        customArrayList.add(39);
        assertSame(9, customArrayList.get(0));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldGetNegative(){
        customArrayList.add(9);
        customArrayList.add(29);
        customArrayList.add(39);
        customArrayList.get(100);
    }
}