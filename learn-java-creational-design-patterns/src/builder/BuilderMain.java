package builder;

public class BuilderMain {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();

        builder.append("this is an example");
        builder.append(" of the builder pattern. ");
        builder.append(42);

        System.out.println(builder.toString());

        LunchOrder.Builder builder2 = new LunchOrder.Builder();

        LunchOrder lunchOrder = builder2.bread("wheat").condiments("lettuce").dressing("mayo").meat("turkey").build();

        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getCondiments());
        System.out.println(lunchOrder.getDressing());
        System.out.println(lunchOrder.getMeat());
    }
}
