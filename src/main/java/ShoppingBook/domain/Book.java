package ShoppingBook.domain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Book implements BookInterface, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  int year;
    private double price;
    private int quantity;
    private String isbnNumber;
    @Embedded
    private Author author;
  //  @Embedded
   // private  Publisher publisher;

    private String title;


    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTitle() {
        return  title;
    }

    public Author getAuthor() {
        return author;
    }

  /*  public Publisher getPublisher() {
        return publisher;
    }*/





    public Long getId() { return id;}



    public Book(Builder builder)
    {
        this.title = builder.title;
        this.isbnNumber = builder.isbnNumber;
        this.price =  builder.price;
        this.year = builder.year;
        this.quantity = builder.quantity;
        this.author = builder.author;
      //  this.publisher = builder.publisher;
        this.id = builder.id;
    }
    public Book()
    {

    }

    public static class Builder
    {
        Long id;

        int year;
        int quantity;
        Author author;
        String isbnNumber;
        Publisher publisher;
        double price;
        String title;

        public Builder()
        {

        }

        public Builder year(int value)
        {
            this.year =  value;
            return this;
        }

        public Builder isbnNumber(String value)
        {
            this.isbnNumber = value;
            return this;
        }
        public Builder quantity(int value)
        {
            this.quantity = value;
            return this;
        }

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }
        public Builder price(double value)
        {
            this.price = value;
            return  this;
        }

        public Builder author(Author object)
        {
            this.author = object;
            return this;
        }



        public Builder title(String value)
        {
            this.title = value;
            return  this;
        }

     /*   public Builder publisher(Publisher object)
        {
            this.publisher = object;
            return  this;
        }*/

        public Builder copy(Book book)
        {
            this.isbnNumber = book.getIsbnNumber();
            this.price = book.getPrice();
            this.quantity = book.getQuantity();
            this.year = book.getYear();
            this.author = book.getAuthor();
           // this.publisher = book.getPublisher();
            this.title = book.getTitle();
            this.id = book.getId();
            return this;
        }

        public Book build()
        {
            return  new Book(this);
        }

    }
}

