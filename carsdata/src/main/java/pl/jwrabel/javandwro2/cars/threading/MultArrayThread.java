package pl.jwrabel.javandwro2.cars.threading;

/**
 * Created by jakubwrabel on 18.03.2017.
 */
public class MultArrayThread extends Thread {
	private int[][] arrayA;
	private int[][] arrayB;
	private int[][] result;
	private int start;
	private int stop;

	public MultArrayThread(int[][] arrayA, int[][] arrayB, int[][] result, int start, int stop) {
		this.arrayA = arrayA;
		this.arrayB = arrayB;
		this.result = result;
		this.start = start;
		this.stop = stop;
	}

	@Override
	public void run() {
		for (int x = start; x <= stop; x++) {
			for (int y = 0; y < result[0].length; y++) {

				int[] bColumn = arrayB[x];

				int[] aRow = new int[arrayA.length];
				for (int i = 0; i < aRow.length; i++) {
					aRow[i] = arrayA[i][y];
				}

				int multSum = 0;
				for (int i = 0; i < aRow.length; i++) {
					int mult = aRow[i] * bColumn[i];
					multSum += mult;
				}

				result[x][y] = multSum;
			}
		}
	}
}
