package ShoppingBook.repostory;

import ShoppingBook.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import ShoppingBook.domain.Branch;
import ShoppingBook.factory.BranchFactory;
import ShoppingBook.repository.BranchRepository;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;


@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestBranchRepository  extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    BranchRepository repo;
    @Test
    public void testCreate() throws Exception {

        Map<String,String> values = new HashMap<String,String>();


        values.put("manager","Abel");
        values.put("address", "Victoria Road");

        Branch branch = BranchFactory.createBranch(values,021363252);

        Branch insertedEntity = repo.save(branch);
        id=insertedEntity.getId();
        assertNotNull(insertedEntity);

    }

    @org.testng.annotations.Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {

        Branch entity = repo.findOne(id);
        assertNotNull(entity);
        //  Book appointment = repository.findOne(id);
        // Assert.assertEquals(patient1 ,appointment.getPatient());
    }

    @org.testng.annotations.Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {

        Branch entity = repo.findOne(id);

        Branch updateEntity = new Branch.Builder()
                .id(entity.getId())
                .copy(entity)
                .manager("KRISTOS")
                .build();
        repo.save(updateEntity);
        //  repository.save(newEntity);;
        Branch newEntity = repo.findOne(id);
        assertEquals("KRISTOS",newEntity.getManager());

        //   Assert.assertEquals(appointment.getId(), newAppointment.getId());
        // Assert.assertEquals(patient2, newAppointment.getPatient());
    }

    /*@org.junit.Test//(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Branch branch = repo.findOne(id);
        repo.delete(branch);
        Branch newBranch = repo.findOne(id);
        assertNull(newBranch);
    }*/
}
