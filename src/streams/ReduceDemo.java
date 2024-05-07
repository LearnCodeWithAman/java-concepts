package streams;

import java.util.Arrays;
import java.util.List;

public class ReduceDemo {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        int sum = numbers.stream().reduce(0, (subtotal, element) -> subtotal + element);
        //int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum : " +sum);

        List<String> letters = Arrays.asList("a","b","c","d","e");
        String result = letters.stream().
                reduce("", (partialString, element) -> partialString + element);
        //String result = letters.stream().reduce("", String::concat);
        System.out.println("Result : " +result);

        List<Integer> ages = Arrays.asList(23,45,11,35,17,1,2,3,4,5,6,7,8,9);
        int computedAges = ages.parallelStream().reduce(0, (a,b) -> a+b, Integer::sum);
        System.out.println("ComputedAges : " +computedAges);

        
    }
}
