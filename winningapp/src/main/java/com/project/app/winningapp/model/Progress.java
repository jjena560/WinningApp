package com.project.app.winningapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Progress {
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBodyFat() {
		return bodyFat;
	}

	public void setBodyFat(double bodyFat) {
		this.bodyFat = bodyFat;
	}

	public double getMuscleMass() {
		return muscleMass;
	}

	public void setMuscleMass(double muscleMass) {
		this.muscleMass = muscleMass;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double weight;
    private double bodyFat;
    private double muscleMass;
    private Date date;

    @ManyToOne
    private User user;

    // Constructors, getters, and setters
}
