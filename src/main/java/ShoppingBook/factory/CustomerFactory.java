package ShoppingBook.factory;


import ShoppingBook.domain.Customer;
import ShoppingBook.domain.CustomerAddress;
import ShoppingBook.domain.PersonalInformation;


public class CustomerFactory {

    public static Customer createCustomer(CustomerAddress customerAddress, PersonalInformation personalInformation)
    {
        return new Customer.Builder().CustomerAddress(customerAddress).PersonalInformation(personalInformation).build();
    }
}
