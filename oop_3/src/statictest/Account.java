package statictest;

/*编写一个类实现银行账户的概念，包含的属性有“帐号”、“密
码”、“存款余额”、“利率”、“最小余额”，定义封装这些
属性的方法。账号要自动生成。
编写主类，使用银行账户类，输入、输出3个储户的上述信息。
考虑：哪些属性可以设计成static属性。
*/
public class Account {
	
	private static int idNumber = 1000;
	private static String password = "12345";
	private double balance;
	private static double interestRate = 0.072;
	private static double miniBalance = 1000;
	
	public Account(){
		idNumber ++;
	}
	
	public static int getIdNumber() {
		return idNumber;
	}
	public static void setIdNumber(int idNumber) {
		Account.idNumber = idNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static double getAnnualRate() {
		return interestRate;
	}
	public static void setAnnualRate(double interestRate) {
		Account.interestRate = interestRate;
	}
	public double getBalance() {
		return balance;
	}
	public double getMiniBalance() {
		return miniBalance;
	}
	
	
	
	public static void main(String[] args) {
		Account account1 = new Account();
		System.out.println(account1.getBalance());
		System.out.println(account1.getPassword());
		System.out.println(account1.getIdNumber());
		
		Account account2 = new Account();		
		account2.setPassword("yjx1997921");	
		System.out.println(account2.getPassword());	
		System.out.println(account2.getIdNumber());
	}

}




