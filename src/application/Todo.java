package application;

import java.time.LocalDate;

public class Todo {
	private LocalDate date;
	private String content;
	
	public Todo(String content, LocalDate date) {
		this.content=content;
		this.date = date;
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return date + "["+content+"]";
	}

	
}
