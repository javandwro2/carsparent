package pl.jwrabel.javandwro2.cars.threading;

/**
 * Created by jakubwrabel on 16.03.2017.
 */
public class MyThread extends Thread {
	int x;

	public MyThread(int x) {
		this.x = x;
	}

	@Override
	public void run() {
		for (int i = 1; i <= x; i++) {
			System.out.println(i);
		}
	}
}
