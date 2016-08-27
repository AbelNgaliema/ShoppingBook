package ShoppingBook.factory;



import ShoppingBook.domain.Publisher;

import java.util.Map;


public class PublisherFactory {

    public static Publisher createPublisher(Map<String,String> value)
    {

        return new Publisher.Builder().city(value.get("city")).registration(value.get("registration")).name(value.get("name")).build();
    }

}
