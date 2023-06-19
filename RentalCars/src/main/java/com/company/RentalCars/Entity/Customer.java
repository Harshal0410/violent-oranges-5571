package com.company.RentalCars.Entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(unique = true, length = 50, nullable = false)
	private String username;

	@Column(nullable = false, length = 50)
	private String password;

	@Column(name = "date_of_birth", nullable = false)
	private LocalDate dateOfBirth;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Order> orderSet;
	
	public Set<Order> getOrderSet() {
		return orderSet;
	}

	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String username, String password, LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
}
