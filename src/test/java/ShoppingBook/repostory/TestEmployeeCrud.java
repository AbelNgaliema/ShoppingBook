package ShoppingBook.repostory;

import ShoppingBook.App;
import ShoppingBook.domain.Employee;
import ShoppingBook.factory.EmployeeFactory;
import ShoppingBook.repository.EmployeeRepository;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertNull;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestEmployeeCrud extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    EmployeeRepository repo;

    @org.testng.annotations.Test
    public void testCreate() throws Exception {

        Map<String,String> values = new HashMap<String,String>();


        values.put("name","Abel");
        values.put("surname", "Ngaliema");
        values.put("position", "Developer");
        values.put("password", "12345");
        values.put("systemName", "abeln");


        //Object

        Employee employee = EmployeeFactory.createEmployee(values,12000);

        assertNotNull(employee);
        // CREATE

        Employee insertedEntity = repo.save(employee);
        id=insertedEntity.getId();
        Assert.assertNotNull(insertedEntity);

    }

    @org.testng.annotations.Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {

        Employee entity = repo.findOne(id);
        assertNotNull(entity);

    }

    @org.testng.annotations.Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {


        Employee entity = repo.findOne(id);

        Employee updateEntity = new Employee.Builder()
                .id(entity.getId())
                .copy(entity)
                .position("Manager Director")
                .build();
        repo.save(updateEntity);
        //  repository.save(newEntity);;
        Employee newEntity = repo.findOne(id);
        assertNotSame(entity.getPosition(),newEntity.getPosition());


    }

    /*@org.testng.annotations.Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Employee buy = repo.findOne(id);
        repo.delete(buy);
        Employee newBuy = repo.findOne(id);
        assertNull(newBuy);
    }*/


}
