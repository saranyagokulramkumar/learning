package singleton;

public class Main {

    public static void main(String[] args) {

        DbSingleton instance = DbSingleton.getInstance();
        DbSingleton instance2 = DbSingleton.getInstance();

        System.out.printf(instance.toString()+"\n");
        System.out.println(instance2.toString()+"\n");

        DbSingletonLazyLoad lazyinstance = DbSingletonLazyLoad.getInstance();

        System.out.println(lazyinstance.toString());
    }
}
