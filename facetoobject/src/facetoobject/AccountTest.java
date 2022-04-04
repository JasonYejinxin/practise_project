package facetoobject;

public class AccountTest {
public static void main(String[] args) {
	Account myAccount = new Account(1234, 110, 0.1);
	System.out.println(myAccount.getId());
	System.out.println(myAccount.getBalance());
	myAccount.withdraw(120);
	System.out.println(myAccount.getBalance());

}
}
