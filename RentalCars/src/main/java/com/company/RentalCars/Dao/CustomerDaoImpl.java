package com.company.RentalCars.Dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.company.RentalCars.Entity.Car;
import com.company.RentalCars.Entity.Customer;
import com.company.RentalCars.Entity.LoggedInUserId;
import com.company.RentalCars.Entity.Order;
import com.company.RentalCars.Exceptions.SomethingWentWrong;
import com.company.RentalCars.Utility.Utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void addCustomer(Customer c) throws SomethingWentWrong {
		EntityManager em = null;
		try {
			em = Utility.getManager();
			
			Query query = em.createQuery("SELECT count(c) FROM Customer c WHERE username = :username");
			query.setParameter("username", c.getUsername());
			
			if((Long)query.getSingleResult() > 0) {
				throw new SomethingWentWrong("The username" + c.getUsername() + " is already occupied");
			}
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(c);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomethingWentWrong("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public void login(String username, String password) throws SomethingWentWrong {
		EntityManager em = null;
		try {
			em = Utility.getManager();
			
			Query query = em.createQuery("SELECT c.id FROM Customer c WHERE username = :username AND password = :password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			List<Integer> listInt = (List<Integer>)query.getResultList();
			
			if(listInt.size() == 0) {
				throw new SomethingWentWrong("The username or password is incorrect");
			}
			LoggedInUserId.loggedInUserId = listInt.get(0);
			System.out.println("LogIn successful");
		}catch(PersistenceException ex) {
			throw new SomethingWentWrong("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}


	@Override
	public void viewCar(String brand, String model) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = Utility.getManager();
			
			Query query = em.createQuery("SELECT c FROM Car c WHERE brand = :brand AND model = :model");
			query.setParameter("brand", brand);
			query.setParameter("model", model);
			List<Car> list = (List<Car>)query.getResultList();
			
			if(list.size() == 0) {
				throw new SomethingWentWrong("The car does not exit");
			}
			
			System.out.println(list.get(0));
		}catch(PersistenceException ex) {
			throw new SomethingWentWrong("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public void rentCar(String brand, String model) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = Utility.getManager();
			Query query = em.createQuery("select c FROM Car c WHERE brand = :brand and model = :model");
			query.setParameter("brand", brand);
			query.setParameter("model",model);

			Car car = (Car)query.getSingleResult();

			Customer customer = em.find(Customer.class, LoggedInUserId.loggedInUserId);
			
			if(car == null) {
				throw new SomethingWentWrong("No such car found");
			}
			
			//create the Order object
			Order order = new Order(customer, car, LocalDate.now());
			car.setAvailablity(0);
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(order);
			et.commit();
		}catch(PersistenceException | IllegalArgumentException ex) {
			ex.printStackTrace();
			throw new SomethingWentWrong("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public void searchCarByBrand(String brand) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = Utility.getManager();
			
			Query query = em.createQuery("SELECT c FROM Car c WHERE brand = :brand");
			query.setParameter("brand", brand);
			List<Car> list = (List<Car>)query.getResultList();
			
			if(list.size() == 0) {
				throw new SomethingWentWrong("The car does not exit");
			}
			
			System.out.println(list);
		}catch(PersistenceException ex) {
			throw new SomethingWentWrong("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public void searchCarByModel(String model) throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = Utility.getManager();
			
			Query query = em.createQuery("SELECT c FROM Car c WHERE model = :model");
			query.setParameter("model", model);
			
			List<Car> list = (List<Car>)query.getResultList();
			
			if(list.size() == 0) {
				throw new SomethingWentWrong("The car does not exit");
			}
			
			System.out.println(list);
		}catch(PersistenceException ex) {
			throw new SomethingWentWrong("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public void viewReservaions() throws SomethingWentWrong {
		// TODO Auto-generated method stub
		EntityManager em = null;
		List<Object[]> list = null;
		try {
			em = Utility.getManager();
			//find the details of logged in customer
			Customer customer = em.find(Customer.class, LoggedInUserId.loggedInUserId);
			//SELECT p.planName, o.id, o.policyStatus, o.dateOfPurchase
			//FROM Plan p JOIN Order o ON o.plan = p JOIN Customer c ON o.customer = c WHERE c = :cust
			Query query = em.createQuery("SELECT o.id, c.brand, c.model, o.purchaseDate From Car c Join Order o on o.car = c join Customer cur on o.customer = cur where cur = :cust");
			query.setParameter("cust", customer);
			list = query.getResultList();
			if(list.size() == 0)
				throw new SomethingWentWrong("No reservation found");
			for(Object[] o : list) {
				System.out.println("OrderId: " + o[0] + " Brand: " + o[1] + " Model: " + o[2] + " PurchaceDate: " + o[3]);
			}
//			System.out.println(list.get(0));
		}catch(PersistenceException ex) {
			ex.printStackTrace();
			throw new SomethingWentWrong("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

}
