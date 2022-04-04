package customer;

public class Person {

	String name;
	int sex;
	/**
	 * sex=1:male;sex=0:female
	 */
	int age;

public void study(){
	String imp1 = "studying";
	System.out.println(imp1);
}
public void showAge(){
	System.out.println("age:" + age);
}
public int addAge(int i){
	age += i;
	return age;
}
}