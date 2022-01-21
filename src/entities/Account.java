package entities;

public class Account {
	
	private Long id;
	private Double balance;
	public static Double DEPOSIT_FEE_PERCENTAGE = 0.02;
	
	public Account() {
		
	}

	public Account(Long id, Double balance) {
		this.id = id;
		this.balance = balance;
	}

	public void deposit(Double amount) {
		if(amount > 0) {
			amount -= amount * DEPOSIT_FEE_PERCENTAGE;
			balance += amount;
		}
	}
	
	public void withdraw(Double amount) {
		if(amount > balance) {
			throw new IllegalArgumentException();
		}
		balance -= amount;
	}
	
	public Double fullWithdraw() {
		double aux = balance;
		balance = 0.0;
		return aux;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	
}
