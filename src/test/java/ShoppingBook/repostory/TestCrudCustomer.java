package ShoppingBook.repostory;

import ShoppingBook.domain.Customer;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import ShoppingBook.App;
import ShoppingBook.domain.CustomerAddress;
import ShoppingBook.domain.PersonalInformation;
import ShoppingBook.factory.CustomerAddressFactory;
import ShoppingBook.factory.CustomerFactory;
import ShoppingBook.factory.PersonalInformationFactory;
import ShoppingBook.repository.CustomerRepository;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudCustomer extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    CustomerRepository repo;

    @Test
    public void testCreate() throws Exception{

        Map<String, String> values = new HashMap<String,String>();
        values.put("address", "58 Victoria Rd. Southfield");
        values.put("city", "Cape Town");

        CustomerAddress customerAddress = CustomerAddressFactory.createCustomerAddress(values, 7800);

        //PersonalInfromation Object Created
        Map<String, String> values1 = new HashMap<String,String>();
        values1.put("name","Abel");
        values1.put("surname","Ngaliema");
        values1.put("idNumber","12223944");
        values1.put("email", "abeln@dipar.co.za");

        PersonalInformation personalInformation = PersonalInformationFactory.createPersonalInformation(values1, 02100000, 0210000000);


        Customer customer = CustomerFactory.createCustomer(customerAddress,personalInformation);

        Customer insertedEntity = repo.save(customer);
        id=insertedEntity.getId();
        Assert.assertNotNull(insertedEntity);

        //READ ALL



    }
    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {

        Customer entity = repo.findOne(id);
        assertNotNull(entity);
        //  Book appointment = repository.findOne(id);
        // Assert.assertEquals(patient1 ,appointment.getPatient());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {




        Customer entity = repo.findOne(id);

        Customer updateEntity = new Customer.Builder()
                .id(entity.getId())
                .copy(entity)
                .build();
        repo.save(updateEntity);
        //  repository.save(newEntity);;
        Customer newEntity = repo.findOne(id);
        assertEquals(entity.getCustomerAddress().getCity(),newEntity.getCustomerAddress().getCity());

        //   Assert.assertEquals(appointment.getId(), newAppointment.getId());
        // Assert.assertEquals(patient2, newAppointment.getPatient());
    }

   /* @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Customer buy = repo.findOne(id);
        repo.delete(buy);
        Customer newBuy = repo.findOne(id);
        assertNull(newBuy);
    }*/
}
