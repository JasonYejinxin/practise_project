package com.atguigu.team.domain;

import com.atguigu.team.service.Status;

public class Programmer extends Employee{
private int memberId;
private Status status = Status.FREE;
private Equipment equipment;


public Programmer(int id, String name, int age, double salary, Equipment equipment) {
	super(id, name, age, salary);
	this.equipment = equipment;
}

public int getMemberId() {
	return memberId;
}
public void setMemberId(int memberId) {
	this.memberId = memberId;
}
public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}
public Equipment getEquipment() {
	return equipment;
}
public void setEquipment(Equipment equipment) {
	this.equipment = equipment;
}

public String toString(){
	return getId() + "\t" + getName() + "\t" + getAge() + "\t" 
	+ getSalary() + "\t程序员" + "\t" + getStatus() + "\t\t\t" + getEquipment().getDescription();
}
//TDI/ID \t  姓名   \t 年龄 \t 工资   \t 职位  \t 奖金 \t 股票
public String toTeam(){
	return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary()
	 + "\t" + "程序员";
}
}
