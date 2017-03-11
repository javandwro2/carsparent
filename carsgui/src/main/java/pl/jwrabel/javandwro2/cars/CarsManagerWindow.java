package pl.jwrabel.javandwro2.cars;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

/**
 * Created by jakubwrabel on 11.03.2017.
 */
public class CarsManagerWindow extends JFrame {

	private CarRepository carRepository;
	private JList<Car> carJList;

	public static void main(String[] args) {
		new CarsManagerWindow();
	}

	public CarsManagerWindow() throws HeadlessException {
		setTitle("Cars manager");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(500, 300);
		setLayout(null);

		carJList = new JList<Car>();
		carJList.setSize(200, 300);
		carJList.setLocation(0, 0);
		add(carJList);

		JButton jButton = new JButton("Wczytaj");
		jButton.setLocation(300,0);
		jButton.setSize(100,50);
		add(jButton);

		carRepository = new CarRepository();


		jButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Car> carList = carRepository.getCarList();

				// ZAMIANA LISTY NA TABLICĘ
				Car[] cars = new Car[carList.size()];
				for (int i = 0; i < carList.size(); i++) {
					cars[i] = carList.get(i);
				}

				carJList.setListData(cars);
			}
		});
	}
}
