package testes.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import testes.factory.AccountFactory;

public class AccountTests {
	
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		
		double amount = 200.00;
		double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();
		
		acc.deposit(amount);
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		
		
		double expectedValue = 100;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.00;
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	}
	
	@Test
	public void balanceValueShouldBeZeroWhenFullWithdraw() {
		
		double expectedValue = 0.0;
		Account acc = AccountFactory.createAccount(300.0);
		acc.fullWithdraw();
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		
		Account acc = AccountFactory.createAccount(800.0);
		acc.withdraw(500.0);
		
		Assertions.assertEquals(300, acc.getBalance());
	}
	
	@Test
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			Account acc = AccountFactory.createAccount(800.0);
			acc.withdraw(801.0);
		});
		
	}
	
	

}
