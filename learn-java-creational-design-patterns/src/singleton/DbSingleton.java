package singleton;

public class DbSingleton {

    private static volatile DbSingleton instance = new DbSingleton();

    private DbSingleton(){

        if(instance != null){

            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static DbSingleton getInstance() {
        return instance;
    }
}
