package arraytest;


public class ReverseString {
	public static void main(String[] args){
		String a = reverse("abcdfdf");
		System.out.println(a);
	}

public static String reverse(String str1){
		char[] str = str1.toCharArray();
		char[] str2 = new char[str.length];
		int i,j;
		for (j = 0,i = str.length - 1;i >= 0 && j < str.length; i--, j++){
				str2[j] = str[i];
			}
		return new String(str2);
		
	}
}
