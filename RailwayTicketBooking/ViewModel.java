package RailwayTicketBooking;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ViewModel {
	private View view;
	private Repository repository = Repository.getInstance();

	public ViewModel(View view) {
		this.view = view;
	}

	public int bookTickets(Ticket ticket) {
		char source = ticket.getSource();
		char destination = ticket.getDestination();
		int numberOfSeats = ticket.getNumberOfSeats();
		int[] seats = repository.getSeats();
		for (int i = source; i < destination; i++) {
			if (seats[i - 'A'] < numberOfSeats) {
				addToWaitingList(source, destination, numberOfSeats);
				return 0; // if seats not available
			}
		}
		// if seats available
		ticket.setStatus(Status.Booked);
		int PNR = ticket.getPNR() == 0 ? ticket.generatePNR() : ticket.getPNR();
		repository.addBookedTicket(ticket);
		reduceSeats(source, destination, numberOfSeats); // to reduce booked seats
		return PNR; // if seats confirmed return PNR to view class
	}

	private void addToWaitingList(char source, char destination, int numberOfSeats) {
		int waitingListSeats = repository.getWaitingTicketSeats();

		if (waitingListSeats + numberOfSeats <= 2) {
			repository.addWaitingListSeats(numberOfSeats);
			Ticket ticket = new Ticket(source, destination, numberOfSeats);
			ticket.setStatus( Status.WaitingList);
			ticket.generatePNR();
			repository.addToWaitingList(ticket);
			view.showMessage("Moved to waiting list!");
		}
	}

	public boolean cancelTickets(int PNR, int numberOfSeats) {
		Ticket ticket = repository.getBookedTicket(PNR);
		if (ticket == null) {
			return false;
		} else if (numberOfSeats <= 0 || numberOfSeats > ticket.getNumberOfSeats()) {
			view.showErrorMessage("Invalid numbef of seats ");
		}
		// for Partial Cancellation
		if (numberOfSeats < ticket.getNumberOfSeats()) {
			ticket.setPartiallyCancelledTickts(numberOfSeats);
			ticket.setNumberOfSeats(ticket.getNumberOfSeats() - numberOfSeats);
			view.showMessage("Tickets Partially Cancelld!!!");
			// for full cancellation
		} else {
			ticket.setNumberOfSeats(ticket.getNumberOfSeats() + ticket.getpartiallyCancelledTickts());
			ticket.setPartiallyCancelledTickts(0);
			ticket.setStatus(Status.Cancelled);
			repository.removeBookedTickets(ticket);
			view.showMessage("Tickets Cancelld Successfully!");

		}
		increaseSeats(ticket.getSource(), ticket.getDestination(), numberOfSeats);
		waitingListAllotment();// if a ticket cancelled waiting list should be alloted
		return true;
	}

	private void waitingListAllotment() {
		ConcurrentHashMap<Integer, Ticket> waitingList = repository.getWaitingList();
		for (Integer PNR : waitingList.keySet()) {
			Ticket ticket = waitingList.get(PNR);
			int pnr = bookTickets(ticket);
			if (pnr != 0) {
				view.showMessage("Ticket Confirmed!");
				repository.reduceWaitingListSeats(ticket.getNumberOfSeats());
				waitingList.remove(PNR);
			}
		}
	}

	private void reduceSeats(char source, char destination, int numberOfseats) {
		int seats[] = repository.getSeats();
		for (char ch = source; ch < destination; ch++) {
			seats[ch - 'A'] -= numberOfseats;
		}
	}

	private void increaseSeats(char source, char destination, int numberOfseats) {
		int seats[] = repository.getSeats();
		for (char ch = source; ch < destination; ch++) {
			seats[ch - 'A'] += numberOfseats;
		}
	}

	int[] getSeatDetails() {
		return repository.getSeats();
	}

	public HashMap<Integer, Ticket> getBookedTickets() {
		return repository.getBookedTickets();
	}

	public HashMap<Integer, Ticket> getCancelledTickets() {
		return repository.getCancelledTickets();
	}

	public ConcurrentHashMap<Integer, Ticket> getWaitingList() {
		return repository.getWaitingList();
	}
}
