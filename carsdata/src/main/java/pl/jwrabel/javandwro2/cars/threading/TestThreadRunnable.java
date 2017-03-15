package pl.jwrabel.javandwro2.cars.threading;

/**
 * Created by jakubwrabel on 15.03.2017.
 */
public class TestThreadRunnable implements Runnable {
	public static void main(String[] args) {
		TestThreadRunnable myRunnable = new TestThreadRunnable();
		Thread thread = new Thread(myRunnable);
		thread.start();
	}

	@Override
	public void run() {
		System.out.println("Wątek uruchomiony");
	}
}
