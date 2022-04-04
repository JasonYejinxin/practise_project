package superTest;

import org.junit.Test;

public class CheckAccount extends Account{
	private double overdraft; //透支额
	
	
	
	public CheckAccount(int id, double balance, double annualInterestRate,
			double overdraft) {
		super(id, balance, annualInterestRate);
		this.overdraft = overdraft;
	}
	
	



	@Override
	/*
	 * (non-Javadoc)
	 * @see superTest.Account#withdraw(double)
	 * 
	 * 如果（取款金额<账户余额），可直接取款如果（取款金额>账户余额），
	 * 计算需要透支的额度判断可透支额 overdraft 是否足够支付本次透支需要，
	 * 如果可以将账户余额修改为 0，冲减可透支金额如果不可以提示用户超过可透支额的限额 
	 */
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		if(amount > super.getBalance()){
			overdraft -= amount - super.getBalance();
			if(overdraft < 0){
				overdraft += amount - super.getBalance();
				System.out.println("取款失败，可透支额不足");
				System.out.println("你的余额为：" + getBalance() + "你的可透支额为" + 
				overdraft);
			}
			else{
//				System.out.println("取款成功");
//				setBalance(0);
				withdraw(getBalance());
				System.out.println("你的余额为：0" + "你的可透支额为" + overdraft);
			}
			
		    }
		else {
			super.withdraw(amount);
		}
		
		
	}

}
