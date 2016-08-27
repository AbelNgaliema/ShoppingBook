package ShoppingBook.service;

import ShoppingBook.domain.Book;
import ShoppingBook.factory.AuthorFactory;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import ShoppingBook.App;
import ShoppingBook.domain.Author;
import ShoppingBook.domain.Publisher;
import ShoppingBook.factory.BookFactory;
import ShoppingBook.factory.PublisherFactory;
import ShoppingBook.repository.BookRepository;
import ShoppingBook.services.Impl.BookServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestBookService extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    private BookRepository repository;
    @Autowired
    private BookServiceImpl service;
    @org.testng.annotations.Test
    public void testCreate() throws Exception {

        Map<String,String> values = new HashMap<String,String>();
        values.put("name","Bonifacs");
        values.put("surname", "Kabaso");
        Author author = AuthorFactory.createAuthor(values);
        //  Long id;

        //Publisher created

        Map<String,String> values2 =  new HashMap<String,String>();
        values2.put("name", "SkyRock");
        values2.put("city","Cape Town");
        values2.put("registration","c123idfr");

        Publisher publisher = PublisherFactory.createPublisher(values2);


        //Book Object
        Map<String,String> values3 =  new HashMap<String,String>();
        values3.put("isbn", "88878-4445544");
        values3.put("title","Testing");
        Book book = BookFactory.creaBook(2,values3,2014,23,120.00,publisher,author);
        // CREATE

       // Book insertedEntity = repository.save(book);
       // id=insertedEntity.getId();
        Assert.assertSame(true, service.duplicateCheck("Abel"));
    }



}
