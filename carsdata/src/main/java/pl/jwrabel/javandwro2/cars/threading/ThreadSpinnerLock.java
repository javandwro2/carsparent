package pl.jwrabel.javandwro2.cars.threading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakubwrabel on 16.03.2017.
 */
public class ThreadSpinnerLock {
	public static void main(String[] args) throws InterruptedException {

		List<Integer>  integers = new ArrayList<>();
		Thread worker = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(6000);
					integers.add(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread spinner = new Thread(){
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					if(!integers.isEmpty()){
						return;
					}
//					if(integers.size() != 0){
//
//					}
					try {
						Thread.sleep(100);
						System.out.print(".");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		worker.start();
		spinner.start();
		worker.join();

	}
}
