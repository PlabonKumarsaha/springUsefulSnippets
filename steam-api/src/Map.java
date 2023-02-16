import employees.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Map {

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
    //for each
    employeeList.stream().forEach(employee -> System.out.println(employee));

    //map
    List<Employee> increasedSal = (List<Employee>) employeeList.stream().map(employee -> new Employee(
        employee.getFirstName(),
        employee.getLastName(),
        employee.getSalary()*1.10,
        employee.getProjects()
    )).collect(Collectors.toList());
    System.out.println("incremented");
    increasedSal.stream().forEach(employee -> System.out.println(employee));


  }
}
