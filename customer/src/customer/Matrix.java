package customer;

public class Matrix {

	
	public int outPut(int m,int n){
		int i, j=0 ;
		for(i = 0; i < n; i++){
			for(j = 0; j < m; j++){
			System.out.print("*");
		}
			System.out.println();
	    }
		int p = m * m;
		return p;
}
}