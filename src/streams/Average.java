package streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Average {

  public static void main(String args[]){

    Integer[] intarr = {50,120,70,80,90};
    List<Integer> intList = Arrays.asList(intarr);

    OptionalDouble avg = intList.stream().mapToInt(i->i).filter(i-> i>100).average();

    System.out.println(avg.getAsDouble());
  }
}
