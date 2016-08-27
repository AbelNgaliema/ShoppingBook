package ShoppingBook.factory;



import ShoppingBook.domain.CustomerAddress;

import java.util.Map;


public class CustomerAddressFactory {

    public static CustomerAddress createCustomerAddress(Map<String,String> value, int postalCode)
    {
        return  new CustomerAddress.Builder().address(value.get("address")).city(value.get("city")).postalCode(postalCode).build();
    }
}

