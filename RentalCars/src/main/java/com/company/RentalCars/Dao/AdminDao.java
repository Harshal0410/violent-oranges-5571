package com.company.RentalCars.Dao;

import com.company.RentalCars.Entity.Car;
import com.company.RentalCars.Exceptions.SomethingWentWrong;

public interface AdminDao {
	
	public void addCar(Car c) throws SomethingWentWrong;
	
	public void updateCar(Car c) throws SomethingWentWrong;
	
	public void deleteCar(String brand,String model) throws SomethingWentWrong;
	
	public void printCartList() throws SomethingWentWrong;
	
}
