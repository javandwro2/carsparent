package pl.jwrabel.javandwro2.cars.java8;

/**
 * Created by jakubwrabel on 18.03.2017.
 */
public class SubstractOperation implements Operation {
	@Override
	public double evaluate(double x, double y) {
		return x-y;
	}
}
