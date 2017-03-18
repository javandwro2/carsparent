package pl.jwrabel.javandwro2.cars.threading;

import java.util.Random;

/**
 * Created by jakubwrabel on 18.03.2017.
 */
public class MultArrays {
	public static void main(String[] args) {


		int[][] arrrayA = new int[10][10];
		fillArrayWithRandom(arrrayA);

		System.out.println("Array A");
		printArray(arrrayA);
		System.out.println("----------------------------");

		int[][] arrrayB = new int[10][10];
		fillArrayWithRandom(arrrayB);

		System.out.println("Array B");
		printArray(arrrayB);
		System.out.println("----------------------------");


		int[][] result = multiplyArrays(arrrayA, arrrayB);
		System.out.println("RESULT");
		printArray(result);

	}

	private static int[][] multiplyArrays(int[][] arrayA, int[][] arrayB) {
		int[][] result = new int[arrayB.length][arrayA[0].length];

		MultArrayThread multArrayThread = new MultArrayThread(arrayA, arrayB, result, 0, 4);
		MultArrayThread multArrayThread2 = new MultArrayThread(arrayA, arrayB, result, 5, 9);
		multArrayThread.start();
		multArrayThread2.start();

		try {
			multArrayThread.join();
			multArrayThread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return result;
	}

	private static void fillArrayWithRandom(int[][] array) {
		Random random = new Random();

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = random.nextInt(10);
			}
		}
	}

	private static void printArray(int[][] array) {
		for (int y = 0; y < array[0].length; y++) {
			for (int x = 0; x < array.length; x++) {
				System.out.print(array[x][y] + " ");
			}
			System.out.println();
		}
	}
}
