package superTest;

import java.math.BigDecimal;

import org.junit.Test;

public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	
	
	
	public Account() {
		super();
	}

	public Account(int id, double balance, double annualInterestRate) {
		this();
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		BigDecimal b = new BigDecimal(balance);
		balance = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	public double getMonthlyInterest(){
		return annualInterestRate / 12;
	}
	public void withdraw (double amount){
		if(amount <= balance){
			balance -= amount;
			System.out.println("取款成功");
			System.out.println("您的账户余额为： " + getBalance());
		}
		else {
			System.out.println("余额不足");
			System.out.println("您的账户余额为： " + getBalance());
		}
	}

	
	
	public void deposit (double amount){
		if(amount > 0){
			balance += amount;
			System.out.println("存款成功");
			System.out.println("您的账户余额为： " + getBalance());
		}
		else {
			System.out.println("请输入恰当的金额");
			System.out.println("您的账户余额为： " + getBalance());
		}
	}
}
