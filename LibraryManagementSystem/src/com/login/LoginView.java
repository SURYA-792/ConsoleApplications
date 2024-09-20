package com.login;

import java.util.Scanner;

public class LoginView {
	private LoginViewModel loginViewModel;
	public static Scanner sc = new Scanner(System.in);
	
	public LoginView(){
		loginViewModel = new LoginViewModel(this);
	}
	public void init() {
		System.out.print("\nWelcome to Library Management Application.");
		System.out.println("\nPlease login to proceed.");
		
		System.out.println("\nEnter the user id:");
		String userId = sc.next();
		
		System.out.println("Enter the password: ");
		String password = sc.next();
		
		loginViewModel.validateUser(userId, password);
		
	}
}
