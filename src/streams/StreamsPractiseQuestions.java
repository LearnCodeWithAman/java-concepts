package streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsPractiseQuestions {

    public static void main(String[] args) {

        List<Integer> nums = List.of(1,2,3,4,5,4,1);
        List<String> fruits = List.of("cherry", "banana", "coconut", "berry", "cantaloupe");

        //1. Find the sum of list of Integers
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum = " +sum);


        //2.Given a list of integers, WAP to find maximum element using Streams
        //int max= nums.stream().max(Comparator.naturalOrder()).get();
        //Optional<Integer> max= nums.stream().max(Integer::compareTo);
        int max = nums.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println("Max = " +max);


        //3. Given a list of strings, WAP to count the number of strings starting with a specific character
        long count = fruits.stream().filter(f -> f.startsWith("c")).count();
        System.out.println("Count of Fruits starting with 'c' = " +count);


        //4. Convert a list of strings t o uppercase
        List<String> fruit = fruits.stream().map(String::toUpperCase).toList();
        fruit.forEach(System.out::println);


        //5. Given a list of integers, WAP to filter out the even numbers and get the count
        count = nums.stream().filter(n -> n%2==0).count();
        System.out.println("Count of Even numbers = " + count);


        //6. WAP to find the average of list of floating-point numbers
        List<Double> floatNums = List.of(1.1,1.2,1.3,1.4,1.5);
        double avg = floatNums.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        System.out.println("Average Value of all floating Numbers = " + avg);


        //7. Given a list of strings, WAP to concatenate all the strings
        String concatenatedString = fruits.stream().collect(Collectors.joining("::"));
        System.out.println("Concatenated Fruits : " + concatenatedString);


        //8. WAP to remove duplicate elements from a list
        System.out.println("Distinct elements : ");
        nums.stream().distinct().forEach(System.out::println);


        //9. WAP to check if all the elements in a list satisfy a given condition
        List<Integer> numbers= List.of(2,4,6,8,10);
        boolean isEven = numbers.stream().allMatch(e -> e%2==0);
        System.out.println("List is Even : " + isEven);


        List<Integer> numList = List.of(1,2,3,4,5,6,7,8,9,10);

        //10. WAP to print the square of even numbers
        System.out.println("Print square of all even numbers");
        numList.stream().filter(e->e%2==0).map(e->e*e).toList().forEach(System.out::println);

        //11. WAP to print the square of even numbers
        System.out.println("Print sum of square of all odd numbers");
        int sumSquareOdd = numList.stream().filter(e->e%2!=0).map(e->e*e).mapToInt(Integer::intValue).sum();
        System.out.println("SumSquareOdd : "+ sumSquareOdd);

        //12. Find the words present in the string more than once along with their occurrences
        String strSentence = " HI EPAM bYe EPAM goodbye EPAM welcome ePAM Hi There epAM BYE bye EPaM";
        String[] strArray = strSentence.split(" ");
        List<String> strList = Arrays.asList(strArray);
        Map<String, Long> myMap = strList.stream().map(String::toLowerCase).collect(Collectors.groupingBy(e->e, Collectors.counting()));
        myMap.forEach((key,value) -> System.out.println(key +", "+ value));


        List<String> words = Arrays.asList("apple", "banana", "orange", "apple", "kiwi", "banana", "kiwi", "kiwi");

        System.out.println("Counts the frequency of each word, and prints the word along with its count in descending order of frequency");
        //13. counts the frequency of each word, and prints the word along with its count in descending order of frequency
        Map<String, Long> wordMap = words.stream().collect(Collectors.groupingBy(e->e, Collectors.counting()));
        wordMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}
