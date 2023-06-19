package com.company.RentalCars.Entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "car")
//@IdClass(CarId.class)
public class Car {
	@Id
	String brand;
	String model;
	int year;
	double milage;
	int availablity;
	
	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
	private Set<Order> orderSet;

	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(String brand, String model, int year, double milage, int availablity) {
		super();
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.milage = milage;
		this.availablity = availablity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getMilage() {
		return milage;
	}

	public void setMilage(double milage) {
		this.milage = milage;
	}

	public int getAvailablity() {
		return availablity;
	}

	public void setAvailablity(int availablity) {
		this.availablity = availablity;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + ", year=" + year + ", milage=" + milage + ", availablity="
				+ availablity + "]";
	}
}
