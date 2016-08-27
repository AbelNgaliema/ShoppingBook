package ShoppingBook.factory;



import ShoppingBook.domain.PersonalInformation;

import java.util.Map;


public class PersonalInformationFactory {

    public static PersonalInformation createPersonalInformation (Map<String, String> value, int cellphone, int telephone)
    {
        return  new PersonalInformation.Builder().idNumber(value.get("idNumber")).name(value.get("name")).surname(value.get("surname")).
                email(value.get("email")).cellphone(cellphone).telephone(telephone).build();
    }
}
