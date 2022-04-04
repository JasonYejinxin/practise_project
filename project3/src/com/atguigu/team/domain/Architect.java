package com.atguigu.team.domain;

public class Architect extends Designer{
private int stock;

public Architect(int id, String name, int age, double salary,
		Equipment equipment,double bonus,int stock){
	super(id, name, age, salary, equipment, bonus);
	this.stock = stock;
}

public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}
public String toString(){
	return getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t架构师" + "\t" 
   + getStatus() + "\t" + getBonus() + "\t" + getStock()+ "\t" + getEquipment().getDescription();
}
//TDI/ID \t  姓名   \t 年龄 \t 工资   \t 职位  \t 奖金 \t 股票
public String toTeam(){
	return getMemberId() + "/"  + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary()
	 + "\t" + "架构师" + "\t" + getBonus() + "\t" + getStock();
}
}
