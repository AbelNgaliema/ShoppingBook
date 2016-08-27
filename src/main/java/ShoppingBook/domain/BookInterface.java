package ShoppingBook.domain;


public interface BookInterface {

    int getYear();
    double getPrice();
    String getIsbnNumber();
    int getQuantity();
    String getTitle();
    Author getAuthor();
   // Publisher getPublisher();
    Long getId();



}
