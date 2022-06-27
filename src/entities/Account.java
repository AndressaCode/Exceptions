package entities;

import exceptions.BusinessException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {

	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithDrawLimit() {
		return withdrawLimit;
	}

	public void setWithDrawLimit(double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(double amount) {
		this.balance += amount;
	}

	public void withdraw(double amount) {
		validateWithdraw(amount);
		this.balance -= amount;
	}

	private void validateWithdraw(double amount) {
		if (amount > getWithDrawLimit()) {
			throw new BusinessException("Erro de saque: A quantia excede o limite de saque");
		}
		if (amount > getBalance()) {
			throw new BusinessException("Erro de saque: Saldo insuficiente");
		}
	}

// Solução não tão adequada
//	public void withdraw(double amount) {
//		if (this.balance == 0 || amount > withdrawLimit) {
//			System.out.print("You don't have enough balance to withdraw!");
//		} else {
//			this.balance -= amount;
//			System.out.print("New balance: US" + balance);
//		}
//	}

	// Solução Perfeita

	@Override
	public String toString() {
		return "Account number=" + number + ", Holder: " + holder + ", balance: " + balance + ", withdrawLimit: "
				+ withdrawLimit;
	}

}
