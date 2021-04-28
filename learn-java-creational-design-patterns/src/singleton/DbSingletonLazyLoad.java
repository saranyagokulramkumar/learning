package singleton;

public class DbSingletonLazyLoad {

    private static volatile DbSingletonLazyLoad instance = null;

    private DbSingletonLazyLoad(){

        if(instance != null){

            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static DbSingletonLazyLoad getInstance(){

        if(instance == null){

            synchronized (DbSingleton.class){

                if(instance == null){
                    instance = new DbSingletonLazyLoad();
                }
            }
        }

        return instance;
    }
}
