package arraytest;

import java.util.Scanner;

/*
 * 
 * @Description
 * @Author Jason Ye  Email:2332816141@qq.com
 * @Version
 * @Date 2021年1月1日下午6:26:51
 *
 */
public class Demo1 {
public static void main(String[] args){
	Scanner scan = new Scanner(System.in);//调用scanner + ctrl + shift o
	System.out.println("请输入学生的人数:");
	int number = scan.nextInt();
	int []scores = new int[number]; //初始化数组
	System.out.println("请输入学生成绩");
	int max=0;

	
	for(int i=0;i<scores.length;i++){
		scores[i]=scan.nextInt();
	}
	
	for(int j=0;j<scores.length;j++){
	if(max<scores[j]){
		max=scores[j];
	}
	}
	System.out.println("最高分为" + max);//最大值
	
	for(int i=0;i<scores.length;i++){
		if((max-scores[i])<=10){
			System.out.println("学生" + i+ "获得" + scores[i] + "分等级为A");
		}
		else if((max-scores[i])<=20){
			System.out.println("学生" + i+ "获得" + scores[i] +  "分等级为B");
		}
		else if((max-scores[i])<=30){
			System.out.println("学生" + i+ "获得" + scores[i] +  "分等级为C");
		}
		else{
			System.out.println("学生" + i+ "获得" + scores[i] +  "分等级为D");
		}
	}
}
}
