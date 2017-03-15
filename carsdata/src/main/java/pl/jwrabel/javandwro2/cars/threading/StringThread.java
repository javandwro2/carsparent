package pl.jwrabel.javandwro2.cars.threading;

/**
 * Created by jakubwrabel on 15.03.2017.
 */
public class StringThread extends Thread {

	public static void main(String[] args) {
		StringThread thread1 = new StringThread("Wątek 1");
		StringThread thread2 = new StringThread("Wątek 2");

		thread1.start();
		thread2.start();
	}

	private String name;

	public StringThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " " + i);
		}
	}
}
