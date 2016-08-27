package ShoppingBook.repostory;



import ShoppingBook.App;
import ShoppingBook.domain.Author;
import ShoppingBook.domain.Book;
import ShoppingBook.domain.Publisher;
import ShoppingBook.factory.AuthorFactory;
import ShoppingBook.factory.BookFactory;
import ShoppingBook.factory.PublisherFactory;
import ShoppingBook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudBook extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    BookRepository repository;

    @Test
    public void testCreate()throws Exception {
        // BookRepository repo = new BookRepositoryImpl(this.getContext());
        Map<String,String> values = new HashMap<String,String>();
        values.put("name","Boniface");
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

        Book insertedEntity = repository.save(book);
        id=insertedEntity.getId();
        assertNotNull(insertedEntity);

        //READ ALL
        // Set<Book> books = repo.findAll();
        // Assert.assertTrue(TAG+" READ ALL",books.size()>0);

        //READ ENTITY
        //  Book entity = repo.findById(id);
        //   Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        // Book updateEntity = new Book.Builder()
        //   .id(entity.getId())
        //   .copy(entity)
        //   .title("ABEL")
        //   .build();
        // repo.update(updateEntity);
        //Book newEntity = repo.findById(id);
        // assertEquals(TAG+ " UPDATE ENTITY","ABEL",newEntity.getTitle());

        // DELETE ENTITY
        //   repo.delete(updateEntity);
        //  Book deletedEntity = repo.findById(id);
        //  Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

    @org.testng.annotations.Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {

        Book entity = repository.findOne(id);
        assertNotNull(entity);
        //  Book appointment = repository.findOne(id);
        // Assert.assertEquals(patient1 ,appointment.getPatient());
    }

    @org.testng.annotations.Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {

        Book entity = repository.findOne(id);
        //UPDATE ENTITY
        Book updateEntity = new Book.Builder()
                .id(entity.getId())
                .copy(entity)
                .title("ABEL")
                .build();
        repository.save(updateEntity);
        Book newEntity = repository.findOne(id);
        assertEquals("ABEL",newEntity.getTitle());

        //   Assert.assertEquals(appointment.getId(), newAppointment.getId());
        // Assert.assertEquals(patient2, newAppointment.getPatient());
    }

   /* @org.testng.annotations.Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Book book = repository.findOne(id);
        repository.delete(book);
        Book newBook = repository.findOne(id);
        assertNull(newBook);
    }*/

    /*@Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Book book = rep.findOne(id);
        rep.delete(book);
        Book b = rep.findOne(id);
        Assert.assertNull(b);*/

}
