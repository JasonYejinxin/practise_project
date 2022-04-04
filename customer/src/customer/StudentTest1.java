package customer;

public class StudentTest1 {
public static void main(String[] args) {
	Student1 []member = new Student1[20];
	for(int i = 0;i < member.length;i++){
		member[i] = new Student1();
		member[i].state = (int)(Math.random() * 6 + 1);
		member[i].score = (int)(Math.random() * 101);
		member[i].number= i + 1;
	}
	
	StudentTest1 test = new StudentTest1();
	
	test.print(member);
	test.sort(member);
	
}


/**
 * 
 * @Description 遍历数组
 * @Author Jason Ye  Email:2332816141@qq.com
 * @Date 2021年1月7日下午5:55:33
 * @param member
 *
 */
public void print(Student1[] member){
	for(int i = 0;i < member.length;i++){
		System.out.print(member[i].score + "\t" + member[i].number);
		System.out.println();
	}
}


/**
 * 
 * @Description 冒泡排序数组值
 * @Author Jason Ye  Email:2332816141@qq.com
 * @Date 2021年1月7日下午5:51:49
 * @param member
 *
 */
public void sort(Student1[] member){
	Student1 temp;
	for(int i = 0;i < member.length;i++){
		for(int j = 0;j < member.length - i - 1;j++){
			if(member[j].score < member[j+1].score){
				//不可只交换成绩
				temp = member[j];
				member[j] = member[j+1];;
				member[j+1] = temp;
			}
		}
	}
	for(int i = 0;i < member.length;i++){
		System.out.print("名次" + (i+1) + "\t" + "学号" + member[i].number + "\t" + member[i].score + "\t" + member[i].state + "年级");
		System.out.println();
	}
}
}

class Student1{
int number; //学号
int score;  //成绩
int state;  //年级


}

