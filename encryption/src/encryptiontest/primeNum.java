package encryptiontest;
import org.junit.Test;
public class primeNum {
@Test 
public void getPrimeNum(){
	int originalNum = 11;
	int count = 11;
	for(int i = 1; i <= originalNum; i++){
		for(int j = 2; j <= i/2; j++){
			if(i % j ==0){
				count--;
				break;
			}
		}
	}
	int ans = count++;
	System.out.print(ans);
}
}
