package day01;

public class identifier {
		public static void main(String[ ] args){
		int p=0;
		for(int i=2;i<1000;i++){
		for(int j=2;j<i/2;j++){
		if(i%j == 0){
		p += j;
		}
		}
		if(p == i){
		System.out.println(p);
		p=0;
		}
		}
		}
}
