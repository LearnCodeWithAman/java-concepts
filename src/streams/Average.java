package streams;

import entity.Address;
import entity.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Average {

  public static void main(String args[]){

    Integer[] intarr = {50,120,70,80,90};
    List<Integer> intList = Arrays.asList(intarr);
    OptionalDouble avg = intList.stream().mapToInt(i->i).filter(i-> i>100).average();
    System.out.println("Avegare of Int Numbers = "+ avg.getAsDouble());


    Address address1 = new Address(null, "Bangalore", "Karanataka", 560093);
    Employee e1 = new Employee(1, "Aman", 30, address1, 120000);
    Address address2 = new Address(null, "Khalilabad", "UP", 272175);
    Employee e2 = new Employee(2, "Kishan", 17, address2, 10000);
    Employee e3 = new Employee(3, "Rohan",28, address2, 70000);
    Address address3 = new Address(null, "Gorakhpur", "UP", 273001);
    Employee e4 = new Employee(4, "Karan", 28, address3, 80000);


    List<Employee> employeeList = List.of(e1,e2,e3,e4);

    List<Integer> age = employeeList.stream().map(e -> e.getAge()).distinct().collect(Collectors.toList());

    age.forEach(System.out::println);

    Map<Integer, Double> map = new HashMap<Integer, Double>();
    Double averageSalary = 0.0;
    for(int i : age) {

      averageSalary = employeeList.stream().filter(e -> e.getAge() == i).
              mapToDouble(e -> e.getSalary()).average().getAsDouble();
      map.put(i, averageSalary);
    }

    map.forEach((k,v) -> System.out.println(k +" - "+ v));

  }
}
