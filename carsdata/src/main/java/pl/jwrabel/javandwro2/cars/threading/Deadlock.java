package pl.jwrabel.javandwro2.cars.threading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakubwrabel on 16.03.2017.
 */
public class Deadlock {

	public static void main(String[] args) throws InterruptedException {
		Object monitor1 = new Object();
		Object monitor2 = new Object();

		Thread thread1 = new Thread() {
			@Override
			public void run() {
				synchronized (monitor1){

					System.out.println("Wszedłem w pierwszy poziom - Wątek 1");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					synchronized (monitor2){
						System.out.println("Dostałem się - Wątek 1");
					}
				}
			}
		};
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				synchronized (monitor2){

					System.out.println("Wszedłem w pierwszy poziom - Wątek 2");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					synchronized (monitor1){
						System.out.println("Dostałem się - Wątek 2");
					}
				}
			}
		};
		thread1.start();
		thread2.start();
	}

	private List<String> list = new ArrayList<>();

	public synchronized void setMessage(String msg) {
		list.clear();
		list.add(msg);
	}

	public String getMessage() {
		return list.get(0);
	}

}
