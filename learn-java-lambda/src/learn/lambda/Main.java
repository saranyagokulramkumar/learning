package learn.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Thread(() -> {
        }).start();

        Employee john = new Employee("John Doe",30);
        Employee saranya = new Employee("Saranya G",30);
        Employee aishu = new Employee("Aishu G",5);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(john);
        employeeList.add(saranya);
        employeeList.add(aishu);

        Collections.sort(employeeList, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        for(Employee employee: employeeList){

            System.out.printf(employee.getName()+"\n");
        }

        String s = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }
        ,employeeList.get(0).getName(),
                employeeList.get(1).getName());
        System.out.println(s);

        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
        String s2 = doStringStuff(uc,employeeList.get(1).getName(),employeeList.get(2).getName());
        System.out.println(s2);
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
}

interface UpperConcat{

    public String  upperAndConcat(String s1, String s2);
}