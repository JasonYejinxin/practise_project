package encryptiontest;
import org.junit.Test;
public class Gcd {
@Test
public void gcd(){
	int a = 2346;
	int b = 3589;
	int FirstNum = Math.max(a, b);
	int SecondNum = Math.min(a, b);
	while(FirstNum % SecondNum != 0){
	int minNum = Math.min(FirstNum,SecondNum);
	SecondNum = FirstNum % SecondNum;														
	FirstNum = minNum;
}
	System.out.println(SecondNum);
	System.out.print((Math.pow(13, 39))%100);
	
}
}
