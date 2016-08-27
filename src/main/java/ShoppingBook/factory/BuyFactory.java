package ShoppingBook.factory;


import ShoppingBook.domain.Buy;

import java.util.Map;


public class BuyFactory {

    public static Buy createBuy(long id, Map<String,String> value, String book, String customer)
    {

        return new Buy.Builder().cashier(value.get("cashier")).mode(value.get("mode")).book(book).customer(customer).build();

    }
}
