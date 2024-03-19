package streams;

import entities.Employee;

import java.util.Comparator;
import java.util.List;

public class EmployeeService {

    public static void main(String args[]) {

        Employee e1 = new Employee(1, "Aman", "Bangalore", 120000);
        Employee e2 = new Employee(2, "Kishan", "Khalilabad", 10000);
        Employee e3 = new Employee(3, "Rohan", "Khalilabad", 70000);
        Employee e4 = new Employee(4, "Karan", "Gorakhpur", 80000);

        List<Employee> employeeList = List.of(e1, e2, e3, e4);

        List<String> sortedNames = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getName).toList();

        sortedNames.forEach(System.out::println);
    }
}
