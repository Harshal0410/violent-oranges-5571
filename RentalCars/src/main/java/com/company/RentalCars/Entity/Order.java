package com.company.RentalCars.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "CustomerId")
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "CarId")
	private Car car;

	@Column(nullable = false)
	private LocalDate purchaseDate;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Customer customer, Car car, LocalDate purchaseDate) {
		super();
		this.customer = customer;
		this.car = car;
		this.purchaseDate = purchaseDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", car=" + car + ", purchaseDate=" + purchaseDate + "]";
	}
}
