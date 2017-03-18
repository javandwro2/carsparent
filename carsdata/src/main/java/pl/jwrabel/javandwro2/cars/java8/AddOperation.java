package pl.jwrabel.javandwro2.cars.java8;

/**
 * Created by jakubwrabel on 18.03.2017.
 */
public class AddOperation implements Operation {
	@Override
	public double evaluate(double x, double y) {
		return x+y;
	}
}
