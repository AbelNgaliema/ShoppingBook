package ShoppingBook.repostory;

import ShoppingBook.App;
import ShoppingBook.domain.Supplier;
import ShoppingBook.factory.SupplierFactory;
import ShoppingBook.repository.SupplierRepository;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestSupplierCrud  extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    SupplierRepository repo;

    @org.testng.annotations.Test
    public void testCreate() throws Exception {

        Map<String,String> values = new HashMap<String,String>();


        values.put("regNumber","CDERIRIO");
        values.put("address", "Vic Road 58");
        values.put("name", "Ngaliema");


        //Object

        Supplier supplier = SupplierFactory.createSupplier(values,0213645214);
        // CREATE

        Supplier insertedEntity = repo.save(supplier);
        id=insertedEntity.getId();
        Assert.assertNotNull(insertedEntity);

    }

    @org.testng.annotations.Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {

        Supplier entity = repo.findOne(id);
        assertNotNull(entity);
        //  Book appointment = repository.findOne(id);
        // Assert.assertEquals(patient1 ,appointment.getPatient());
    }

    @org.testng.annotations.Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {


        Supplier entity = repo.findOne(id);

        Supplier updateEntity = new Supplier.Builder()
                .id(entity.getId())
                .copy(entity)
                .name("LOUISON")
                .build();
        repo.save(updateEntity);
        //  repository.save(newEntity);;
        Supplier newEntity = repo.findOne(id);
        Assert.assertEquals("LOUISON",newEntity.getName());

        //   Assert.assertEquals(appointment.getId(), newAppointment.getId());
        // Assert.assertEquals(patient2, newAppointment.getPatient());
    }

   // @org.testng.annotations.Test(dependsOnMethods = "testUpdate")
   /* public void testDelete() throws Exception {
        Supplier buy = repo.findOne(id);
        repo.delete(buy);
        Supplier newBuy = repo.findOne(id);
        assertNull(newBuy);
    }*/
}
