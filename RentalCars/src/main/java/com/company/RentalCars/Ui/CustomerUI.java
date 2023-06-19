package com.company.RentalCars.Ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.company.RentalCars.Entity.Customer;
import com.company.RentalCars.Entity.LoggedInUserId;
import com.company.RentalCars.Exceptions.SomethingWentWrong;
import com.company.RentalCars.Services.CustomerServiceImpl;
import com.company.RentalCars.Services.CustomerServices;

public class CustomerUI {
	
	static void customerRegistration(Scanner sc) {
		// code to take input
		System.out.print("Enter name ");
		String name = sc.next();
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		System.out.print("Enter date of birth ");
		LocalDate dateOfBirth = LocalDate.parse(sc.next());
		

		// Create an object of customer
		Customer customer = new Customer(name, username, password, dateOfBirth);

		try {
			// Create an object of CustomerService
			CustomerServices customerService = new CustomerServiceImpl();
			customerService.addCustomer(customer);
			System.out.println("Customer added successfully");
		} catch (SomethingWentWrong ex) {
			System.out.println(ex);
		}
	}

	static void displayUserMenu() {
		System.out.println("1. To search car");
		System.out.println("2. To view car details");
		System.out.println("3. To rent a car");
		System.out.println("4. To view reservations if any");
		System.out.println("0. Logout");
	}

	static void userMenu(Scanner sc) {
		int choice = 0;
		do {
			displayUserMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
			
			CustomerServiceImpl csi = new CustomerServiceImpl();
			
			switch (choice) {
			case 1:
				try {
					csi.searchCar(sc);
				} catch (SomethingWentWrong e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Enter the brand name");
				String brand = sc.next();
				System.out.println("Enter the model name");
				String model = sc.next();
				try {
					csi.viewCar(brand, model);
				} catch (SomethingWentWrong e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Enter the brand name");
				String b = sc.next();
				System.out.println("Enter the model name");
				String m = sc.next();
			
				try {
					csi.rentCar(b, m);
				} catch (SomethingWentWrong e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					csi.viewReservaions();
				} catch (SomethingWentWrong e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 0:
				LoggedInUserId.loggedInUserId = -1;
				System.out.println("Logout successful");
				break;
			default:
				System.out.println("Invalid Selection, try again");
			}
		} while (choice != 0);
	}

	static void userLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		try {
			CustomerServices customerService = new CustomerServiceImpl();
			customerService.login(username, password);
			userMenu(sc);
		} catch (SomethingWentWrong ex) {
			System.out.println(ex.getMessage());
		}
	}
}
