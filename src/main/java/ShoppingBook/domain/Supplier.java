package ShoppingBook.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    private String name;
    private String registrationNumber;
    private String address;
    private long telephoneNumber;


    public Long getId() {
        return id;
    }



    public Supplier(Builder builder)
    {
        this.name = builder.name;
        this.address = builder.address;
        this.telephoneNumber = builder.telephoneNumber;
        this.registrationNumber = builder.registrationNumber;
        this.id = builder.id;

    }
    public Supplier()
    {


    }
    public static class Builder
    {

        String name;
        String registrationNumber;
        String address;
        long telephoneNumber;

        Long id;


        public Builder ()
        {


        }

        public Builder id(Long value)

        {
            this.id = value;
            return this;
        }

        public Builder name(String value)
        {
            this.name= value;
            return this;
        }



        public Builder registrationNumber(String value)
        {
            this.registrationNumber = value;
            return this;
        }

        public Builder address(String value)
        {
            this.address = value;
            return this;
        }
        public Builder telephoneNumber(long value)
        {
            this.telephoneNumber = value;
            return this;
        }

        public Builder copy(Supplier supplier)
        {


            this.name = supplier.getName();
            this.registrationNumber = supplier.getRegistrationNumber();
            this.address = supplier.getAddress();
            this.telephoneNumber = supplier.getTelephoneNumber();
            this.id = supplier.getId();
            return this;
        }

        public Supplier build()
        {
            return  new Supplier(this);
        }
    }


}
