package pl.jwrabel.javandwro2.cars;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jakubwrabel on 14.03.2017.
 */
public class CarRepositoryTest {

	@Test
	public void saveState_simple() throws IOException {
		CarRepository carRepository = new CarRepository();

		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Ford,Mondeo,2001,120"));
		cars.add(new Car("Ford,Mondeo,2001,120"));
		cars.add(new Car("Ford,Mondeo,2001,120"));
		cars.add(new Car("Ford,Mondeo,2001,120"));
		carRepository.setCarList(cars);

		carRepository.saveStateToFile("carsTest.txt");

		List<String> lines = Files.readLines(new File("carsTest.txt"), Charsets.UTF_8);
		assertEquals(lines.size(), 4);
	}

	@Test
	public void saveState_checkDataIfCorrect() throws IOException {
		CarRepository carRepository = new CarRepository();

		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Ford,Mondeo,2001,120"));
		cars.add(new Car("Opel,Astra,2006,100"));
		carRepository.setCarList(cars);

		carRepository.saveStateToFile("carsTest.txt");

		List<String> lines = Files.readLines(new File("carsTest.txt"), Charsets.UTF_8);
		assertEquals(lines.get(0).replace(" ", ""), "Ford,Mondeo,2001,120.0");
		assertEquals(lines.get(1).replace(" ", ""), "Opel,Astra,2006,100.0");

	}

}