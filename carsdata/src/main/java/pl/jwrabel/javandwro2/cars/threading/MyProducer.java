package pl.jwrabel.javandwro2.cars.threading;

/**
 * Created by jakubwrabel on 18.03.2017.
 */
public class MyProducer extends Thread {
	private MyMessage message;

	public MyProducer(MyMessage message) {
		this.message = message;
	}

	@Override
	public void run() {
		System.out.println("Produer started");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Produer working");

		synchronized (message) {
			message.setMsg("Hello World");
			message.notify();
		}

	}
}
