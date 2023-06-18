package com.company.RentalCars.Utility;

import java.sql.Connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Utility {
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("car");
	}
	
	public static EntityManager getManager() {
		return emf.createEntityManager();
	}
	
	public static void main(String[] args) {
		EntityManager em = Utility.getManager();
		em.close();
	}
}
