package pl.jwrabel.javandwro2.cars;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
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

		JButton jButton = new JButton("Wczytaj");
		jButton.setLocation(300, 0);
		jButton.setSize(100, 50);
		add(jButton);

		JButton btnEdit = new JButton("Edytuj");
		btnEdit.setLocation(300, 100);
		btnEdit.setSize(100, 50);
		add(btnEdit);

		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setLocation(300, 200);
		lblBrand.setSize(100, 20);
		add(lblBrand);

		JTextField txtBrand = new JTextField();
		txtBrand.setLocation(300, 220);
		txtBrand.setSize(100, 50);
		add(txtBrand);

		JLabel lblModel = new JLabel("Model");
		lblModel.setLocation(300, 270);
		lblModel.setSize(100, 20);
		add(lblModel);

		JTextField txtModel = new JTextField();
		txtModel.setLocation(300, 290);
		txtModel.setSize(100, 50);
		add(txtModel);

		JLabel lblManYear = new JLabel("Manufacture year");
		lblManYear.setLocation(300, 340);
		lblManYear.setSize(100, 20);
		add(lblManYear);


		JTextField txtManYear = new JTextField();
		txtManYear.setLocation(300, 360);
		txtManYear.setSize(100, 50);
		add(txtManYear);

		JLabel lblPower = new JLabel("Power");
		lblPower.setLocation(300, 410);
		lblPower.setSize(100, 20);
		add(lblPower);

		JTextField txtPower = new JTextField();
		txtPower.setLocation(300, 430);
		txtPower.setSize(100, 50);
		add(txtPower);


		JButton btnSave = new JButton("Zapisz");
		btnSave.setLocation(500, 100);
		btnSave.setSize(100, 50);
		add(btnSave);


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

		btnEdit.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Car selecterCar = carJList.getSelectedValue();
				if (selecterCar != null) {
					txtBrand.setText(selecterCar.getBrand());
					txtModel.setText(selecterCar.getModel());
//					txtManYear.setText(Integer.toString(selecterCar.getManufactureYear()));
//					txtManYear.setText(String.valueOf(Integer.valueOf(selecterCar.getManufactureYear())));
					txtManYear.setText("" + selecterCar.getManufactureYear());
					txtPower.setText("" + selecterCar.getPower());
				}
			}
		});

		btnSave.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Car selecterCar = carJList.getSelectedValue();
				if (selecterCar != null) {
					selecterCar.setBrand(txtBrand.getText());
					selecterCar.setModel(txtModel.getText());

					int manufactureYear = Integer.parseInt(txtManYear.getText());
					selecterCar.setManufactureYear(manufactureYear);
					selecterCar.setPower(Double.parseDouble(txtPower.getText()));
				}
				carJList.repaint();
			}
		});
	}
}
