package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MainController implements Initializable {
	@FXML
	Label score;
	@FXML
	TextField moneyField;
	@FXML
	ComboBox<String> vatComboBox;

	@FXML
	RadioButton netto;
	@FXML
	RadioButton brutto;

	ObservableList<String> list = FXCollections.observableArrayList("23 %", "22 %", "8 %", "7 %", "5 %", "3 %");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		vatComboBox.setItems(list);
	}

	public void countScore(ActionEvent event) {
		String textNumberfromTextField = moneyField.getText();
		boolean isOk = isNumberOK(textNumberfromTextField);
		if (isOk) {
			double number = Double.parseDouble(moneyField.getText());
			double vat = getVat();
			int radioButtonSelected = getSelectedRadioButto();
			if (radioButtonSelected == 1) {
				double number1 = (vat * number) / (vat + 1.0);
				number = number - number1;
			} else {
				vat = vat + 1.0;
				number = number * vat;
			}
			score.setText(number + "");
		} else {
			score.setText("Zle wype³niono");
		}
	}

	public boolean isNumberOK(String text) {
		try {
			double d = Double.parseDouble(text);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public int getSelectedRadioButto() {
		if (netto.isSelected())
			return 1;
		else
			return 2;
	}

	public double getVat() {
		String vat = vatComboBox.getSelectionModel().getSelectedItem().toString();
		System.out.println(vat);
		double number = 0.0;
		switch (vat) {
		case "23 %":
			number = 0.23;
			break;
		case "22 %":
			number = 0.22;
			break;
		case "8 %":
			number = 0.08;
			break;
		case "7 %":
			number = 0.07;
			break;
		case "5 %":
			number = 0.05;
			break;
		default:
			break;
		}
		return number;
	}

}
