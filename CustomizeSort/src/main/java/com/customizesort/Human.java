package com.customizesort;

import java.time.LocalDate;

public class Human implements Comparable<Human> {
	private String name;
	private int age;
	private float income;
	private LocalDate dob;

	public Human(String name, int age, float income, LocalDate dob) {

		this.name = name;
		this.age = age;
		this.income = income;
		this.dob = dob;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getIncome() {
		return income;
	}

	public void setIncome(float income) {
		this.income = income;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int compareTo(Human o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public boolean equals(Object obj) {
		Human other = (Human) obj;
		return this.getName().equals(other.getName())
				&& this.getAge() == other.getAge()
				&& this.getDob().equals(other.getDob())
				&& Float.valueOf(this.getIncome()).equals(Float.valueOf(other.getIncome()));
	}
}
