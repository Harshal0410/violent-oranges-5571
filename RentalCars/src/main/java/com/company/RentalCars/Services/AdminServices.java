package com.company.RentalCars.Services;

import com.company.RentalCars.Entity.Car;
import com.company.RentalCars.Exceptions.SomethingWentWrong;

public interface AdminServices {
	
	public void addNewCar(Car c) throws SomethingWentWrong;
	
	public void updateCarDetails(Car c) throws SomethingWentWrong;
	
	public void deleteCar(String brand,String model) throws SomethingWentWrong;
	
	public void viewCarList() throws SomethingWentWrong;
	
}
