package ShoppingBook.factory;



import ShoppingBook.domain.Supplier;

import java.util.Map;


public class SupplierFactory {
    public static Supplier createSupplier(Map<String,String> value, long tel)
    {
        return new Supplier.Builder().name(value.get("name")).registrationNumber(value.get("regNumber")).address(value.get("address")).telephoneNumber(tel).build();
    }
}



