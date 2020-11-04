package views;

import java.time.LocalDate;

import application.Todo;
import application.Util;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainController {
	@FXML
	private DatePicker datePicker;
	@FXML
	private TextField txtContent;
	@FXML
	private ListView<Todo> list;
	
	private ObservableList<Todo> items;
	
	@FXML
	private Label dateLabel;
	@FXML
	private Label contentLabel;
	
	@FXML
	public void initialize() {
		//처음으로 FXML이 로드가 완료되면 한번 실행되는 메서드
		items = FXCollections.observableArrayList();
		list.setItems(items);
	}
	
	public void addTodo() {
		String content = txtContent.getText();
		if(content.isEmpty()) {
			Util.alert("할 일의 내용을 입력해야 합니다.", "경고");
			return;
		}
		LocalDate date = datePicker.getValue();
		if(date == null) {
			Util.alert("날짜를 입력하세요.", "경고");
			return;
		}
		Todo t = new Todo(content, date);
		items.add(t);
		
		Util.alert("성공적으로 입력", "알림");
	}
	public void readTodo() {
		int idx = list.getSelectionModel().getSelectedIndex();
		
		if(idx <0) {
			Util.alert("선택 하셔야 합니다.", "알림");
			return;
		}
		
		Todo t = items.get(idx);
		
		dateLabel.setText("날짜"+t.getDate());
		contentLabel.setText("할일"+t.getContent());
	}
	public void delTodo() {
		int idx = list.getSelectionModel().getSelectedIndex();
		
		if(idx >=0) {
			items.remove(idx);
		}else {
			Util.alert("선택 하셔야 합니다.", "알림");
		}
		
		
	}
}
