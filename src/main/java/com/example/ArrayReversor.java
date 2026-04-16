package com.example;

public class ArrayReversor {

    private ArrayFlattenerService flattenerService;

    public ArrayReversor(ArrayFlattenerService flattenerService) {
        this.flattenerService = flattenerService;
    }

    public int[] reverseArray(int[][] nestedArray) {
        if (nestedArray == null) {
            throw new NullPointerException("Input array cannot be null");
        }

        int[] flattenedArray = flattenerService.flattenArray(nestedArray);

        int[] reversedArray = new int[flattenedArray.length];
        for (int i = 0; i < flattenedArray.length; i++) {
            reversedArray[i] = flattenedArray[flattenedArray.length - 1 - i];
        }

        return reversedArray;
    }
}
