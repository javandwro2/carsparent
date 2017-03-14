package pl.jwrabel.javandwro2.cars;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakubwrabel on 11.03.2017.
 */
public class CarRepository {
	private List<Car> carList;

	public CarRepository() {
		carList = new ArrayList<Car>();
		carList.add(new Car("Ford", "Mustang", 2001, 240));
		carList.add(new Car("Opel", "Vectra", 2005, 100));
		carList.add(new Car("Volkswagen,Passat B5,2003,101"));
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void saveStateToFile() throws IOException {
		FileWriter fileWriter = new FileWriter("cars.txt");

		for (Car car : carList) {
			fileWriter.write(car.toString());
//			fileWriter.write("" + car);
//			fileWriter.write(System.lineSeparator());
			fileWriter.write("\n");
		}

		fileWriter.flush();
		fileWriter.close();

	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

	public void loadDataFromFile() throws IOException {
		List<String> lines = Files.readLines(new File("cars.txt"), Charsets.UTF_8);

		carList.clear();

		for (String line : lines) {
			Car car = new Car(line);
			carList.add(car);
		}

//		List<Car> carsList = new ArrayList<>();
//		for (String line : lines) {
//			Car car = new Car(line);
//			carsList.add(car);
//		}
//
//		this.carList = carsList;
	}
}

