import employees.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

  static List<Employee> employeeList = new ArrayList<>();
  static {
    employeeList.add(new Employee("Plabon","Saha",5000.0
        ,List.of("Proj1","proj2","proj3")));
    employeeList.add(new Employee("Nafiz","Rahman",8000.0
        ,List.of("Proj1","proj2")));
    employeeList.add(new Employee("Tonmoy","Saha",6000.0
        ,List.of("Proj1","proj2","proj4")));
  }
  public static void main(String[] args) {

    employeeList.stream().forEach(employee -> System.out.println(employee));

    //filter
    // case - increment sal of emps who have sal more then 50000

    List<Employee> updatedFilterSalary = employeeList.stream()
        .filter(employee -> employee.getSalary() > 5000.0)
        .map(employee -> new Employee(employee.getFirstName(),
            employee.getLastName(),
            employee.getSalary()*1.10,
            employee.getProjects())).collect(Collectors.toList());

    System.out.println("updatedFilterSalary");
    updatedFilterSalary.stream().forEach(employee -> System.out.println(employee));

    // find first
    Employee findFirst = employeeList.stream()
        .filter(employee -> employee.getSalary() > 7000.0)
        .findFirst().orElse(null);
    System.out.println("Find first or null");
    System.out.println(findFirst);
  }
}
