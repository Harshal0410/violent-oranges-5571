package com.company.RentalCars.Services;

import com.company.RentalCars.Dao.AdminDaoImpl;
import com.company.RentalCars.Entity.Car;
import com.company.RentalCars.Exceptions.SomethingWentWrong;

public class AdminServiceImpl implements AdminServices {

	@Override
	public void addNewCar(Car c) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		AdminDaoImpl adi = new AdminDaoImpl();
		adi.addCar(c);
	}

	@Override
	public void updateCarDetails(Car c) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		AdminDaoImpl adi = new AdminDaoImpl();
		adi.updateCar(c);
	}

	@Override
	public void deleteCar(String brand, String model) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		AdminDaoImpl adi = new AdminDaoImpl();
		adi.deleteCar(brand, model);
	}

	@Override
	public void viewCarList() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		AdminDaoImpl adi = new AdminDaoImpl();
		adi.printCartList();;
	}

}
