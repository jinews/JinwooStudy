package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtils {

    public static List<Integer> removeDuplicatesAndSort(List<Integer> input){
        return input.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
    public static List<Integer> arraysMake(int ...arrays){
        return Arrays.stream(arrays)
                .boxed()
                .collect(Collectors.toList());
    }
    public static <T> List<T> arraysMakes(T ...arrays){
        return Arrays.stream(arrays)
                .collect(Collectors.toList());
    }
}
