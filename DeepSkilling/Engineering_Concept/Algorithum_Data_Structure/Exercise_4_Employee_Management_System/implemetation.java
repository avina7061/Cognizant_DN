public class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "ID: " + employeeId + " | Name: " + name + " | Position: " + position + " | Salary: $" + salary;
    }
}

public class EmployeeManager {
    private Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size >= employees.length) {
            System.out.println("Error: System capacity reached. Cannot add more employees.");
            return;
        }
        employees[size] = employee;
        size++;
        System.out.println("Employee added successfully.");
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employee records found.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(String employeeId) {
        int targetIndex = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                targetIndex = i;
                break;
            }
        }

        if (targetIndex == -1) {
            System.out.println("Error: Employee not found.");
            return;
        }

        for (int i = targetIndex; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[size - 1] = null;
        size--;
        System.out.println("Employee record deleted successfully.");
    }
}
public class Main {
    public static void main(String[] args) {
        EmployeeManager em = new EmployeeManager(5);

        Employee e1 = new Employee("E001", "John Doe", "Software Engineer", 85000);
        Employee e2 = new Employee("E002", "Jane Smith", "Project Manager", 95000);
        Employee e3 = new Employee("E003", "Bob Johnson", "QA Analyst", 70000);

        em.addEmployee(e1);
        em.addEmployee(e2);
        em.addEmployee(e3);

        System.out.println("\n--- All Employee Records ---");
        em.traverseEmployees();

        System.out.println("\n--- Searching for E002 ---");
        Employee found = em.searchEmployee("E002");
        System.out.println(found != null ? "Found: " + found : "Not Found");

        System.out.println("\n--- Deleting Employee E002 ---");
        em.deleteEmployee("E002");

        System.out.println("\n--- Inventory After Deletion ---");
        em.traverseEmployees();
    }
}