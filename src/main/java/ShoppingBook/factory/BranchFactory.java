package ShoppingBook.factory;


import ShoppingBook.domain.Branch;

import java.util.Map;


public class BranchFactory {

    public static Branch createBranch(Map<String,String> value, long tel)
    {
        return new Branch.Builder().telephoneNumber(tel).manager(value.get("manager")).address(value.get("address")).build();
    }
}
