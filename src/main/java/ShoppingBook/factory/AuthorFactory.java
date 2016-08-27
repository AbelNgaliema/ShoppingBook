package ShoppingBook.factory;


import ShoppingBook.domain.Author;

import java.util.Map;


public class AuthorFactory {

    public static Author createAuthor(Map<String,String> value){
        return new Author.Builder().surname(value.get("surname")).name(value.get("name")).build();
    }
}
