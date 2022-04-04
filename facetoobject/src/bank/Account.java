package bank;

public class Account {
	private double balance;


	public Account(double init_balance){
		this.balance = init_balance;
	}

	public double getBalance(){
		return balance;
	}

	public void withdraw(double amount){
		if(this.balance < amount){
			System.out.println("余额不足");
			return;
		}
		else{
			this.balance -= amount;
		}
	}

	public void deposit(double amount){
		if(amount > 0){
			this.balance += amount;
		}
		else{
			System.out.println("请输入正确的金额");
		}
	}

}
