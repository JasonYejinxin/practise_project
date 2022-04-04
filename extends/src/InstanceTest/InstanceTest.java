package InstanceTest;

/*
 * 
 * @Description建立InstanceTest 类，在类中定义方法method(Person e);
在method中:(1)根据e的类型调用相应类的getInfo()方法。(2)根据e的类型执行：
如果e为Person类的对象，输出： 
“a person”;
如果e为Student类的对象，输出：
“a student”
“a person ” 
如果e为Graduate类的对象，输出：
“a graduated student”
“a student”
“a person”
 * @Author Jason Ye  Email:2332816141@qq.com
 * @Version
 * @Date 2021年2月20日下午10:17:56
 *
 */


public class InstanceTest {
	
	public static void main(String[] args) {
		InstanceTest newTest = new InstanceTest();
		newTest.method(new Graduate());
	}
	
	public void method(Person e){
		
		System.out.println(e.getInfo());
		if(e instanceof Graduate){
			System.out.println("a graduated student" + "a student" + "a person");
		}
		else if(e instanceof Student){
			System.out.println("a student" + "a person");
		}
		else{
			System.out.println("a person");
		}
	}

}
