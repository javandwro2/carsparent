package pl.jwrabel.javandwro2.cars.threading;

/**
 * Created by jakubwrabel on 15.03.2017.
 */
public class TestThread extends Thread {
	@Override
	public void run() {
		long start = System.nanoTime();

		String s = "";
		for (int i = 0; i < 50000; i++) {
			s += "ABC";
		}

		double duration = (System.nanoTime() - start) / 1_000_000_000d;

		System.out.println("Duration " + duration);
	}
}
