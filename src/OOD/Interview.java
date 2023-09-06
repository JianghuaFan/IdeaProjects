package OOD;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import java.util.stream.Collectors;

import static sun.nio.cs.Surrogate.is;

public class Interview {
    public class Employee {

        private Integer employeeNumber;
        private String name;
        private Integer departmentId;
        //Standard constructor, getters and setters.

        public Employee(Integer employeeNumber, String name, Integer departmentId) {
            this.employeeNumber = employeeNumber;
            this.name = name;
            this.departmentId = departmentId;
        }

        public Integer getEmployeeNumber() {
            return employeeNumber;
        }

        public String getName() {
            return name;
        }

        public Integer getDepartmentId() {
            return departmentId;
        }
    }
    private List<Employee> buildEmployeeList() {
        return Arrays.asList(
                new Employee(1, "Mike", 1),
                new Employee(2, "John", 1),
                new Employee(3, "Mary", 1),
                new Employee(4, "Joe", 2),
                new Employee(5, "Nicole", 2),
                new Employee(6, "Alice", 2),
                new Employee(7, "Bob", 3),
                new Employee(8, "Scarlett", 3));
    }

    private List<String> employeeNameFilter() {
        return Arrays.asList("Alice", "Mike", "Bob");
    }

    @Test
    public void givenEmployeeList_andNameFilterList_thenObtainFilteredEmployeeList_usingForEachLoop() {
        List<Employee> filteredList = new ArrayList<>();
        List<Employee> originalList = buildEmployeeList();
        List<String> nameFilter = employeeNameFilter();

        for (Employee employee : originalList) {
            for (String name : nameFilter) {
                if (employee.getName().equals(name)) {
                    filteredList.add(employee);
                    // break;
                }
            }
        }
        assert(filteredList.size() == nameFilter.size());
    }
    // map foreach
    // filter
    public static void main(String[] args){
        List<String> strs = new ArrayList<>();
        strs.add("Tom");
        strs.add("Tony");
        strs.add("Andy");

//        List<String> strs1 = strs.stream().filter(s -> s.length() > 3).collect(Collectors.toList());
        strs.stream().map(String ::toUpperCase).forEach(System.out::println);
//        List<String> strs2 = strs.stream().map(String:: toUpperCase).forEach(System.out::println);
//        System.out.println(strs1);
        Interview interview = new Interview();
        interview.givenEmployeeList_andNameFilterList_thenObtainFilteredEmployeeList_usingForEachLoop();
    }
}
