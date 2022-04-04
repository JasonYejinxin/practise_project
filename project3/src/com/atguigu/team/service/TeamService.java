package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;

public class TeamService {
private int counter = 1;
private final int MAX_MEMBER = 5;
private Programmer[] team = new Programmer[MAX_MEMBER];
private int total = 0;

public boolean isSccess = false;

public Programmer[] getTeam(){
    Programmer[] team = new Programmer[total];

    for (int i = 0; i < total; i++) {
        team[i] = this.team[i];
    }
    return team;
}
public int getTotal() {
	return total;
}
public int getCounter() {
	return counter;
}
public void addMember(Employee e) throws TeamException{
	if(total >= 5){
		throw new TeamException("添加失败，原因：队伍已满，无法添加");
	}
	if(!(e instanceof Programmer)){
		throw new TeamException("添加失败，原因：该成员不是开发人员，不可被添加");
	}
	Programmer p = (Programmer)e;
	if(p.getStatus().getNAME().equals("VOCATION")){
		throw new TeamException("添加失败，原因：该成员正在休假，不可被添加");
	}
	if(p.getStatus().getNAME().equals("BUSY")){
		throw new TeamException("添加失败，原因：该成员正在忙，不可被添加");
	}
	if(isExist(p)){
		throw new TeamException("添加失败，原因：该成员已经在开放人员中，不可被添加");
	}
	int archiNum = 0;
	int desiNum = 0;
	int progNum = 0;
	for(int i = 0; i < total; i++){
	if(team[i] instanceof Architect){
		archiNum ++;
	}
	else if(team[i] instanceof Designer){
		desiNum ++;
	}
	else if(team[i] instanceof Programmer){
		progNum ++;
	}
}
	if(p instanceof Architect){
	if(archiNum >= 1){
		throw new TeamException("添加失败，原因：最多一名架构师");
	}
	}
	else if(p instanceof Designer){
	if(desiNum >= 2){
		throw new TeamException("添加失败，原因：最多两名设计师");
	}
	}
	else if(p instanceof Programmer){
	if(progNum >= 3){
		throw new TeamException("添加失败，原因：最多三名程序员");
	}
	}
		team[total++] = p;
		p.setMemberId(counter++);
		p.setStatus(Status.BUSY);;
		System.out.println("添加成功");
}

public boolean isExist(Programmer p){
	for(int i = 0; i < total; i++){
		if(p == team[i]){
			return true;
		}
	}
	return false;
}

public void removeMember(int memberId) throws TeamException{
//	if(memberId < 0 || memberId > 5){
//		throw new TeamException("请输入正确的用户ID");
//	}
	int i;
	for(i = 0; i < total; i++){
		if(team[i].getMemberId() == memberId){
		team[i].setStatus(Status.FREE);
		break;
	}
	}
//	if(i == total){
//		throw new TeamException("删除失败：没有找到这个成员");
//	}
	if(team[i] == null){
		throw new TeamException("删除失败：没有找到这个成员");
	}
	team[i] = null;
	for(int n = i; n < total; n++){
		team[n] = team[n + 1];
	}
	total --;
	System.out.println("删除成功");
	isSccess = true;
}
}
