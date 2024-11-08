package RailwayTicketBooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Repository {
	private int[] seats;
	private HashMap<Integer, Ticket> bookedTickets = new HashMap<>();
	private HashMap<Integer, Ticket> cancelledTickets = new HashMap<>();
	private ConcurrentHashMap<Integer, Ticket> waitingList = new ConcurrentHashMap<>();
	private int waitingTicketSeats = 0;
	private static Repository repository;

	private Repository() {
		seats = new int[5];
		Arrays.fill(seats, 8);
	}

	public static Repository getInstance() {
		if (repository == null)
			repository = new Repository();
		return repository;
	}

	public int[] getSeats() {
		return seats;
	}

	public void addBookedTicket(Ticket ticket) {
		bookedTickets.put(ticket.getPNR(), ticket);

	}

	public void addToCancelledTicket(Ticket ticket) {
		cancelledTickets.put(ticket.getPNR(), ticket);
	}

	public Ticket getBookedTicket(int PNR) {
		return bookedTickets.get(PNR);
	}

	public void removeBookedTickets(Ticket ticket) {
		addToCancelledTicket(ticket);
		bookedTickets.remove(ticket.getPNR());
	}

	public HashMap<Integer, Ticket> getBookedTickets() {
		return bookedTickets;
	}

	public HashMap<Integer, Ticket> getCancelledTickets() {
		return cancelledTickets;
	}

	public int getWaitingTicketSeats() {
		return waitingTicketSeats;
	}

	public void addWaitingListSeats(int waitingTicketSeats) {
		this.waitingTicketSeats += waitingTicketSeats;
	}
	public void reduceWaitingListSeats(int waitingTicketSeats) {
		this.waitingTicketSeats -= waitingTicketSeats;
	}

	public void addToWaitingList(Ticket ticket) {
		this.waitingList.put(ticket.getPNR(), ticket);
	}

	public ConcurrentHashMap<Integer, Ticket> getWaitingList() {
		return waitingList;
	}

}
