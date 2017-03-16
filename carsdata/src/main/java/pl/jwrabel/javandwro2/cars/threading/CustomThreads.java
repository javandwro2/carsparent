package pl.jwrabel.javandwro2.cars.threading;

import java.util.Random;

/**
 * Created by jakubwrabel on 16.03.2017.
 */
public class CustomThreads {
	public static void main(String[] args) {

		int[] array = new int[100000000];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt();
		}

		for (int i = 0; i < 100; i++) {
			System.out.println(array[i]);
		}

		//

//		MyThread myThread = new MyThread(20, 100);
//		myThread.start();
////
		// 1
		// 2
		// ...
		// 100
	}
}
