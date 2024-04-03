package streams;

import java.util.stream.Stream;

public class Sum {

  public static void main(String args[]) {

    System.out.println(Stream.of(1,2,3,4,5,6).mapToInt(i->i).sum());

  }
}
