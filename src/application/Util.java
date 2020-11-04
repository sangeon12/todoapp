package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Util {
	public static void alert(String msg, String header) {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("알림메시지");
		a.setHeaderText(header);
		a.setContentText(msg);
		
		a.show();
	}
}
