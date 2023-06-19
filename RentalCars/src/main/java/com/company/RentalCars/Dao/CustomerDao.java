package com.company.RentalCars.Dao;

import java.util.Scanner;

import com.company.RentalCars.Entity.Car;
import com.company.RentalCars.Entity.Customer;
import com.company.RentalCars.Exceptions.SomethingWentWrong;

public interface CustomerDao {

	public void addCustomer(Customer c) throws SomethingWentWrong;

	public void login(String username, String password) throws SomethingWentWrong;

	public void searchCarByBrand(String brand) throws SomethingWentWrong;
	
	public void searchCarByModel(String model) throws SomethingWentWrong;
	
	public void viewCar(String brand,String model) throws SomethingWentWrong;
	
	public void rentCar(String brand,String model) throws SomethingWentWrong;
	
	public void viewReservaions() throws SomethingWentWrong;
}
