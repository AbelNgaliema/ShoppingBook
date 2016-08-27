package ShoppingBook.repository;

import org.springframework.data.repository.CrudRepository;
import ShoppingBook.domain.Branch;


public interface BranchRepository extends CrudRepository<Branch,Long> {
}
