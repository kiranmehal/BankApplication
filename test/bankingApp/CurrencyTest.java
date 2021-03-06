package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingApp.Currency;

public class CurrencyTest {
	
	/* Example currencies: 
	 * 	CAD = Canadian dollar
	 * 	EUR = Euros
	 * 	GBP = Great British Pounds
	 * 	HKD = HongKong Dollars
	 */
	public Currency CAD, EUR, GBP, HKD;
	
	@Before
	public void setUp() throws Exception {
		// Setup some test currencies to use in the below test cases
		CAD = new Currency("CAD", 0.75);
		EUR = new Currency("EUR", 1.14);
		HKD = new Currency("HKD", 0.13);
	}

	@Test
	public void testGetName() {
		// Write the test case for testing the getName() function
		assertEquals("CAD", CAD.getName());
	
	}
	
	@Test
	public void testGetRate() {
		// @TODO: Write the test case for testing the getRate() function
		assertEquals(0.75, CAD.getRate(),0);
	}
	
	@Test
	public void testSetRate() {
		// @TODO: Write the test case for testing the setRate() function
		
		// For this function, you should do:
		// 1. Assert that the oldRate is correct
		// 2. Change the rate
		// 3. Assert that the newRate is correct
		// You will end up with 2 assert() statements in this function.
		assertEquals(0.75, CAD.getRate(),0);
		CAD.setRate(1.33);
		assertEquals(1.33, CAD.getRate(),0);
	}
	
	@Test
	public void testValueInUSD() {
		// @TODO: Write the test case for testing the valueInUSD() function
		assertEquals(114,EUR.valueInUSD(100),0);
	}
	
	@Test
	public void testValueInThisCurrency() {
		// @TODO: Write the test case for testing the valueInThisCurrency() function
		// For this function, you should:
		// 1. Assert the value of the "other" currency
		// 2. Get the value in "this" currency
		// 3. Assert that the value in "this" currency is correct
		// You will end up with 2 assert() statements in this function.
		assertEquals(57.69,CAD.valueInThisCurrency(10, HKD),0);
		
		assertEquals(10.0,HKD.valueInThisCurrency(57.69, CAD),0);
	}

}
