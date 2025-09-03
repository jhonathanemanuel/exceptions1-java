package model.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public int duration() {
		Period diff = Period.between(checkIn, checkOut);
		return diff.getDays();
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room "
				+ this.roomNumber
				+ ", check-in: "
				+ this.dtf.format(checkIn)
				+ ", check-out: "
				+ this.dtf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
	
}
