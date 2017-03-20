package pl.jwrabel.javandwro2.cars.java8;

import com.sun.tools.javadoc.Start;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by jakubwrabel on 18.03.2017.
 */
public class LambdaPersons {
	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("Adam", "Nowak", "Wrocław"));
		personList.add(new Person("Adam", "Kowalski", "Warszawa"));
		personList.add(new Person("Jerzy", "Polański", "Warszawa"));
		personList.add(new Person("Piotr", "Mickiewicz", "Sosnowiec"));
		personList.add(new Person("Jan", "Kowalski", "Wrocław"));


		// WYPISANIE TYLKO OSÓB Z WARSZAWY
		personList.stream().filter(p -> p.getCity().equals("Warszawa")).forEach(x -> System.out.println(x));


		personList.stream()
				.filter(p -> p.getCity().equals("Warszawa"))
				.map(p -> p.getFirstName() + " " + p.getLastName() + ", " + p.getCity())
				.forEach(x -> System.out.println(x));

		personList.stream().sorted((x, y) -> 0).forEach(x -> System.out.println(x));


		//1. Posortować Nazwisko, imię, miasto
		//2. Sprawdzenie, czy liczba jest liczbą pierwszą z użyciem lambd (IntStream)
		int x = 4;
		boolean isPrime = isPrime(x);
		System.out.println("Jest liczbą pierwszą " + isPrime);


		IntStream.range(2, 100).filter(y -> isPrime(y)).forEach(y -> System.out.println(y));

		IntStream.range(2, 100).filter(y -> IntStream
				.range(2, y / 2 + 1)
				.noneMatch(number -> y % number == 0)
		).forEach(y -> System.out.println(y));

		//3. W jednym ciągu wywołań -> wypisać wszystkie osoby, wypisać tylko z Warszawy w formacie Nazwisko Imię, WARSZAWA
		personList.stream()
				.peek(p -> System.out.println(p.getFirstName() + " " + p.getLastName()))
				.filter(p -> p.getCity().equals("Warszawa"))
				.map(p -> p.getLastName() + " " + p.getFirstName() + ", " + p.getCity().toUpperCase())
				.forEach(p -> System.out.println(p));


	}

	private static boolean isPrime(int y) {
		return IntStream
				.range(2, y / 2 + 1)
				.noneMatch(number -> y % number == 0);
	}
}
