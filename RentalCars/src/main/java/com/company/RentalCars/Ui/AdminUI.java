package com.company.RentalCars.Ui;

import java.util.Scanner;

import com.company.RentalCars.Entity.Car;
import com.company.RentalCars.Exceptions.SomethingWentWrong;
import com.company.RentalCars.Services.AdminServiceImpl;

public class AdminUI {

	public static void addCar(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter the brand name");
		String brand = sc.next();
		System.out.println("Enter the model name");
		String model = sc.next();
		System.out.println("Enter the year");
		int year = sc.nextInt();
		System.out.println("Enter the milage");
		double milage = sc.nextDouble();
		System.out.println("Enter 1 if car is available or 0 if not available");
		int aval = sc.nextInt();
		
		Car c = new Car(brand,model,year,milage,aval);
		AdminServiceImpl asi = new AdminServiceImpl();
		try {
			asi.addNewCar(c);
		} catch (SomethingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateCar(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter the brand name");
		String brand = sc.next();
		System.out.println("Enter the model name");
		String model = sc.next();
		System.out.println("Enter the year");
		int year = sc.nextInt();
		System.out.println("Enter the milage");
		double milage = sc.nextDouble();
		System.out.println("Enter 1 if car is available or 0 if not available");
		int aval = sc.nextInt();
		
		Car c = new Car(brand,model,year,milage,aval);
		AdminServiceImpl asi = new AdminServiceImpl();
		try {
			asi.updateCarDetails(c);
		} catch (SomethingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteCar(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter the brand name");
		String brand = sc.next();
		System.out.println("Enter the model name");
		String model = sc.next();
		
	}

	public static void viewCarList() {
		// TODO Auto-generated method stub
		AdminServiceImpl asi = new AdminServiceImpl();
		try {
			asi.viewCarList();
		} catch (SomethingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
