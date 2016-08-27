package ShoppingBook.service;

import ShoppingBook.App;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import ShoppingBook.repository.CustomerRepository;
import ShoppingBook.services.Impl.CustomerServiceImpl;


@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCustomerService extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerServiceImpl service;
    @org.testng.annotations.Test
    public void testCrossValidation() throws Exception {


        Assert.assertSame(true, service.crossValidation("Abel"));
    }
}
