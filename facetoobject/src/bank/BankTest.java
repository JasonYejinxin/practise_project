package bank;

public class BankTest {
public static void main(String[] args) {
	Bank customer1 = new Bank();
	customer1.addCustomer("Tom", "Smith");
	customer1.getCustomers(0).setAccount(new Account(2000));
	customer1.getCustomers(0).getAccount().deposit(500);
	customer1.getCustomers(0).getAccount().getBalance();
	System.out.println(customer1.getCustomers(0).getAccount().getBalance());
	
}
}
