package ShoppingBook.repository;

import ShoppingBook.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by AbelN on 31/07/2016.
 */
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
