package pl.jwrabel.javandwro2.cars;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
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
		setSize(500, 600);
		setLayout(null);

		carJList = new JList<Car>();
		carJList.setSize(200, 300);
		carJList.setLocation(0, 0);
		add(carJList);


		JButton jButton = new JButton("Load from repository");
		jButton.setLocation(200, 0);
		jButton.setSize(200, 50);
		add(jButton);


		JButton btnSaveToFile = new JButton("Save cars to file");
		btnSaveToFile.setLocation(200, 60);
		btnSaveToFile.setSize(200, 50);
		add(btnSaveToFile);

		JButton btnLoadFromFile = new JButton("Load data from file");
		btnLoadFromFile.setLocation(200, 200);
		btnLoadFromFile.setSize(200, 50);
		add(btnLoadFromFile);

		CarEditPanel carEditPanel = new CarEditPanel(this);
		carEditPanel.setLocation(400, 0);
		add(carEditPanel);

		btnLoadFromFile.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					carRepository.loadDataFromFile("cars.txt");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				updateListFromRepository();
			}
		});


		btnSaveToFile.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					carRepository.saveStateToFile("cars.txt");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		carRepository = new CarRepository();


		jButton.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateListFromRepository();
			}
		});

		carJList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Car selectedCar = carJList.getSelectedValue();
				if (selectedCar != null) {
					carEditPanel.setEditedCar(selectedCar);
				}
			}
		});
	}

	private void updateListFromRepository() {
		List<Car> carList = carRepository.getCarList();

		// ZAMIANA LISTY NA TABLICĘ
		Car[] cars = new Car[carList.size()];
		for (int i = 0; i < carList.size(); i++) {
			cars[i] = carList.get(i);
		}

		carJList.setListData(cars);
	}

}
