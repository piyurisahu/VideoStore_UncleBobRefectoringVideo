package java;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String name;
	private Vector rentals=new Vector();

	public Customer(String name) {
		super();
		this.name = name;
	}


	public void addRental(Rental rental)
	{
		rentals.addElement(rental);
	}

	public String statement()
	{
		double totalAmount=0;
		int frequentRenterPoint=0;
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
			
			
		}
		return result;
		
	}



	private String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}





}
