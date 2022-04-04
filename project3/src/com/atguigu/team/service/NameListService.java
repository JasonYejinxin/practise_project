package com.atguigu.team.service;

import static com.atguigu.team.service.Data.EMPLOYEES;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Equipment;
import com.atguigu.team.domain.NoteBook;
import com.atguigu.team.domain.PC;
import com.atguigu.team.domain.Printer;
import com.atguigu.team.domain.Programmer;

public class NameListService {
private Employee[] employees;

public NameListService() {
	employees = new Employee[EMPLOYEES.length];
	for(int i = 0; i < EMPLOYEES.length; i ++){
		int type = Integer.parseInt(EMPLOYEES[i][0]);
		int id = Integer.parseInt(EMPLOYEES[i][1]);
		String name = EMPLOYEES[i][2];
		int age = Integer.parseInt(EMPLOYEES[i][3]);
		int salary = Integer.parseInt(EMPLOYEES[i][4]);
		
		switch(type){
			case Data.EMPLOYEE: employees[i] = new Employee(id, name, age, salary);
			break;
			case Data.PROGRAMMER: {Equipment equ = getEqu(i);
			employees[i] = new Programmer(id, name, age, salary, equ);
			}break;
			case Data.DESIGNER: {Equipment equ = getEqu(i);
			double bonus = Double.parseDouble(EMPLOYEES[i][5]);
			employees[i] = new Designer(id, name, age, salary, equ, bonus);
			}break;
			case Data.ARCHITECT: {Equipment equ = getEqu(i);
			double bonus = Double.parseDouble(EMPLOYEES[i][5]);
			int stock = Integer.parseInt(EMPLOYEES[i][6]);
			employees[i] = new Architect(id, name, age, salary, equ,bonus,stock);
			}break;	
		}
	}
}
public Equipment getEqu(int index){
	int type = Integer.parseInt(Data.EQUIPMENTS[index][0]);
	switch(type){
	case 21: return new PC(Data.EQUIPMENTS[index][1],Data.EQUIPMENTS[index][2]);
	case 22: return new NoteBook(Data.EQUIPMENTS[index][1],Double.parseDouble(Data.EQUIPMENTS[index][2]));		
	case 23: return new Printer(Data.EQUIPMENTS[index][1],Data.EQUIPMENTS[index][2]);	
	}
	return null;
}

public Employee[] getAllEmployees(){
	return employees;
}

public Employee getEmployee(int id)throws TeamException{
	if(id < 0 || id > 12){
		throw new TeamException("找不到指定的员工");
	}
	return employees[id];
}

public static void main(String[] args) {  
	try {
		NameListService test1 = new NameListService();
		test1.getEmployee(1);
		System.out.println(test1.getEmployee(1).getAge());
		System.out.println(test1.getAllEmployees().length);
	} catch (TeamException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
