package ru.rudnev.test.java;

import java.util.Arrays;

public class Main {

    public static int[] getSubarrayAfterLastOne(int[] array) {
        int lastOneIndex = -1;

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 1) {
                lastOneIndex = i;
                break;
            }
        }

        if (lastOneIndex == -1) {
            throw new RuntimeException("Input array does not contain any ones.");
        }

        return Arrays.copyOfRange(array, lastOneIndex + 1, array.length);
    }

    public static boolean containsOnlyOnesAndTwos(int[] array) {
        for (int num : array) {
            if (num != 1 && num != 2) {
                return false;
            }
        }

        return Arrays.stream(array).anyMatch(num -> num == 1) && Arrays.stream(array).anyMatch(num -> num == 2);
    }

    public static void main(String[] args) {
        // Тесты для первого метода
        try {
            int[] result1 = getSubarrayAfterLastOne(new int[]{1, 2, 1, 2, 2});
            System.out.println(Arrays.toString(result1));  // Результат: [2, 2]
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            getSubarrayAfterLastOne(new int[]{2, 2, 2, 2});  // Должно бросить RuntimeException
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());  // Результат: Input array does not contain any ones.
        }

        // Тесты для второго метода
        System.out.println(containsOnlyOnesAndTwos(new int[]{1, 2}));    // Результат: true
        System.out.println(containsOnlyOnesAndTwos(new int[]{1, 1}));    // Результат: false
        System.out.println(containsOnlyOnesAndTwos(new int[]{1, 3}));    // Результат: false
        System.out.println(containsOnlyOnesAndTwos(new int[]{1, 2, 2, 1}));  // Результат: true
    }
}
