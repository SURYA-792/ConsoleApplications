package RailwayTicketBooking;

public class Ticket {
	private static int id = 1;
	private int PNR;
	private int numberOfSeats;
	private char source;
	private char destination;
	private Status status;
	private int partiallyCancelledTickts;

	public Ticket() {
		super();
	}

	public Ticket(char source, char destination, int numberOfSeats) {
		super();
		this.numberOfSeats = numberOfSeats;
		this.source = source;
		this.destination = destination;
	}

	public int getPNR() {
		return PNR;
	}

	public int generatePNR() {
		PNR = id++;
		return PNR;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public char getSource() {
		return source;
	}

	public void setSource(char source) {
		this.source = source;
	}

	public char getDestination() {
		return destination;
	}

	public void setDestination(char destination) {
		this.destination = destination;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setPartiallyCancelledTickts(int numberOfSeats) {
		if (numberOfSeats == 0)
			this.partiallyCancelledTickts = 0;
		else
			this.partiallyCancelledTickts += numberOfSeats;
	}

	public int getpartiallyCancelledTickts() {
		return partiallyCancelledTickts;
	}

	@Override
	public String toString() {
		return "[ PNR=" + PNR + ",numberOfSeats=" + numberOfSeats + ", source=" + source + ", destination="
				+ destination + ", status=" + status + "]";
	}

}
