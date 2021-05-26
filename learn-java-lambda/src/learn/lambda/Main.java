package learn.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Thread(() -> {
        }).start();

        AnotherClass anotherClass = new AnotherClass();
        String result = anotherClass.doSomething();
        System.out.println(result);
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2){

        return uc.upperAndConcat(s1,s2);
    }

}

class Employee{

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

interface UpperConcat{

    public String  upperAndConcat(String s1, String s2);
}

class AnotherClass{
    public String doSomething(){
        UpperConcat uc = (s1,s2) ->{
            System.out.println("the lambda expression's class is "+getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("the anotherclass's class is "+getClass().getSimpleName());
        return Main.doStringStuff(uc,"String1","String2");
    }
}