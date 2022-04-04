package com.atguigu.team.domain;

public class Designer extends Programmer{
private double bonus;

public Designer(int id, String name, int age, double salary,
		Equipment equipment, double bonus) {
	super(id, name, age, salary, equipment);
	this.bonus = bonus;
}

public double getBonus() {
	return bonus;
}

public void setBonus(double bonus) {
	this.bonus = bonus;
}
public String toString(){
	return getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t设计师" + "\t" 
    + getStatus() + "\t" + getBonus()+ "\t\t" + getEquipment().getDescription();
}
//TDI/ID \t  姓名   \t 年龄 \t 工资   \t 职位  \t 奖金 \t 股票
public String toTeam(){
	return getMemberId() + "/"  + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary()
	 + "\t" + "设计师" + "\t"  + getBonus();
}
}
