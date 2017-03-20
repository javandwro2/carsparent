package pl.jwrabel.javandwro2.cars.java8;

import java.util.ArrayList;
import java.util.List;

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




	}
}
