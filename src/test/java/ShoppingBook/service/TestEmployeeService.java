package ShoppingBook.service;

import ShoppingBook.App;
import ShoppingBook.domain.Employee;
import ShoppingBook.factory.EmployeeFactory;
import ShoppingBook.repository.EmployeeRepository;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import ShoppingBook.services.Impl.EmployeeServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by AbelN on 03/08/2016.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestEmployeeService extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    private EmployeeRepository repo;
    @Autowired
    private EmployeeServiceImpl service;

    @org.testng.annotations.Test
    public void testCreate() throws Exception {

        Map<String,String> values = new HashMap<String,String>();


        values.put("name","Abel_1");
        values.put("surname", "Ngaliema");
        values.put("position", "Developer");
        values.put("password", "12345");
        values.put("systemName", "abeln");


        //Object

        Employee employee = EmployeeFactory.createEmployee(values,12000);

        assertNotNull(employee);
        // CREATE

        Employee insertedEntity = service.save(employee);
        id=insertedEntity.getId();
        Assert.assertNotNull(insertedEntity);

    }

    @org.testng.annotations.Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {

        Employee entity =    service.findById(id);
        assertNotNull(entity);
        //  Book appointment = repository.findOne(id);
        // Assert.assertEquals(patient1 ,appointment.getPatient());
    }

    @org.testng.annotations.Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {


        Employee entity = repo.findOne(id);

        Employee updateEntity = new Employee.Builder()
                .id(entity.getId())
                .copy(entity)
                .position("Manager Director")
                .build();
        service.update(updateEntity);
        //  repository.save(newEntity);;
        Employee newEntity = repo.findOne(id);
        assertNotSame(entity.getPosition(),newEntity.getPosition());

        //   Assert.assertEquals(appointment.getId(), newAppointment.getId());
        // Assert.assertEquals(patient2, newAppointment.getPatient());
    }


    @org.testng.annotations.Test(dependsOnMethods = "testUpdate")
    public void testIsManager() throws Exception {
        Employee buy = repo.findOne(id);

        assertEquals(true, service.isManager(id));
    }
    @org.testng.annotations.Test(dependsOnMethods = "testIsManager")
    public void testLogged() throws Exception {
        Employee buy = repo.findOne(id);

        assertEquals(true, service.loggedIn(buy));
    }
    @org.testng.annotations.Test(dependsOnMethods = "testLogged")
    public void testUserExist() throws Exception {
        Employee buy = repo.findOne(id);

        assertEquals(true, service.userNameExists(buy.getSystemName()));
    }
    @org.testng.annotations.Test(dependsOnMethods = "testUserExist")
    public void testPassword() throws Exception {
        Employee buy = repo.findOne(id);

        assertEquals(true, service.passwordValidation(buy.getPassword()));
    }
}
