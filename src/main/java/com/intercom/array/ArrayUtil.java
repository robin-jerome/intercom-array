package com.intercom.array;

import java.util.Arrays;
import java.util.Objects;

public class ArrayUtil {

    // Private constructor as this is a static factory utility
    private ArrayUtil() {
        // Prevent creation through reflection or serialization/deserialization
        throw new AssertionError("Instances of static factory are not supposed to be instantiated");
    }

    /**
     * @param nestedArray   the nested array which can contain integers or arrays of integers
     * @return flattened array created from the nested array
     * @throws NullPointerException if {@code nestedArray} is {@code null}
     * @throws IllegalArgumentException if {@code nestedArray} contains entries other than integers or integer arrays
     */
    public static int[] flatten(Object[] nestedArray) {
        Objects.requireNonNull(nestedArray);
        int index = 0;
        int[] flattenedArray = new int[1000];
        for (int i = 0; i < nestedArray.length; i++) {
            if (nestedArray[i] instanceof Integer) {
                flattenedArray[index++] = (Integer) nestedArray[i];
            } else if (nestedArray[i] instanceof Object[]){
                for (int abc : flatten((Object[]) nestedArray[i])) {
                    flattenedArray[index++] = abc;
                }
            } else {
                throw new IllegalArgumentException("Array should contain either numbers or array of numbers");
            }
        }
        return Arrays.copyOfRange(flattenedArray, 0, index);
    }
}
