package ShoppingBook.services.Impl;


import ShoppingBook.domain.Buy;
import ShoppingBook.repository.BranchRepository;
import ShoppingBook.repository.BuyRepository;
import ShoppingBook.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by AbelN on 09/05/2016.
 */
@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    BranchRepository repoBranch;
    @Autowired
    BuyRepository repoBuy;
    private static CustomerServiceImpl service = null;





    public boolean crossValidation(String name) {
        //The record will not deleted. Because it is being used in the other
        //table
        Iterable<Buy> buys;
        buys =   repoBuy.findAll();

        for (Buy buy : buys)
        {
            if (buy.getCustomer().trim().equalsIgnoreCase(name))
                return true;
        }
        return false;

    }

}
