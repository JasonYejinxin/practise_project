package program2;
import org.junit.Test;

import javafx.beans.property.SetPropertyBase;
public class JUnitTest {

	public JUnitTest(){
		
	}
	
	@Test
	public void JUnit(){
		
	Customer A = new Customer();
	Customer B = new Customer();
	
	System.out.println(A.equals(B));
	}

}
