
import java.util.Random;

import com.design.patterns.decorator.*;
import com.design.patterns.singleton.*;
import com.design.patterns.strategy.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Singleton pattern");
        checkingSingletons();
        System.out.println("\nDecorator pattern");
        checkingDecorator();
        System.out.println("\nStrategy pattern");
        checkingStrategy();
    }

    private static void checkingStrategy() {
        boolean isCompleted = false;
        System.out.println("Create order and add items");
        Order order1 = new Order();
        // add item costs to the order
        order1.addCost(30);
        order1.addCost(40);
        order1.setClosed();
        System.out.println("-----");

        System.out.println("Paying with paypal");
        isCompleted = order1.pay(new PaypalStrategy("user@email.hu", "password"));
        printPaymentCompletion(isCompleted);
        System.out.println("-----");

        System.out.println("Create second order and add items");
        Order order2 = new Order();
        order2.addCost(120);
        order2.addCost(5);
        order2.setClosed();
        System.out.println("-----");

        System.out.println("Paying with credit card");
        isCompleted = order2.pay(new CreditCardStrategy("Teszt Elek", "1234567898765", "123", "03/27"));
        printPaymentCompletion(isCompleted);

    }

    private static void checkingDecorator() {
        System.out.println("Creating sports car");
        Car sportsCar = new SportsCar(new SimpleCar());
        sportsCar.assemble(generateSerialNumber(11));
        sportsCar.honk();
        System.out.println("-----");
        System.out.println("Creating SUV");
        Car suv = new OffRoadCar(new SimpleCar());
        suv.assemble(generateSerialNumber(11));
        suv.honk();
        System.out.println("-----");
        System.out.println("Creating rally car");
        Car rallyCar = new SportsCar(new OffRoadCar(new SimpleCar()));
        rallyCar.assemble(generateSerialNumber(11));
        rallyCar.honk();
    }

    private static void checkingSingletons() {
        System.out.println("Checking singletons");
        EagerSingletonConfig eager1 = EagerSingletonConfig.getInstance();
        EagerSingletonConfig eager2 = EagerSingletonConfig.getInstance();
        printSingletonConfigHashes(eager1, eager2);
        LazySingletonConfig lazy1 = LazySingletonConfig.getInstance();
        LazySingletonConfig lazy2 = LazySingletonConfig.getInstance();
        printSingletonConfigHashes(lazy1, lazy2);
        ReflectionsafeSingletonConfig reflectionproof1 = ReflectionsafeSingletonConfig.getInstance();
        ReflectionsafeSingletonConfig reflectionproof2 = ReflectionsafeSingletonConfig.getInstance();
        printSingletonConfigHashes(reflectionproof1, reflectionproof2);
        ThreadsafeSingletonConfig threadsafe1 = ThreadsafeSingletonConfig.getInstance();
        ThreadsafeSingletonConfig threadsafe2 = ThreadsafeSingletonConfig.getInstance();
        printSingletonConfigHashes(threadsafe1, threadsafe2);
        SerializationsafeSingletonConfig serializationsafe1 = SerializationsafeSingletonConfig.getInstance();
        SerializationsafeSingletonConfig serializationsafe2 = SerializationsafeSingletonConfig.getInstance();
        printSingletonConfigHashes(serializationsafe1, serializationsafe2);
    }

    private static String generateSerialNumber(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            Random r = new Random();
            sb.append((char) (r.nextInt(26) + 'a'));
        }
        return sb.toString();
    }

    private static void printSingletonConfigHashes(Config x, Config y) {
        System.out.println(
                x.getClass().getSimpleName() + " object 1 " + x.hashCode() + " = " + y.getClass().getSimpleName()
                        + "object 2 " + y.hashCode());
    }

    private static void printPaymentCompletion(boolean isCompleted) {
        if (isCompleted) {
            System.out.println("The payment is successfully completed");
            return;
        }
        System.out.println("Payment is failed");
    }
}
