import employees.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShortCircuit {

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
    List<Employee> shorCircuit = employeeList
        .stream()
        .skip(1)
        .limit(2)
        .collect(Collectors.toList());

    System.out.println(shorCircuit);
  }
}
