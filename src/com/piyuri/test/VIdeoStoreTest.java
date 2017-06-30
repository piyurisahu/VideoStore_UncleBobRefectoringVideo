package com.piyuri.test;
import com.piyuri.java.Movie;
import com.piyuri.java.Rental;
import com.piyuri.java.Statement;

import junit.framework.*;

public class VIdeoStoreTest extends TestCase {

	private Statement statement;
	public VIdeoStoreTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setUp()
	{
	statement = new Statement("Fred");
	
	
	}
	

	

	/**
	 * 
	 */
	public void testSingleReleaseNewStatement()
	{
	
		statement.addRental(new Rental(new Movie("the cell",Movie.NEW_RELEASE),3));
		statement.generater();
		assertEquals(9.0, statement.getTotal());
		assertEquals(2, statement.getFrequentRenterpoint());
		
	}
	
	public void testDualNewStatement()
	{
		statement.addRental(new Rental(new Movie("the cell",Movie.NEW_RELEASE),3));
		statement.addRental(new Rental(new Movie("the tiger Movie",Movie.NEW_RELEASE),3));
		statement.generater();
		assertEquals(18.0, statement.getTotal());
		assertEquals(4, statement.getFrequentRenterpoint());
	}
		
	public void testSingleChildrenStatement()
	{
		
		statement.addRental(new Rental(new Movie("the tiger Movie",Movie.CHILDRENS),3));
		statement.generater();
		assertEquals(1.5, statement.getTotal());
		assertEquals(1, statement.getFrequentRenterpoint());
		
	}
	/**
	 * 
	 */
	public void testMultipleStatementTotals()
	{
		statement.addRental(new Rental(new Movie("Kaya",Movie.REGULAR),1));
		statement.addRental(new Rental(new Movie("deewana",Movie.REGULAR),2));
		statement.addRental(new Rental(new Movie("wonder women",Movie.REGULAR),3));
		statement.generater();
/*		assertEquals("sfsdgs",statement.generater());
*/		assertEquals(7.5, statement.getTotal());
		assertEquals(3, statement.getFrequentRenterpoint());
		
	}
	
	
	
}
