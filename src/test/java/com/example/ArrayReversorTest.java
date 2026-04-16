package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArrayReversorTest {

    @Mock
    private ArrayFlattenerService mockFlattenerService;

    private ArrayReversor reversor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        reversor = new ArrayReversor(mockFlattenerService);
    }

    @Test
    public void testReverseArrayWithValidInput() {
        int[][] nestedArray = {{1, 3}, {0}, {4, 5, 9}};
        int[] flattenedArray = {1, 3, 0, 4, 5, 9};
        int[] expected = {9, 5, 4, 0, 3, 1};

        when(mockFlattenerService.flattenArray(nestedArray)).thenReturn(flattenedArray);

        int[] result = reversor.reverseArray(nestedArray);

        assertArrayEquals("Reversed array should match expected output", expected, result);

        verify(mockFlattenerService, times(1)).flattenArray(nestedArray);
        verifyNoMoreInteractions(mockFlattenerService);
    }

    @Test(expected = NullPointerException.class)
    public void testReverseArrayWithNullInput() {
        reversor.reverseArray(null);

        verify(mockFlattenerService, never()).flattenArray(null);
    }

    @Test
    public void testReverseArrayVerifyServiceInvocation() {
        int[][] nestedArray = {{1, 2}, {3}};
        int[] flattenedArray = {1, 2, 3};
        int[] expected = {3, 2, 1};

        when(mockFlattenerService.flattenArray(nestedArray)).thenReturn(flattenedArray);

        int[] result = reversor.reverseArray(nestedArray);

        assertArrayEquals("Reversed array should match expected output", expected, result);

        verify(mockFlattenerService).flattenArray(nestedArray);
    }
}
