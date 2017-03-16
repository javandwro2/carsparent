package pl.jwrabel.javandwro2.cars.threading;

/**
 * Created by jakubwrabel on 16.03.2017.
 */
public class Threads {
	public static void main(String[] args) throws InterruptedException {

		// SPOSOBY NA TWORZENIE WĄTKÓW
		// 1. Rozszerzenie klasy Thread
		Thread thread = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(i);

				}
			}
		};
//		thread.start();

		// 2. Zaimplementowanie interfejsu Runnable
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(i);
				}
			}
		};
		Thread thread2 = new Thread(runnable);
		thread2.start();
	}
}
