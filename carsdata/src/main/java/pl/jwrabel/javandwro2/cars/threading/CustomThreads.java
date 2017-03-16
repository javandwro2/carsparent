package pl.jwrabel.javandwro2.cars.threading;

import java.util.Random;

/**
 * Created by jakubwrabel on 16.03.2017.
 */
public class CustomThreads {
	public static void main(String[] args) throws InterruptedException {

		int[] array = new int[100000000];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt();
		}

		System.out.println("MIN SEARCHING STARTED");
		MinThread minThread1 = new MinThread(0,24_999_999,array);
		MinThread minThread2 = new MinThread(25_000_000,49_999_999,array);
		MinThread minThread3 = new MinThread(50_000_000,74_999_999,array);
		MinThread minThread4 = new MinThread(75_000_000,99_999_999,array);
		minThread1.start();
		minThread2.start();
		minThread3.start();
		minThread4.start();

		minThread1.join();
		minThread2.join();
		minThread3.join();
		minThread4.join();

		int[] mins = {minThread1.getMin(), minThread2.getMin(), minThread3.getMin(), minThread4.getMin()};

		int min = mins[0];
		for (int i = 1; i <4; i++) {
			if(mins[i] < min){
				min = mins[i];
			}
		}

		System.out.println("MIN: " + min);
	}
}
