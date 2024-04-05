package collections;

import entity.Address;
import entity.Employee;

import java.util.ArrayList;

public class Array_List {

    public static void main(String[] args) {

        Address address1 = new Address("Motinagar South", "Khalilabad", "Uttar Pradesh", 272175);
        Employee e1 = new Employee(1, "Aman", 30, address1, 150000);

        Address address2 = new Address("Attaullahpur", "Lalganj", "Bihar", 844121);
        Employee e2 = new Employee(2, "Mohini", 29, address2, 100000);

        Address address3 = new Address("Kaggadaspura", "Bangalore", "Karanataka", 560093);
        Employee e3 = new Employee(3, "Mohit", 35, address3, 250000);

        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);

        employeeList.stream().filter(e->e.getSalary()>110000).map(Employee::getName).forEach(System.out::println);
    }
}
