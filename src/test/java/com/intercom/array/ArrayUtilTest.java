package com.intercom.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayUtilTest {

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputsThrowException() throws Exception {
        ArrayUtil.flatten(new Object[]{1 , 2, "Random String", 4});
    }

    @Test(expected = NullPointerException.class)
    public void nullInputThrowsException() throws Exception {
        ArrayUtil.flatten(null);
    }

    @Test
    public void emptyArrayReturnsEmptyValue() throws Exception {
        assertArrayEquals("Array returned on flattening empty array is not empty",
                new int[]{},
                ArrayUtil.flatten(new Integer[]{}));
    }

    @Test
    public void flattenUnNestedArray() throws Exception {
        Object[] input = {1, 2, 3, 4, 5};
        assertArrayEquals("Flattening flattened arrays yields unexpected results",
                new int[]{1, 2, 3, 4, 5},
                ArrayUtil.flatten(input));
    }

    @Test
    public void flattenOneLevelNestedArray() throws Exception {
        Object[] input = {1 , 2, new Object[]{3, 4, 5}, 6};
        assertArrayEquals("Flattening one level nested arrays yields unexpected results",
                new int[]{1, 2, 3, 4, 5, 6},
                ArrayUtil.flatten(input));
    }

    @Test
    public void flattenTwoLevelNestedArray() throws Exception {
        Object[] input = {1 , 2, new Object[]{3, 4, new Object[]{5}, 6}, 7};
        assertArrayEquals("Flattening two level nested arrays yields unexpected results",
                new int[]{1, 2, 3, 4, 5, 6, 7},
                ArrayUtil.flatten(input));
    }

    @Test
    public void flattenThreeLevelNestedArray() throws Exception {
        Object[] input = new Object[]{1, 2, new Object[]{3, new Object[]{4, 5}}, 6 ,7};
        assertArrayEquals("Flattening three level nested arrays yields unexpected results",
                new int[]{1, 2, 3, 4, 5, 6, 7},
                ArrayUtil.flatten(input));
    }

    @Test
    public void flattenSampleInput() throws Exception {
        Object[] input = new Object[]{new Object[]{1, 2, new Object[]{3}}, 4};
        assertArrayEquals("Flattening sample input level nested arrays yields unexpected results",
                new int[]{1, 2, 3, 4},
                ArrayUtil.flatten(input));
    }


}