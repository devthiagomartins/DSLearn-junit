package testes.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {
	
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		
		double amount = 200.00;
		double expectedValue = 196.0;
		Account acc = new Account(1L, 0.0);
		
		acc.deposit(amount);
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		
		
		double expectedValue = 100;
		Account acc = new Account(1L, expectedValue);
		double amount = -200.00;
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	}
	
	@Test
	public void balanceValueShouldBeZeroWhenFullWithdraw() {
		
		double expectedValue = 0.0;
		Account acc = new Account(1L, 300.0);
		acc.fullWithdraw();
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

}
