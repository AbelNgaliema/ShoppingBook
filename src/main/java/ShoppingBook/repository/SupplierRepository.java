package ShoppingBook.repository;

import org.springframework.data.repository.CrudRepository;
import ShoppingBook.domain.Supplier;


public interface SupplierRepository extends CrudRepository<Supplier,Long> {
}
