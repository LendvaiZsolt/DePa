
import java.util.Random;
import java.util.Scanner;

import com.design.patterns.decorator.*;
import com.design.patterns.singleton.*;
import com.design.patterns.strategy.*;

public class App {
	public static void main(String[] args) throws Exception {
		System.out.println(
				ANSI_GREEN + "Singleton pattern példa; megmutatjuk, hogy az 'egyke' esetén a példány egy és ugyanaz."
						+ ANSI_RESET);
		EagerSingletonConfig eager1 = EagerSingletonConfig.getInstance();
		System.out.print("Köszönjük, hogy meglátogatta játékboltunk WEBSHOP-ját. Az ön egyedi kosár azonosítója: -> ");
		eager1.print();
		EagerSingletonConfig eager2 = EagerSingletonConfig.getInstance();
		System.out.print(
				"Sajnáljuk, hogy vásárlás közben elveszítette kosár azonosítóját. Az új régi kosár azonosítója: -> ");
		eager2.print();
		// eager2.print();
		printSingletonConfigHashes(eager1, eager2);
		// checkingSingletons(); // ezt akkor kérésre nem futtajuk le
		System.out.println("----------------------------------------");

		System.out.println(
				ANSI_GREEN + "\nDecorator pattern példa; kisautókat fogunk összeszerelni a WEBSHOP-ban." + ANSI_RESET);
		checkingDecorator();

		System.out.println(ANSI_GREEN + "\nStrategy pattern" + ANSI_RESET);
		checkingStrategy();
	}

	private static void checkingStrategy() {
		boolean isCompleted = false;
		System.out.println("A kiválasztott matchboxokkal elkészítjük rendelését.");
		Order order1 = new Order();
		// add item costs to the order
		order1.addCost(30);
		order1.addCost(40);
		order1.setClosed();
		System.out.println("-----");

		System.out.println("Fizetés: paypal");
		isCompleted = order1.pay(new PaypalStrategy("user@email.hu", "password"));
		System.out.println("Nálunk minden rendelés sikeressége random módon dőle el. Önnel sem teszünk kivételt.");
		printPaymentCompletion(isCompleted);
		System.out.println("-----");

		System.out.println("Mivel semmi sincs ingyen, az ajándék matchboxokra is elkészítjük rendelését.");
		Order order2 = new Order();
		order2.addCost(120);
		order2.addCost(5);
		order2.setClosed();
		System.out.println("-----");

		System.out.println("Fizetés: hitelkártya");
		isCompleted = order2.pay(new CreditCardStrategy("Teszt Elek", "1234567898765", "123", "03/27"));
		System.out.println("Nálunk minden rendelés sikeressége random módon dőle el. Önnel sem teszünk kivételt.");
		printPaymentCompletion(isCompleted);

	}

	private static void checkingDecorator() {
		System.out.println("Ön előzetesen egy sport matchboxra adott le rendelést.");
		System.out.println("Milyen név kerüljön a kis sport matchboxra? Légy szíves add azt, hogy sport!");
		String nevsport = strInput();
		Car sportsCar = new SportsCar(new SimpleCar());
		sportsCar.assemble(generateSerialNumber(11));
		sportsCar.honk();
		System.out.println(ANSI_YELLOW + "A ráfestett név pedig: " + nevsport + ANSI_RESET);
		System.out.println("----------------------------------------");

		System.out.println("\nÖn előzetesen egy kis SUV matchboxra is adott le rendelést.");
		System.out.println("Milyen név kerüljön a kis SUV matchboxra? Légy szíves add azt, hogy SUV!");
		String nevsuv = strInput();
		Car suv = new OffRoadCar(new SimpleCar());
		suv.assemble(generateSerialNumber(11));
		suv.honk();
		System.out.println(ANSI_PURPLE + "A ráfestett név pedig: " + nevsuv + ANSI_RESET);
		System.out.println("----------------------------------------");

		System.out.println("\nMivel Ön 2 kisautót is rendelt, ezért egy extra rally, azaz " + ANSI_PURPLE_B + "sportSUV"
				+ ANSI_RESET + " matchboxot adunk önnek ajándékba");
		System.out.println("Milyen név kerüljön a kis rally matchboxra? Légy szíves add azt, hogy SportSuv!");
		String nevrally = strInput();
		Car rallyCar = new SportsCar(new OffRoadCar(new SimpleCar()));
		rallyCar.assemble(generateSerialNumber(11));
		rallyCar.honk();
		System.out.println(ANSI_RED + "A ráfestett név pedig: " + nevrally + ANSI_RESET);
		System.out.println("----------------------------------------");

		System.out.println("\nMivel Ön 2 kisautót is rendelt, ezért még egy extra rally, azaz " + ANSI_PURPLE_B
				+ "SUVsport TEHÁT FORDÍTVA DEKORÁLT" + ANSI_RESET + " matchboxot adunk önnek ajándékba");
		System.out.println("Milyen név kerüljön a kis rally matchboxra? Légy szíves add azt, hogy SuvSport!");
		String nevrally2 = strInput();
		Car rally2Car = new OffRoadCar(new SportsCar(new SimpleCar()));
		rally2Car.assemble(generateSerialNumber(11));
		rally2Car.honk();
		System.out.println(ANSI_RED + "A ráfestett név pedig: " + nevrally2 + ANSI_RESET);
		System.out.println("----------------------------------------");
	}

	public static String strInput() {
		Scanner input = new Scanner(System.in);
		// System.out.println("Adj meg egy stringet!");
		String str = input.next();

		return str;
	}

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[42m";
	public static final String ANSI_PURPLE_B = "\u001B[45m";

	private static void checkingSingletons() {
		System.out.println("Köszönjük, hogy meglátogatta játékboltunk WEBSHOP-ját. Az ön egyedi kosár azonosítója: ");
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
		System.out.println("Nyugodjon meg, nem vesztek el adatai. A régi kosár hashkódja: " + x.hashCode() + " = "
				+ "új régi kosár hashkódjával: " + y.hashCode());
	}

	private static void printPaymentCompletion(boolean isCompleted) {
		if (isCompleted) {
			System.out.println(ANSI_PURPLE_B + "A fizetés sikeres, pénze nálunk, távozhat." + ANSI_RESET);
			return;
		}
		System.out.println(ANSI_PURPLE_B + "Sajnos a fizetése most sikertelen lett, próbálja újra." + ANSI_RESET);
	}
}
