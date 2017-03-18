package pl.jwrabel.javandwro2.cars.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jakubwrabel on 18.03.2017.
 */
public class Java8Main {
	public static void main(String[] args) {
		System.out.println("Podaj X");
		Scanner scanner = new Scanner(System.in);
		double x = scanner.nextDouble();
		System.out.println("Podaj Y");
		double y = scanner.nextDouble();
		System.out.println("Podaj znak");
		String operator = scanner.next();



		List<Integer> integerList = new ArrayList<>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		integerList.add(4);

		List<Operation> operations = new ArrayList<>();
		operations.add(new SubstractOperation());
		operations.add(new AddOperation());
		operations.add(new AddOperation());

		Operation addOperation = new Operation() {
			@Override
			public double evaluate(double x, double y) {
				return x + y;
			}
		};

		for (int i = 0; i < integerList.size() - 1; i++) {
			int x2 = integerList.get(i);
			int y2 = integerList.get(i+1);

			double result = operations.get(i).evaluate(x2, y2);
			integerList.set(i+1, (int) result);
		}

		Operation operation = null;


		if (operator.equals("+")) {
			operation = new AddOperation();
		} else if (operator.equals("-")) {
			operation = new SubstractOperation();
		}

		double result = operation.evaluate(x, y);

		System.out.println("Wynik " + result);
	}
}
