package pl.jwrabel.javandwro2.cars;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jakubwrabel on 11.03.2017.
 */
public class CarTest {

	@Test
	public void constructor_shouldCreateCorrectObject() {
		// given
		String text = "Ford,Mustang,2001,240";
		String expectedBrand = "Ford";
		String expectedModel = "Mustang";
		int expectedManYear = 2001;
		double expectedPower = 240;

		// when
		Car car = new Car(text);

		// then
		assertEquals(expectedBrand, car.getBrand());
		assertEquals(expectedModel, car.getModel());
		assertEquals(expectedManYear, car.getManufactureYear());
		assertEquals(expectedPower, car.getPower(), 0.000001d);
	}

	@Test
	public void constructor_shouldCreateCorrectObjectForNonTrimmedString() {
		// given
		String text = "   Ford  ,  Mustang  ,  2001 ,   240  ";
		String expectedBrand = "Ford";
		String expectedModel = "Mustang";
		int expectedManYear = 2001;
		double expectedPower = 240;

		// when
		Car car = new Car(text);

		// then
		assertEquals(expectedBrand, car.getBrand());
		assertEquals(expectedModel, car.getModel());
		assertEquals(expectedManYear, car.getManufactureYear());
		assertEquals(expectedPower, car.getPower(), 0.000001d);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructor_nullString() {
		Car car = new Car(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructor_incorrectInput() {
		Car car = new Car("asdb");
	}

}