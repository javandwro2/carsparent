package pl.jwrabel.javandwro2.cars.threading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakubwrabel on 18.03.2017.
 */
public class MinSearchThread extends Thread {

	int[] array;
	int numberOfThreads;
	int min;

	public MinSearchThread(int[] array, int numberOfThreads) {
		this.array = array;
		this.numberOfThreads = numberOfThreads;
	}

	@Override
	public void run() {
		List<MinThread> threads = new ArrayList<>();

		int threadRange = array.length / numberOfThreads;

		for (int i = 0; i < numberOfThreads; i++) {
			int start = i * threadRange;
			int stop = (i + 1) * threadRange - 1;

			if (i == numberOfThreads - 1) {
				stop = array.length - 1;
			}


			MinThread thread = new MinThread(start, stop, array);
			thread.start();
			threads.add(thread);
		}

		for (MinThread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		List<Integer> results = new ArrayList<>();
		for (MinThread thread : threads) {
			results.add(thread.getMin());
		}


		min = results.get(0);
		for (int i = 1; i < results.size(); i++) {
			if (results.get(i) < min) {
				min = results.get(0);
			}
		}
	}

	public int getMin() {
		return min;
	}
}
