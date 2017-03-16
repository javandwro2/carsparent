package pl.jwrabel.javandwro2.cars.threading;

/**
 * Created by jakubwrabel on 16.03.2017.
 */
public class MinThread extends Thread {
	private int start;
	private int stop;
	private int[] array;
	private int min;

	public MinThread(int start, int stop, int[] array) {
		this.start = start;
		this.stop = stop;
		this.array = array;
	}

	@Override
	public void run() {
		min = array[start];
		for (int i = start+1; i <= stop; i++) {
			if(min > array[i]){
				min = array[i];
			}
		}
	}

	public int getMin() {
		return min;
	}
}
