package ShoppingBook.services;


import ShoppingBook.domain.Employee;


public interface EmployeeService {

    boolean isManager(long id);
    boolean loggedIn(Employee employee);
    boolean userNameExists(String name);
    boolean passwordValidation(String password);
}
