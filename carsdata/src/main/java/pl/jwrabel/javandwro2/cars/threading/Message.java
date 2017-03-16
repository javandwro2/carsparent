package pl.jwrabel.javandwro2.cars.threading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakubwrabel on 16.03.2017.
 */
public class Message {

	public static void main(String[] args) throws InterruptedException {
		Message message = new Message();
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10000000; i++) {
					message.setMessage("ABC");
				}
			}
		};
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10000000; i++) {
					message.setMessage("XYZ");
				}
			}
		};
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println(message.getMessage());
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
