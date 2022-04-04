public class recursionTest1 {

    public static void reverseString(char[] s) {
        for(int start = 0, end = s.length - 1; start <= end; start ++,end --){
            char mid;
            mid = s[end];
            s[end] = s[start];
            s[start] = mid;
        }
    }

    public static void main(String[] args) {
        char[] a = {'h','e','l','l','o'};
        reverseString(a);
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]);
        }
    }
}