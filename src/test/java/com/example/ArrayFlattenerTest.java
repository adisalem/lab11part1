package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayFlattenerTest {

    private ArrayFlattener flattener;

    @Before
    public void setUp() {
        flattener = new ArrayFlattener();
    }

    @Test
    public void testFlattenArrayWithValidInput() {
        int[][] nestedArray = {{1, 3}, {0}, {4, 5, 9}};
        int[] expected = {1, 3, 0, 4, 5, 9};

        int[] result = flattener.flattenArray(nestedArray);

        assertArrayEquals("Flattened array should match expected output", expected, result);
    }

    @Test(expected = NullPointerException.class)
    public void testFlattenArrayWithNullInput() {
        flattener.flattenArray(null);
    }
}
