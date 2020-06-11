package modal.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {

	private LocalDate dueDate;
	private Double value;
	
	private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Installment() {
		//
	}
	
	public Installment(LocalDate dueDate, Double value) {
		this.dueDate = dueDate;
		this.value = value;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.dueDate.format(formato) + " - " + String.format("%.2f", this.value);
	}
}
