package ShoppingBook.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Customer implements CustomerInterface,Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private CustomerAddress customerAddress;
    @Embedded
    private PersonalInformation personalInformation;

    public Long getId(){ return id;}


    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public Customer(Builder builder)
    {
        this.id = builder.id;
        this.customerAddress = builder.customerAddress;
        this.personalInformation = builder.personalInformation;
    }
    public Customer()
    {

    }

    public static class Builder
    {
        CustomerAddress customerAddress;
        PersonalInformation personalInformation;
        Long id;


        public Builder ()
        {

        }


        public Builder CustomerAddress(CustomerAddress customerAddress)
        {
            this.customerAddress = customerAddress;
            return this;
        }


        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder PersonalInformation(PersonalInformation personalInformation)
        {
            this.personalInformation = personalInformation;
            return this;
        }


        public Builder copy(Customer customer)
        {

            this.id = customer.getId();
            this.personalInformation = customer.getPersonalInformation();
            this.customerAddress = customer.getCustomerAddress();
            return this;
        }

        public Customer build()
        {
            return new Customer(this);
        }
    }



}

