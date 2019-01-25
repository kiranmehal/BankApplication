package bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingApp.Currency;
import bankingApp.Money;

public class MoneyTest {
	protected Currency CAD, HKD, NOK, EUR;
	protected Money CAD100, EUR10, CAD200, EUR20, CAD0, EUR0, CADnegative100;
	
	@Before
	public void setUp() throws Exception {
		// setup sample currencies
		CAD = new Currency("CAD", 0.75);
		HKD = new Currency("HKD", 0.13);
		EUR = new Currency("EUR", 1.14);
		
		// setup sample money amounts
		CAD100 = new Money(100, CAD);
		
		EUR10 = new Money(10, EUR);
		CAD200 = new Money(200, CAD);
		EUR20 = new Money(20, EUR);
		CAD0 = new Money(0, CAD);
		EUR0 = new Money(0, EUR);
		CADnegative100 = new Money(-100, CAD);
	}

	@Test
	public void testGetAmount() {
		assertEquals(200, CAD200.getAmount(),0);
	}

	@Test
	public void testGetCurrency() {
		assertEquals(CAD, CAD100.getCurrency());

	}

	@Test
	public void testToString() {
		assertEquals("10.0 EUR", EUR10.toString());
	}

	@Test
	public void testGetUniversalValue() {
		assertEquals(150, CAD200.getUniversalValue(),0);
	}

	@Test
	public void testEqualsMoney() {
		assertEquals(true, CAD0.equals(EUR0));
		assertEquals(false, CAD100.equals(EUR0));
		
	}

	@Test
	public void testAdd() {
		assertEquals("151.58 EUR",(EUR20.add(CAD200)).toString());
		assertEquals("300.0 CAD",(CAD100.add(CAD200)).toString());
	}

	@Test
	public void testSubtract() {
		assertEquals("121.58 EUR",(EUR10.subtract(CAD200)).toString());
		assertEquals("101.58 EUR",(EUR20.subtract(EUR10)).toString());
	}

	@Test
	public void testIsZero() {
		assertEquals(true, EUR0.isZero());
		assertEquals(false, CAD200.isZero());
	}

	@Test
	public void testNegate() {
		assertEquals("100.0 CAD", CADnegative100.negate().toString());
	}

	@Test
	public void testCompareTo() {
		assertEquals(0, CAD100.compareTo(CAD100));
		assertEquals(-1, EUR10.compareTo(CAD100));
		assertEquals(1, CAD100.compareTo(EUR10));
		
	}
}
