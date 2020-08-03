package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			double rentalAmount = 0;
			Rental each = rentals.next();

			rentalAmount += determineRentalAmount(each);


			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& each.getDaysRented() > 1)
				frequentRenterPoints++;

			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t"
					+ String.valueOf(rentalAmount) + "\n";
			totalAmount += rentalAmount;

		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

	public static double determineRentalAmount(Rental each) {
		switch (each.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				double regularRental = 2;
				if (each.getDaysRented() > 2)
					regularRental += (each.getDaysRented() - 2) * 1.5;
				return regularRental;
			case Movie.NEW_RELEASE:
				return each.getDaysRented() * 3;
			case Movie.CHILDRENS:
				double childRental = 1.5;
				if (each.getDaysRented() > 3)
					childRental += (each.getDaysRented() - 3) * 1.5;
				return childRental;

		}
		return 0;
	}
}
