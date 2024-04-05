package entity;

public class Employee {

    private int employeeId;
    private String name;
    private int age;
    private Address address;
    private long salary;

    public Employee(int employeeId, String name, int age, Address address, long salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
