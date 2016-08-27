package ShoppingBook.services.Impl;


import ShoppingBook.domain.Employee;
import ShoppingBook.repository.EmployeeRepository;
import ShoppingBook.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by AbelN on 07/05/2016.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeRepository repo;


    
    public Employee findById(Long id) {
        return repo.findOne(id);
    }


    public Employee save(Employee entity) {

        return repo.save(entity);


    }


    public Employee update(Employee entity) {
        repo.save(entity);
        return entity;
    }


    public Employee delete(Employee entity) {
        repo.delete(entity);
        return entity;
    }


    public Iterable<Employee> findAll() {

        Iterable<Employee> employees;
        employees = repo.findAll();
        return employees;

    }



    public boolean isManager(long id) {
        Employee resultObject = repo.findOne(id);
        if (resultObject.getPosition().contains("Manager"))
            return true;
        else
            return false;
    }

    public boolean loggedIn(Employee entity) {
        Iterable<Employee> employees;
        employees = repo.findAll();

        for (Employee employee : employees)

        {
            if (employee.getSystemName().equalsIgnoreCase(entity.getSystemName())
                    && employee.getPassword().equalsIgnoreCase(entity.getPassword()))
                return true;

        }
        return false;
    }

    public boolean userNameExists(String username) {
        Iterable<Employee> employees;
        employees = repo.findAll();

        for (Employee employee : employees)

        {
            if (employee.getSystemName().equalsIgnoreCase(username))
                return true;

        }
        return false;
    }


    public boolean passwordValidation(String password) {

        if (password.length() >= 5)

            return true;
        else
            return false;
    }
//

}