package ShoppingBook.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ShoppingBook.domain.Employee;
import ShoppingBook.factory.EmployeeFactory;
import ShoppingBook.services.Impl.EmployeeServiceImpl;

import java.util.*;


@RestController
@RequestMapping(value = "/employee/**")

public class EmployeeController {

    @Autowired
    private  EmployeeServiceImpl service;



    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public boolean addEmployee() {

        Map<String,String> values = new HashMap<String,String>();


        values.put("name","Nathan");
        values.put("surname", "Luteton");
        values.put("position", "Administrator");
        values.put("password", "12345");
        values.put("systemName", "nathanLuteton");


        //Object

        Employee employee = EmployeeFactory.createEmployee(values,12000);


        // CREATE

        Employee insertedEntity = service.save(employee);

        if (insertedEntity!= null)
            return  true;
        else
            return false;

    }

    //-------------------Retrieve Single Story--------------------------------------------------------
    /*@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
        Employee story = service.findById(id);
        public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
        if (story == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(story, HttpStatus.OK);
    }*/


    //-------------------Retrieve All Employees--------------------------------------------------------

   @RequestMapping(value = "/employees", method = RequestMethod.GET)
   @ResponseBody
    public List<Employee> getEmployees() {
        Iterable<Employee> stories = service.findAll();


       List<Employee> resources = new ArrayList<Employee>();

       for (Employee book : stories) {
        resources.add(book);

       }
       return resources;

    }

    //------------------- Update Employee --------------------------------------------------------

   @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public boolean updateEmployee(@PathVariable("id") long id/*, @RequestBody Employee employee*/) {

       Employee entity = service.findById(id);

       Employee updateEntity = new Employee.Builder()
               .id(entity.getId())
               .copy(entity)
               .name("Named Updated")
               .build();
       service.save(updateEntity);
       //  repository.save(newEntity);;
       Employee newEntity = service.findById(id);

       if (newEntity!= null)
           return  true;
       else
           return false;

    }

    //------------------- Delete a Story --------------------------------------------------------

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public boolean deleteStory(@PathVariable("id") long id) {
        Employee story = service.findById(id);
        if (story == null) {
            return false;
        }
        service.delete(story);
        return true;
    }
}



