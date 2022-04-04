package arraytest;

public class yanghuiTriangle {
public static void main(String[] args){
	int [][]Yanghui = new int [10][];
	
	for(int i=0;i<10;i++){
		Yanghui[i] = new int [i+1];
	}
	
	for(int i=0;i<Yanghui.length;i++){
		for(int j=0;j<Yanghui[i].length;j++){
		if(i==0 || j==0 || j==i ){
		Yanghui[i][0] = 1;
		Yanghui[i][i] = 1;
		}
		else{
		Yanghui[i][j]=Yanghui[i-1][j-1] + Yanghui[i-1][j];	
		}
		System.out.print(Yanghui[i][j] + " ");
}
		System.out.println();
}
}
}