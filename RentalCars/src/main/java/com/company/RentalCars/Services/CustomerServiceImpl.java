package com.company.RentalCars.Services;

import java.util.Scanner;

import com.company.RentalCars.Dao.CustomerDaoImpl;
import com.company.RentalCars.Entity.Car;
import com.company.RentalCars.Entity.Customer;
import com.company.RentalCars.Exceptions.SomethingWentWrong;

public class CustomerServiceImpl implements CustomerServices {

	@Override
	public void addCustomer(Customer c) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		cdi.addCustomer(c);
	}

	@Override
	public void login(String username, String password) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		cdi.login(username, password);
	}

	@Override
	public void searchCar(Scanner sc) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		int choice = 0;
		do {
			System.out.println("Select 1 to search using brand name");
			System.out.println("Select 2 to search using model name");
			System.out.println("Select 0 to go back to services section");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the brand name");
				String brand = sc.next();
				cdi.searchCarByBrand(brand);
				break;
			case 2:
				System.out.println("Enter the model name");
				String model = sc.next();
				cdi.searchCarByModel(model);
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice");
			}
		} while (choice != 0);
	}

	@Override
	public void viewCar(String brand, String model) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		cdi.viewCar(brand, model);
	}

	@Override
	public void rentCar(String brand,String model) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		cdi.rentCar(brand, model);
	}

	@Override
	public void viewReservaions() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		cdi.viewReservaions();
	}

}
