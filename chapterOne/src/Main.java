import containers.water.Container;
import containers.water.User;

public class Main {
    public static void main(String[] args) {
        Container containerA = new Container();
        Container containerB = new Container();
        Container containerC = new Container();

        containerA.addWater(12);
        containerB.addWater(8);
        containerC.addWater(20);

        System.out.println("A amount: " + containerA.getAmount());
        System.out.println("B amount: " + containerB.getAmount());
        System.out.println("C amount: " + containerC.getAmount());
        System.out.println("======================================");
        containerA.connectTo(containerB);
        System.out.println("A amount: " + containerA.getAmount());
        System.out.println("B amount: " + containerB.getAmount());
        System.out.println("C amount: " + containerC.getAmount());
        System.out.println("======================================");
        containerB.connectTo(containerC);
        System.out.println("A amount: " + containerA.getAmount());
        System.out.println("B amount: " + containerB.getAmount());
        System.out.println("C amount: " + containerC.getAmount());

        User userA = new User("小白");
        User userB = new User("小灰");
        User userC = new User("小斑");

        userA.befriend(userB);
        System.out.println("直接连接：" + userA.isDirectFriendOf(userB));
        System.out.println("间接连接：" + userA.isInDirectFriendOf(userB));

        userB.befriend(userC);
        System.out.println("直接连接：" + userA.isDirectFriendOf(userC));
        System.out.println("间接连接：" + userA.isInDirectFriendOf(userC));
    }
}