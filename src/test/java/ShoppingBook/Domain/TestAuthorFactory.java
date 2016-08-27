package ShoppingBook.Domain;


import junit.framework.TestCase;
import ShoppingBook.domain.Author;
import ShoppingBook.factory.AuthorFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AbelN on 15/04/2016.
 */
public class TestAuthorFactory extends TestCase {

   // @Test
    public void testCreate()
    {
        Map<String,String> values = new HashMap<String,String>();
        values.put("name","Boniface");
        values.put("surname", "Kabaso");
        Author author = AuthorFactory.createAuthor(values);

        assertEquals("Boniface", author.getName());
        assertEquals("Kabaso", author.getSurname());



    }
   // @Test
    public void testUpdate()
    {
        Map<String,String> values = new HashMap<String,String>();
        values.put("name","Hillary");
        values.put("", "Clinton");
        Author author = AuthorFactory.createAuthor(values);

        Author newAuthor = new Author.Builder().copy(author).surname("Golderbasehv").build();

        assertEquals("Hillary", newAuthor.getName());
        assertEquals("Golderbasehv", newAuthor.getSurname());

    }

}

