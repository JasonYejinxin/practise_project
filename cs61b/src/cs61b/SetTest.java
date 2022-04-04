package cs61b;

public class SetTest {
	
	private int set[];
	
	public boolean isConnected(int p, int q){
		return (set[p] == set[q]);
	}
	
	public void connect(int p, int q){
		int pp = set[p];
		int qq = set[q];
		for(int i = 0; i < set.length; i++){
			if(set[i] == pp){
				set[i] = qq;
			}
		}
	}
	public void buildSet(int n){
		set = new int [n]; 
		for(int i = 0;i < n; i++){
			set[i] = i;
		}
	}
	public static void main(String[] args){
		SetTest test1 = new SetTest();
		test1.buildSet(5);
		test1.connect(0,4);
		test1.connect(2,4);
		System.out.println(test1.isConnected(0,3));
	}
	


}
