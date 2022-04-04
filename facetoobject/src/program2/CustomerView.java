package program2;

import org.junit.Test;

public class CustomerView {
    private CustomerList customersTest = new CustomerList(10);
    
	public CustomerView() {
		Customer cust = new Customer("张三", '男', 30, "010-56253825",
				"abc@email.com");
		customersTest.addCustomer(cust);
	}
	
	
	

public void enterMainView(){
	boolean isFlag = true;
	while(isFlag){
	System.out.println("----------客户信息管理软件----------");
	System.out.println("           1 添加客户");
	System.out.println("           2 修改客户");
	System.out.println("           3 删除客户");
	System.out.println("           4 客户列表");
	System.out.println("           5 退        出");
	System.out.print("\t" + "      请选择(1-5):");
	char key = CMUtility.readMenuSelection();
	switch(key){
	case '1' : addNewCustomer();
	break;
	case '2' : modifyCustomer();
	break;
	case '3' : deleteCustomer();
	break;
	case '4' : customerList();
	break;
	case '5' :
		System.out.println("请问是否退出(Y/N):");
		char yesOrNo = CMUtility.readConfirmSelection();
		if(yesOrNo == 'Y'){
		isFlag = false;
		}
	}
}
}


private void addNewCustomer(){
	System.out.println("-------------添加客户-------------");
	System.out.print("姓名：");
	String name = CMUtility.readString(10);
	System.out.print("性别：");
	char gender = CMUtility.readChar();
	System.out.print("年龄：");
	int age = CMUtility.readInt();
	System.out.print("电话号码：");
	String phoneNumber = CMUtility.readString(15);
	System.out.print("电子邮箱：");
	String email = CMUtility.readString(15);
	boolean isEmpty = customersTest.addCustomer(new Customer(name, gender, age, 
			phoneNumber, email));
	if(isEmpty){
		System.out.println("添加完成");
	}
	else System.out.println("添加失败");
}


private void modifyCustomer(){
	System.out.println("-------------更改客户-------------");
	System.out.print("请输入你需要更改的账号序号");
	int number = CMUtility.readInt();
	System.out.print("请输入姓名");
	String name = CMUtility.readString(10,customersTest.
			getCustomer(number-1).getName());
	System.out.print("请输入性别");
	char gender = CMUtility.readChar(customersTest.
			getCustomer(number-1).getGender());
	System.out.print("请输入年龄");
	int age = CMUtility.readInt(customersTest
			.getCustomer(number-1).getAge());
	System.out.print("请输入电话号码");
	String phoneNumber = CMUtility.readString(10,customersTest.
			getCustomer(number-1).getPhoneNumber());
	System.out.print("请输入电子邮箱");
	String email = CMUtility.readString(10,customersTest.
			getCustomer(number-1).getEmail());
	
	boolean isModified = customersTest.replaceCustomer
			(number - 1,new Customer(name, gender, age, 
					phoneNumber, email));
	if(isModified = true){
		System.out.println("更换成功");
	}
	else System.out.println("更换成失败");

	
}
private void deleteCustomer(){
	System.out.println("-------------删除客户-------------");
	System.out.print("请输入你需要删除账号的序号：");
	int number = CMUtility.readInt();
	boolean isDeleted = customersTest.deleteCustomer(number-1);
	if(isDeleted = true){
		System.out.println("删除成功");
	}
	else System.out.println("删除失败");
}


private void customerList(){
	int number = customersTest.getTotal();
	Customer[] List = customersTest.getAllCustomers();
	System.out.println("编号" + "\t" +"姓名" + "\t" +"性别" + "\t" +"年龄" + "\t" +
	"电话号码" + "\t\t" + "电子邮箱");
    for(int i = 0;i < number; i++){
		System.out.println(i+1 + "\t" + List[i].getName() + "\t"  + 
        List[i].getGender() + "\t" +  List[i].getAge() + "\t"  + 
        List[i].getPhoneNumber() + "\t" + List[i].getEmail());
	}
}


public static void main(String[] args) {
	CustomerView product = new CustomerView();
	product.enterMainView();	
}

}