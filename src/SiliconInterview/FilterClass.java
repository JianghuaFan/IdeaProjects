package SiliconInterview;

import javax.xml.stream.StreamFilter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterClass {
    public static void main(String[] args) {
        List<String> inputList = Arrays.asList("RED", "BLUE", "RED", "GREEN");

        Map<String, Long> res = inputList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> result = inputList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using Stream to filter and map
        List<Integer> squaredNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)          // Keep only even numbers
                .map(n -> n * n)                 // Square each number
                .collect(Collectors.toList());   // Collect the results into a list

        System.out.println(squaredNumbers);  // Output: [4, 16, 36, 64, 100]

        // Using Stream to find the sum of all numbers
        int sum = numbers.stream()
                .reduce(0, Integer::sum);        // Sum up all numbers using reduction

        System.out.println("Sum: " + sum);  // Output: Sum: 55
    }
}
