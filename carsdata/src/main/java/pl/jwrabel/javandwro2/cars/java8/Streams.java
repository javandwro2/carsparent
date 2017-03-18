package pl.jwrabel.javandwro2.cars.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by jakubwrabel on 18.03.2017.
 */
public class Streams {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
//
//		list.stream().forEach(x -> System.out.println(x));
//		list.stream().forEach(System.out::println);
//		list.forEach(System.out::println);
//
//		list.stream().forEach(x -> {
//			System.out.println(x);
//			System.out.println("BLA");
//		});

		list.stream().filter(x -> x < 2).forEach(x -> System.out.println(x));
		boolean matches = list.stream().anyMatch(x -> x == 2);
		long even = list.stream().filter(x -> x % 2 == 0).count();
		boolean noZero = list.stream().noneMatch(x -> x == 0);
		list.stream().sorted().forEach(x -> System.out.println(x));

		List<Integer> evenList = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());


		list.stream().map(x -> x * x).forEach(x -> System.out.println(x));
		list.stream().map(x -> "Number: " + x).forEach(x -> System.out.println(x));
		List<String> strings = list.stream().map(x -> "Number: " + x).collect(Collectors.toList());

//		List<Integer> evenList = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		List<Integer> evenList2 = list.stream().filter(new Predicate<Integer>() {
			@Override
			public boolean test(Integer integer) {
				return integer % 2 == 0;
			}
		}).collect(Collectors.toList());



	}
}
