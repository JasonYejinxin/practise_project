package arraytest;

public class ReverseString2 {
	public static void main(String[] args) {
		String a = reverse("abdwqdq");
		System.out.println(a);
	}

	
	public static String reverse(String str){
		char[] str1 = str.toCharArray();
		swap(str1);
		return new String (str1);
	}
	
	public static void swap(char[] str1){
		for(int top = 0, bot = str1.length - 1; top <= bot; top++, bot--){
			char temp;
			temp = str1[bot];
			str1[bot] = str1[top];
			str1[top] = temp;
		}
	}
}
