package bankingApp;

import org.junit.Before;
import org.junit.Test;

import bankingApp.Account;
import bankingApp.AccountDoesNotExistException;
import bankingApp.Bank;
import bankingApp.Currency;
import bankingApp.Money;

import static org.junit.Assert.*;

public class AccountTest {
	protected Currency CAD, HKD;
	protected Bank TD;
	protected Bank HSBC;
	protected Bank RBC;
	protected Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		
		// setup test currencies
		CAD = new Currency("CAD", 0.75);
		RBC = new Bank("Royal Bank of Canada", CAD);
		
		// setup test accounts
		RBC.openAccount("Peter");
		testAccount = new Account("Albert", CAD);
		testAccount.deposit(new Money(100, CAD));

		// setup an initial deposit
		RBC.deposit("Peter", new Money(500, CAD));
	}

	@Test
	public void testAddWithdraw() {
		// Something to consider - can you withdraw in a different currency?
		try {
			RBC.withdraw("Albert", new Money(100, CAD));
			Money money = testAccount.getBalance();
			assertEquals(100.0, money.getAmount(),0);
		} catch (AccountDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//fail("Write test case here");
		
	}
	
	@Test
	public void testGetBalance() {
	
		Money money1 = testAccount.getBalance();
		double money2 = money1.getAmount();
		System.out.println("money2:...." + money2);
		assertEquals(100,money2,0);
		
		
	//	fail("Write test case here");
	}
}
