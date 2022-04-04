package customer;

public class StudentTest {
public static void main(String[] args) {
	Student []member = new Student[20];
	for(int i = 0;i < member.length;i++){
		member[i] = new Student();
		member[i].state = (int)(Math.random() * 6 + 1);
		member[i].score = (int)(Math.random() * 101);
		member[i].number= i + 1;
		System.out.print(member[i].score + "\t" + member[i].number);
		System.out.println();
	}
	System.out.println();
	for(int i = 0;i < member.length;i++){
		System.out.print(member[i].state + "\t");
	}
	System.out.println();
	Student temp;
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

class Student{
int number; //学号
int score; //成绩
int state; //年级

public void method(){
	state = (int)(Math.random() * 9 + 1);
	score = (int)(Math.random() * 100);
}
}






