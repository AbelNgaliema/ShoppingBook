package ShoppingBook.factory;


import ShoppingBook.domain.Book;
import ShoppingBook.domain.Author;
import ShoppingBook.domain.Publisher;

import java.util.Map;


public class BookFactory {

    public static Book creaBook(long id, Map<String,String> value, int year, int qty, double price, Publisher publisher, Author author){
        return new Book.Builder().isbnNumber(value.get("isbn")).title(value.get("title")).year(year).quantity(qty).price(price).author(author).build();
    }
}
