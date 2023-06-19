package com.company.RentalCars.Dao;

import java.util.List;

import com.company.RentalCars.Entity.Car;
import com.company.RentalCars.Entity.CarId;
import com.company.RentalCars.Exceptions.SomethingWentWrong;
import com.company.RentalCars.Utility.Utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class AdminDaoImpl implements AdminDao {

	@Override
	public void addCar(Car c) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;

		try {
			em = Utility.getManager();

			Query query = em.createQuery("SELECT count(c) FROM Car c WHERE model = :modelName and brand = :brandName");
			query.setParameter("modelName", c.getModel());
			query.setParameter("brandName", c.getBrand());

			if ((Long) query.getSingleResult() > 0) {
				throw new SomethingWentWrong(
						"Car already exists with brand: " + c.getBrand() + "and model: " + c.getModel());
			}

			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(c);
			et.commit();
			System.out.println("Car added successfully");

		} catch (PersistenceException ex) {
			ex.printStackTrace();
			throw new SomethingWentWrong("Unable to process request, try again later");
		} finally {
			em.close();
		}
	}

	@Override
	public void updateCar(Car c) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = Utility.getManager();
			// check if Car with given id exists
			Car CarFromDB = em.find(Car.class,c.getBrand());

			if(CarFromDB == null) {
				throw new SomethingWentWrong("Car with brand: " + c.getBrand() + " does not exist");
			}

			EntityTransaction et = em.getTransaction();
			et.begin();
			CarFromDB.setModel(c.getModel());
			CarFromDB.setMilage(c.getMilage());
			CarFromDB.setYear(c.getYear());
			CarFromDB.setAvailablity(c.getAvailablity());
			et.commit();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
			throw new SomethingWentWrong("Unable to process request, try again later");
		} finally {
			em.close();
		}
	}

	@Override
	public void deleteCar(String brand, String model) throws SomethingWentWrong {
		// TODO Auto-generated method stub

	}

	@Override
	public void printCartList() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;
		List<Car> list = null;
		try {
			em = Utility.getManager();
			Query query = em.createQuery("SELECT c from Car c");

			list = (List<Car>) query.getResultList();

			if (list.size() == 0) {
				throw new SomethingWentWrong("No Car Found");
			}
			for (Car c : list) {
				System.out.println(c);
			}

		} catch (IllegalArgumentException ex) {
			ex.printStackTrace(); // this is only for debugging, please comment in production mode
			throw new SomethingWentWrong("Unable to process request, try again later");
		} finally {
			em.close();
		}
	}

}
