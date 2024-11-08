package RailwayTicketBooking;

import java.util.Arrays;
import java.util.Scanner;

public class View {
	private ViewModel vm;
	private Scanner sc;

	public View() {
		vm = new ViewModel(this);
		sc = new Scanner(System.in);
	}

	void bookTicketView() {
		System.out.println("Enter Source: ");
		char source = sc.next().charAt(0);

		System.out.println("Enter Destination: ");
		char destination = sc.next().charAt(0);

		System.out.println("Enter number of Seats: ");
		int seats = sc.nextInt();
		Ticket ticket = new Ticket(source, destination, seats);
		int PNR = vm.bookTickets(ticket);
		if (PNR == 0) {
			System.err.println("Seats Not Available!");
		} else {
			System.out.println("Ticket Confirmed! Your PNR Number is: " + PNR);
		}
	}

	void cancelTicketView() {
		System.out.println("Enter your PNR: ");
		int PNR = sc.nextInt();
		System.out.println("Enter Number of seats: ");
		int numberofSeats = sc.nextInt();
		if (!vm.cancelTickets(PNR, numberofSeats)) {
			System.out.println("Invalid PNR and Seats");
		}
	}

	void printSeatsDetails() {
		int[] seats = vm.getSeatDetails();
		System.out.println("                    A  B  C  D  E");
		System.out.println("Available Tickets: " + Arrays.toString(seats));
		for (int i = 0; i <= 8; i++) {
			if (i != 0)
				System.out.print((i) + "   ");
			else
				System.out.print("    ");

			for (int j = 'A'; j <= 'E'; j++) {
				if (i == 0)
					System.out.print((char) (j) + "   ");
				else
					System.out.print(8 - i >= seats[j - 'A'] ? "*   " : "    ");

			}
			System.out.println();
		}
		
		System.out.println("Booked Tickets: "+vm.getBookedTickets());
		System.out.println("Cancelled Tickets: "+vm.getCancelledTickets());
		System.out.println("WaitingList Tickets: "+vm.getWaitingList());
	}

	public void showErrorMessage(String message) {
		System.err.println(message);
	}

	public void showMessage(String message) {
		System.out.println(message);
	}
}
