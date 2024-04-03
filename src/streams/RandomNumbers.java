package streams;

import java.util.Random;


class RandomNumbers {

  public static void main(String args[]) {

    Random random = new Random();
    // List<Integer> list =
    random.ints().limit(6).sorted().forEach(System.out::println);

    //list.forEach(System.out::println);
  }
}
