package extendsTest1;

public class ManKind {
    private int sex;
    private int salary;
    
    
public ManKind() {
	}

public ManKind(int sex, int salary) {
		super();
		this.sex = sex;
		this.salary = salary;
	}

public int getSex() {
		return sex;
	}

public void setSex(int sex) {
		this.sex = sex;
	}

public int getSalary() {
		return salary;
	}

public void setSalary(int salary) {
		this.salary = salary;
	}

    void manOrWomen(){
	if(sex == 1){
		System.out.println("man");
	}
	else System.out.println("woman"); 
    }

    void employed(){
	if(salary == 0){
		System.out.println("no job");
	}
	else System.out.println("job");
    }
}
