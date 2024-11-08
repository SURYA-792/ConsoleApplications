package RailwayTicketBooking;

import java.util.Scanner;

public class Start {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		View view = new View();
		System.out.println("Welcome to Railway Ticket Booking Application!");
		while (true) {
			System.out.println(
					"\nPlease select the option\n1.Book tickets\n2.Cancel tickets\n3.PrintSeat Details\n4.Exit");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				view.bookTicketView();
				break;
			case 2:
				view.cancelTicketView();
				break;
			case 3:
				view.printSeatsDetails();
				break;
			case 4:
				break;
			default:
				System.err.println("Please select a valid option!");
			}
		}
	}
}
