package com.example;

public class ArrayFlattener {

    public int[] flattenArray(int[][] nestedArray) {
        if (nestedArray == null) {
            throw new NullPointerException("Input array cannot be null");
        }

        int totalElements = 0;
        for (int[] row : nestedArray) {
            if (row != null) {
                totalElements += row.length;
            }
        }

        int[] flattenedArray = new int[totalElements];
        int index = 0;

        for (int[] row : nestedArray) {
            if (row != null) {
                for (int element : row) {
                    flattenedArray[index++] = element;
                }
            }
        }

        return flattenedArray;
    }
}
