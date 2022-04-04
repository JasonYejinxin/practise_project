package customer;

public class PersonTest {
	public static void main(String[] args){ 
		Person p1 = new Person();
		Person p2 = new Person();
		p1.name = "Tom";
		p1.age = 10;
		p1.sex = 1;
		
		p1.study();
		p1.showAge();
		int newAge = p1.addAge(2);
		System.out.println(newAge);
		p1.showAge();
		p2.showAge();
	} 
}
