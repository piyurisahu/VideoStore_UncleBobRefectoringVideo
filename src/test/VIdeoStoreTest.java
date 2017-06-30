package test;
import java.Customer;
import java.Movie;
import java.Rental;

import junit.framework.TestCase;

public class VIdeoStoreTest extends TestCase {

	Customer customer;

	public VIdeoStoreTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	
	protected void setUp()
	{
	customer = new Customer("Fred");
	
	}

	public void testSIngleReleaseNewStatement()
	{
	
		customer.addRental(new Rental(new Movie("the cell",Movie.NEW_RELEASE),3));
		assertEquals("Rental record for fred\n\tThe cell", customer.statement());
		
	}
	
	public void testDualNewStatement()
	{
		customer.addRental(new Rental(new Movie("the cell",Movie.NEW_RELEASE),3));
		customer.addRental(new Rental(new Movie("the tiger Movie",Movie.NEW_RELEASE),3));
		assertEquals("xyz", customer.statement());
	}
	public void testSingleChildrenStatement()
	{
		
		customer.addRental(new Rental(new Movie("the tiger Movie",Movie.CHILDRENS),3));
		assertEquals("xyz", customer.statement());
	}
	
	
	
}
