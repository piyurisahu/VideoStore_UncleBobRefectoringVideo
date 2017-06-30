package com.piyuri.java;

import java.util.Enumeration;
import java.util.Vector;

public class Statement {

	private String customerName;
	private Vector rentals=new Vector();
	private double totalAmount ;
	private int frequentRenterPoint;

	public Statement(String name) {
		super();
		this.customerName = name;
		frequentRenterPoint = 0;
	}


	public void addRental(Rental rental)
	{
		rentals.addElement(rental);
	}

	public String generater()
	{ 	totalAmount=0;
		frequentRenterPoint=0;
		Enumeration rentals=this.rentals.elements();
		String result="Rental Records for "+getName()+"\n";

		while(rentals.hasMoreElements())
		{
			double thisAmount=0;
			Rental each=(Rental) rentals.nextElement();

			switch(each.getMovie().getPriceCode())
			{
			case Movie.REGULAR:
					thisAmount+=2;
					if(each.getDayRented()>2)
						thisAmount+=(each.getDayRented()-2)*1.5;
				break;
				
			case Movie.NEW_RELEASE:
				
					thisAmount+=each.getDayRented()*3;
			break;
			case Movie.CHILDRENS:
				thisAmount+=1.5;
				if(each.getDayRented()>3)
					thisAmount+=(each.getDayRented()-3)*1.5;
			break;
			}
			frequentRenterPoint++;
			if(each.getMovie().getPriceCode()==Movie.NEW_RELEASE && each.getDayRented()>1)
				frequentRenterPoint++;
			result="\t"+each.getMovie().getTitle()+"\t"
					+String.valueOf(thisAmount)+"\n";
			totalAmount+=thisAmount;
			
			result+="you owned"+String.valueOf(totalAmount)+"\n";
			result+="you earned"+String.valueOf(frequentRenterPoint)+"frequent renter points\n";
			System.out.println(totalAmount +"  "+frequentRenterPoint);
			
		}
		return result;
		
	}



	private String getName() {
		// TODO Auto-generated method stub
		return this.customerName;
	}


	public double getTotal() {
		// TODO Auto-generated method stub
		return totalAmount;
	}


	public int getFrequentRenterpoint() {
		// TODO Auto-generated method stub
		return frequentRenterPoint;
	}





}
