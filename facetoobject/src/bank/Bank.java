package bank;

public class Bank {
private Customer[] customers;
private int numberOfCustomer;

public Bank(){
	customers = new Customer [10];
}

public void addCustomer(String f, String l){
	Customer cust = new Customer(f,l);
	customers[numberOfCustomer] = cust;
	numberOfCustomer++;
}
public int getNumberOfCustomer(){
	return numberOfCustomer;
}
public Customer getCustomers(int index){
	if(index >= 0 && index < numberOfCustomer){
		return customers[index];
	}
	return null;
}
}
