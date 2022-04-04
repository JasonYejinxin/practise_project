package cs61b;

public class quickUnion {
	private int [] parent;
	private int [] size;
	
	public void buildUnion(int n){
		parent = new int[n]; 
		for(int i = 0; i < parent.length; i++){
			parent[i] = i;
		}
		size = new int[n]; 
		for(int i = 0; i < parent.length; i++){
			size[i] = 1;
		}
	}
	public int findParent(int p){
		while(parent[p] != p){
			p = parent[p];
		}
		return p; 
	}
	
	public boolean isConnected(int p, int q){
		return (findParent(p) == findParent(q));
	}
	
	public void connect(int p, int q){
		int pp = findParent(p);
		int qq = findParent(q);
		if(size[pp] < size[qq]){
		parent[pp] = qq;
		size[qq] += size[pp];
	    }
		else{
			parent[qq] = pp;
			size[pp] += size[qq];
		}
		
	}
	public static void main(String[] args) {
		quickUnion test1 = new quickUnion();
		test1.buildUnion(6);
		test1.connect(3, 4);
		test1.connect(4, 5);
		System.out.println(test1.size[3]);
		System.out.println(test1.isConnected(3, 5));
	}

}
