package pl.jwrabel.javandwro2.cars.threading;

/**
 * Created by jakubwrabel on 16.03.2017.
 */
public class ThreadSpinner {
	public static void main(String[] args) throws InterruptedException {
		Thread worker = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread spinner = new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.print("\\");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		worker.start();
		spinner.start();
		worker.join();
		spinner.stop();

	}
}
