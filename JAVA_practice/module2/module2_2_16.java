// Auto-generated file
class Member {
    String name;
    int age;
    String phoneNumber;
    String address;
    double salary;

    public void printSalary() {
        System.out.println("Salary: " + salary);
    }
}

class Employee extends Member {
    String specialization;
}

class Manager extends Member {
    String department;
}

public class module2_2_16 {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.name = "John Smith";
        emp.age = 30;
        emp.phoneNumber = "555-0123";
        emp.address = "123 Main St";
        emp.salary = 50000;
        emp.specialization = "Software Development";

        Manager mgr = new Manager();
        mgr.name = "Jane Doe";
        mgr.age = 45;
        mgr.phoneNumber = "555-4567";
        mgr.address = "456 Oak Ave";
        mgr.salary = 80000;
        mgr.department = "Engineering";

        System.out.println("Employee Details:");
        System.out.println("Name: " + emp.name);
        System.out.println("Age: " + emp.age);
        System.out.println("Phone: " + emp.phoneNumber);
        System.out.println("Address: " + emp.address);
        System.out.println("Specialization: " + emp.specialization);
        emp.printSalary();

        System.out.println("\nManager Details:");
        System.out.println("Name: " + mgr.name);
        System.out.println("Age: " + mgr.age);
        System.out.println("Phone: " + mgr.phoneNumber);
        System.out.println("Address: " + mgr.address);
        System.out.println("Department: " + mgr.department);
        mgr.printSalary();
    }
}
