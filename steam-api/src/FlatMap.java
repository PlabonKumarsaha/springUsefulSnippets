import employees.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {

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

    String projects = employeeList
        .stream()
        .map(employee -> employee.getProjects())
        .flatMap(strings -> strings.stream())
        .collect(Collectors.joining(","));

    System.out.println("projs ==> "+projects);



  }
}
