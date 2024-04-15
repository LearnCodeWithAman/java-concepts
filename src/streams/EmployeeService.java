package streams;


import entity.Address;
import entity.Employee;
import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeService {

    public static void main(String args[]) {

        Address address1 = new Address("Kagadassapura", "Bangalore", "Karanataka", 560093);
        Employee e1 = new Employee(1, "Aman", 30, address1, 140000);
        Address address2 = new Address("Main Road", "Khalilabad", "UP", 272175);
        Employee e2 = new Employee(2, "Kishan", 17, address2, 10000);
        Employee e3 = new Employee(3, "Rohan",27, address2, 70000);
        Address address3 = new Address("Golghar", "Gorakhpur", "UP", 273001);
        Employee e4 = new Employee(4, "Karan", 28, address3, 80000);
        Employee e5 = new Employee(5, "Mohini", 29, address1, 110000);
        Employee e6 = new Employee(6, "Deepshikha", 29, address1, 130000);
        Employee e7 = new Employee(7, "Mohit", 30, address1, 300000);


        List<Employee> employeeList = List.of(e1, e2, e3, e4, e5, e6, e7);

        // Sort Employess by salary
        List<String> sortedNames = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getName).toList();
        System.out.println("Employees List sorted by Salary :");
        sortedNames.forEach(System.out::println);


        // Give count of employess according to their city
        System.out.println();
        System.out.println("Employee Count for each City :");
        Map<String, List<Employee>> employeeByCityMap = employeeList.stream()
                .collect(groupingBy(e -> e.getAddress().getCity()));
        Map<String, Long> countByCityMap = employeeList.stream()
                .collect(groupingBy(e -> e.getAddress().getCity(), Collectors.counting()));

        countByCityMap.entrySet().forEach(System.out::println);


        // Get Employees according to City and then Age
        System.out.println();
        System.out.println("Get Employees according to City and then Age :");
        Map<String, Map<Integer,List<Employee>>> employeeByCityThenByAgeMap = employeeList.stream()
                .collect(groupingBy(e -> e.getAddress().getCity(), groupingBy(e -> e.getAge())));

        employeeByCityThenByAgeMap.entrySet().forEach(e -> {
            System.out.println();
            System.out.println("City === " + e.getKey());
            e.getValue().entrySet().forEach(em -> {
                System.out.println("Age: " + em.getKey());
                em.getValue().forEach(System.out::println);
            });
        });

    }
}
