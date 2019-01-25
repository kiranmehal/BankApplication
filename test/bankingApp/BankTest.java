package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingApp.AccountDoesNotExistException;
import bankingApp.AccountExistsException;
import bankingApp.Bank;
import bankingApp.Currency;

public class BankTest {
	protected Currency CAD;
	protected Currency HKD;
	protected Bank RBC;
	protected Bank TD;
	protected Bank HSBC;
	
	
	@Before
	public void setUp() throws Exception {
		
		// setup some test currencies
		this.HKD = new Currency("HKD", 0.13);
		this.CAD = new Currency("CAD", 0.75);
		
		// setup test banks
		this.RBC = new Bank("Royal Bank of Canada", CAD);
		this.TD = new Bank("TD Bank", CAD);
		this.HSBC = new Bank("Hong Kong Shanghai Banking Corporation", HKD);
		
		// add sample customers to the banks
		
		
		// HINT:  uncomment these lines AFTER you test the openAccount() function
		// You can quickly uncomment / comment by highlighting the lines of code and pressing 
		// CTRL + / on your keyboard  (or CMD + / for Macs)
		
	this.RBC.openAccount("Marcos");
	this.RBC.openAccount("Albert");
	this.TD.openAccount("Jigesha");
		this.HSBC.openAccount("Pritesh");
	}

	@Test
	public void testGetName() {
		
		assertEquals("TD Bank", TD.getName());
		
		//fail("Write test case here");
	}

	@Test
	public void testGetCurrency() {
		assertEquals("HKD", HKD.getName() );
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		
		try {
			
			 this.RBC.openAccount("Albert");
			// fail("fail");
			
		}
		catch (AccountExistsException e){
			assertEquals("account exist", e.getMessage());
		}
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		try {
		
			RBC.deposit("Albert", new Money(100, CAD));
			
			assertEquals("100", RBC.getBalance("Albert"));
		
			
		}
		catch (Exception e){
			assertEquals("doesn't exist", e.getMessage());
		}
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		try {
			
			RBC.withdraw("Marcos", new Money(100,CAD));
			
			assertEquals("", RBC.getBalance("Marcos"));
			
		
			
		}
		catch (Exception e){
			assertEquals("", e.getMessage());
		}
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
double amount = RBC.getBalance("Albert");
		
		assertEquals("", amount);
		
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		// Note: You should test both types of transfers:
		// 1. Transfer from account to account
		// 2. Transfer between banks
		// See the Bank.java file for more details on Transfers
		fail("Write test case here");
	}
	
}
