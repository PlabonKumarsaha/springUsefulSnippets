import employees.Employee;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class MinMaxReduce {

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
    Employee maxSalEmployee = employeeList
        .stream()
        .max(Comparator.comparing(Employee::getSalary))
        .orElseThrow(NoSuchElementException::new);

    System.out.println(maxSalEmployee);

    // min

    Employee minSalEmployee = employeeList
        .stream()
        .min(Comparator.comparing(Employee::getSalary))
        .orElseThrow(NoSuchElementException::new);

    System.out.println(minSalEmployee);

    // accumulate salary

    Double totalSalary = employeeList
        .stream()
        .map(employee -> employee.getSalary())
        .reduce(0.0,Double::sum);
    System.out.println("sum => "+totalSalary);

  }
}
