package facetoobject;

public class Recersion {
	public static void main(String[] args) {
		
	System.out.println(method(10));
	}
	
	
	 static int method(int i){
		int []arr = new int[10];
		arr[0] = 1;
		arr[1] = 4;
		if(i==0)
			return 1;
		else if(i==1)
			return 4;
		else 
			return method(i-2) + 2 * method(i-1);
			
		}
}

