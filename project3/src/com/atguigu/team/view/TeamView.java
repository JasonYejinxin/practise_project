/*
 * 主控模块，负责菜单的显示和处理用户操作
listSvc和teamSvc属性：供类中的方法使用
enterMainMenu ()方法：主界面显示及控制方法。
以下方法仅供enterMainMenu()方法调用：
listAllEmployees ()方法：以表格形式列出公司所有成员
getTeam()方法：显示团队成员列表操作
addMember ()方法：实现添加成员操作
deleteMember ()方法：实现删除成员操作
 */
package com.atguigu.team.view;
import com.atguigu.team.view.TSUtility;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;
import com.atguigu.team.service.TeamService;

import com.atguigu.team.domain.*;
public class TeamView {
private NameListService listSvc = new NameListService();
private TeamService teamSvc = new TeamService();

public void enterMainMenu() throws TeamException{
	boolean flag = true;
	char key = 0;
	do{
//	if(key != 1){
		listAllEmployees();
//	}
	key = TSUtility.readMenuSelection();
	switch(key){
	case '1': getTeam();
	break;
	case '2': addMember();
	break;
	case '3': deleteMember();
	break;
	case '4': {
	System.out.println("请再次确认，输入（Y/N）");
	char yesOrNo = TSUtility.readConfirmSelection();
	if(yesOrNo == 'Y'){
		flag = false;
	}
	}
	break;
	}
	}while(flag);
}

private void listAllEmployees(){
	System.out.println("--------------------------------" + "开发团队调度软件" + "--------------------------------");
	System.out.println("ID" +"\t"+ "姓名 " +"\t" + "年龄" + "\t" + "工资" +"\t"
		+ "职位" +"\t"+ "状态" +"\t"+ "奖金" +"\t"+ "股票" +"\t"+ "领用设备");
	System.out.println();
	Employee totalMembers[] = listSvc.getAllEmployees(); 
	for(int i = 0; i < totalMembers.length; i++){
		System.out.println(totalMembers[i]);
	}
	System.out.println("-------------------------------------------------------------------------");
	System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
}


private void getTeam(){
	System.out.println("--------------------团队成员列表---------------------");
	Programmer newTeam[] = teamSvc.getTeam();
	if(teamSvc.getTeam().length == 0){
		System.out.println("开发团队还没有成员");
	}else{
	System.out.println("TDI/ID \t  姓名   \t 年龄 \t 工资   \t 职位  \t 奖金 \t 股票");
	System.out.println();
	for(int i = 0; i < teamSvc.getTotal(); i++)
	System.out.println(newTeam[i].toTeam());	
}
	TSUtility.readReturn();
}


private void addMember() {
	System.out.println("--------------------添加成员---------------------");
	System.out.println("请输入要添加的员工ID:");
	try {
		int memberId = TSUtility.readInt();
			teamSvc.addMember(listSvc.getEmployee(memberId-1));
	} catch (TeamException e) {
		System.out.println(e.getMessage());
	}
	TSUtility.readReturn();
}


private void deleteMember(){
	System.out.println("--------------------删除成员---------------------");
	if(teamSvc.getTeam().length == 0){
		System.out.println("添加失败： 列表里面没有成员");
	}
	else{
	System.out.println("请再次确认，输入（Y/N）");
	char yesOrNo = TSUtility.readConfirmSelection();
	System.out.println("请输入要删除的员工ID:");
	if(yesOrNo == 'Y'){
	try {
		int memberId = TSUtility.readInt();
		teamSvc.removeMember(memberId);
	} catch (TeamException e) {
		System.out.println(e.getMessage());
	}
}
	}
	TSUtility.readReturn();
}


public static void main(String[] args) throws TeamException {
	TeamView test = new TeamView();
	test.enterMainMenu();
}
}

