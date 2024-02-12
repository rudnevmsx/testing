package ru.rudnev.test.java;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void getSubarrayAfterLastOne() {
        int[] input1 = {0, 1, 2, 3, 1, 4, 5};
        int[] result1 = Main.getSubarrayAfterLastOne(input1);
        int[] expected1 = {4, 5};
        assertArrayEquals(expected1, result1);

        int[] input2 = {0, 2, 3};
        try {
            Main.getSubarrayAfterLastOne(input2);
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals("Input array does not contain any ones.", e.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void containsOnlyOnesAndTwos() {// Test case 1: Array with only ones and twos
        int[] input1 = {1, 2, 1, 2, 1, 2};
        assertTrue(Main.containsOnlyOnesAndTwos(input1));

        int[] input2 = {1, 2, 3, 4, 5};
        assertFalse(Main.containsOnlyOnesAndTwos(input2));

        int[] input3 = {1, 1, 1};
        assertTrue(Main.containsOnlyOnesAndTwos(input3));

        int[] input4 = {2, 2, 2};
        assertTrue(Main.containsOnlyOnesAndTwos(input4));
    }
}