package streams;


import entity.Address;
import entity.Employee;

import java.util.Comparator;
import java.util.List;

public class EmployeeService {

    public static void main(String args[]) {

        Address address1 = new Address(null, "Bangalore", "Karanataka", 560093);
        Employee e1 = new Employee(1, "Aman", 30, address1, 120000);
        Address address2 = new Address(null, "Khalilabad", "UP", 272175);
        Employee e2 = new Employee(2, "Kishan", 17, address2, 10000);
        Employee e3 = new Employee(3, "Rohan",27, address2, 70000);
        Address address3 = new Address(null, "Gorakhpur", "UP", 273001);
        Employee e4 = new Employee(4, "Karan", 28, address3, 80000);

        List<Employee> employeeList = List.of(e1, e2, e3, e4);

        List<String> sortedNames = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getName).toList();

        sortedNames.forEach(System.out::println);
    }
}
