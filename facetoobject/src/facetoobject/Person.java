package facetoobject;

public class Person {

	private int age;
	
	int getAge(){
		return age;
	}
	
	public Person(){
		age = 18;
		System.out.println(age);
	}
	
	void setAge(int a){
		if (a >130 || a <0){
			System.out.println("请输入正确的年龄");
		}
		else {age = a;
		System.out.println(age);}

	}
	
}
