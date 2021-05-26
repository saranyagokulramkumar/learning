package learn.generics;

import java.util.HashMap;
import java.util.Optional;

public class Generics {

    public static void main(String[] args) {

        ConsumeName consumeName = new ConsumeName();
        UserDictionary userDictionary = new UserDictionary();

        for(int i = 0;i < 4; i++){
            userDictionary.getUserByNumber(i)
                    .map(String::toUpperCase)
                    .ifPresent()
        }
    }

}

class UserDictionary{

    final HashMap<Integer, String> theList = new HashMap<>();

    UserDictionary(){
        theList.put(0, "john doe");
        theList.put(1, "alfred neuman");
        theList.put(2, "john galt");
    }

    void addUser(int number, String name){
        theList.put(number, name);
    }

    Optional getUserByNumber(int number){
        return Optional.ofNullable(theList.get(number));
    }
}

class ConsumeName{
    void printName(String name){
        System.out.println("Name is "+name);
        name = name.concat(" is a nice person");
        System.out.println(name);
    }
}