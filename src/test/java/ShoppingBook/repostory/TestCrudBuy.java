package ShoppingBook.repostory;

import ShoppingBook.domain.*;
import ShoppingBook.factory.*;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import ShoppingBook.App;
import ShoppingBook.repository.BuyRepository;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudBuy extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    BuyRepository repo;


    @org.testng.annotations.Test
    public void testCreate() throws Exception {

        Map<String,String> values = new HashMap<String,String>();
        values.put("name","Boniface");
        values.put("surname", "Kabaso");
        Author author = AuthorFactory.createAuthor(values);

        //Publisher created

        Map<String,String> values2 =  new HashMap<String,String>();
        values2.put("name", "SkyRock");
        values2.put("city","Cape Town");
        values2.put("registration","c123idfr");

        Publisher publisher = PublisherFactory.createPublisher(values2);


        //Book Object
        Map<String,String> values3 =  new HashMap<String,String>();
        values3.put("isbn", "88878-4445544");
        values3.put("title","Testing");;
        Book book = BookFactory.creaBook(1,values3, 2014, 23, 120.00, publisher, author);

        //Customer Address object created
        Map<String, String> values4 = new HashMap<String,String>();
        values4.put("address", "58 Victoria Rd. Southfield");
        values4.put("city", "Cape Town");

        CustomerAddress customerAddress = CustomerAddressFactory.createCustomerAddress(values4, 7800);

        //PersonalInfromation Object Created
        Map<String, String> values1 = new HashMap<String,String>();
        values1.put("name","Abel");
        values1.put("surname","Ngaliema");
        values1.put("idNumber","12223944");
        values1.put("email", "abeln@dipar.co.za");

        PersonalInformation personalInformation = PersonalInformationFactory.createPersonalInformation(values1, 02100000, 0210000000);


        Customer customer = CustomerFactory.createCustomer(customerAddress, personalInformation);
        Map<String, String> values5 = new HashMap<String,String>();
        values5.put("mode","Cash");
        values5.put("cashier","Bingo");

        //Buy object
        Buy buy = BuyFactory.createBuy(1,values5,book.getTitle(),customer.getPersonalInformation().getName());
        // CREATE

        Buy insertedEntity = repo.save(buy);
        id=insertedEntity.getId();
        Assert.assertNotNull(insertedEntity);

    }

    @org.testng.annotations.Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {

        Buy entity = repo.findOne(id);
        assertNotNull(entity);
        //  Book appointment = repository.findOne(id);
        // Assert.assertEquals(patient1 ,appointment.getPatient());
    }

    @org.testng.annotations.Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {

        Buy entity = repo.findOne(id);

        Buy updateEntity = new Buy.Builder()
                .id(entity.getId())
                .copy(entity)
                .mode("Cash")
                .build();
        repo.save(updateEntity);
        //  repository.save(newEntity);;
        Buy newEntity = repo.findOne(id);
        assertEquals("Cash",newEntity.getMode());

        //   Assert.assertEquals(appointment.getId(), newAppointment.getId());
        // Assert.assertEquals(patient2, newAppointment.getPatient());
    }

  /*  @org.testng.annotations.Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Buy buy = repo.findOne(id);
        repo.delete(buy);
        Buy newBuy = repo.findOne(id);
        assertNull(newBuy);
    }*/


}
