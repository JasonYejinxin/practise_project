package superTest;

import org.junit.Test;

public class Customer{
	public static void main(String[] args) {
		
		
		
		
		Account accounts = new Account(1122, 20000, 0.045);
		accounts.withdraw(30000);
		accounts.withdraw(2500);
		accounts.deposit(3000);
		System.out.println("您的账户余额为： " + accounts.getBalance() + "\n" +"月利率为：" 
		+ accounts.getMonthlyInterest());
		
	}
	
}
