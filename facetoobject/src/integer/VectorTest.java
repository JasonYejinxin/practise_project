package integer;
import java.util.Vector;
import java.util.Scanner;
public class VectorTest {

	public static void main(String[] args) {
		Vector v=new Vector();
		int maxScore = 0;
		Scanner scan = new Scanner(System.in);
		while(true){
			int score = scan.nextInt();
			if(score < 0){
				break;
			}
			else if(score > 100){
				System.out.println("请输入正确的分数");
				continue;
			}
			else {
				Integer inScore = new Integer(score);
				v.addElement(inScore);
			}
		if(maxScore < score){
			maxScore = score;
		}
		}
//		v.size();
//		System.out.println(v.size());
		System.out.println(maxScore);
		char level;
		for(int i = 0; i < v.size(); i++){
			Object obj = v.elementAt(i);
//			jdk5.0之前
//			Integer score1 = (Integer)obj;
//			int intScore = score1.intValue();
			
//			jdk 5.0之后
			int intScore = (int)obj;
			if(maxScore - intScore <= 10 ){
				level = 'A';
				
			}
			else if(maxScore - intScore <= 20 ){
				level = 'B';
		    }
			else if(maxScore - intScore <= 30 ){
				level = 'C';
	        }
	  		else {
				level = 'D';
			}
			System.out.println("Student" + i + "的分数为" + intScore + "等级为" + level);
        }
		

}
}