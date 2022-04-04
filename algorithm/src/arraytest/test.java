package arraytest;

public class test {
	public test(){
		
	}
	    public static int reverse(int x) {
	    	
	    	if(x > (1L << 32) || x < -(1L << 32)){
	    		return 0;
	    	}
	    	else{
	    	
	        int p = x;
	        int q = x;
	        int cnt = 1;
	        while(p/10 != 0){
	            p /= 10;
	            cnt++;
	        }
	        int []a = new int[cnt];
	        for(int i = 0; i < cnt; i++){
	            int m = q % 10;
	            q /= 10;
	            a[i] = m;
	        }
	        int [] b = new int[cnt];
	        for(int i = 0; i < cnt; i++){
	            b[i] = a[cnt - i - 1];
	        }
	        int sum = 0;
	        int mul = 1;
	        for(int i = 0; i < cnt; i++){
	            sum += b[i] * mul;
	            mul *= 10;
	        }
	      
	        return sum;
	    }
	    }
	public static void main(String[] args) {
		System.out.println(reverse(-123));
		
	}
}
