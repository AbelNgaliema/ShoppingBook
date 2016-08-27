package ShoppingBook.factory;



import ShoppingBook.domain.Employee;

import java.util.Map;


public class EmployeeFactory {
    public static Employee createEmployee(Map<String,String> value, double salary)
    {
        return new Employee.Builder().name(value.get("name")).position(value.get("position")).surname(value.get("surname")).password(value.get("password")).systemName(value.get("systemName")).salary(salary).build();
    }
}
