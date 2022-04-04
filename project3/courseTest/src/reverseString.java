public class reverseString {
    String str = "abcdefg";
    int start;
    int end;
    char temp;
    public String reverse(String str, int start, int end){
        char []arr = str.toCharArray();
//        if(start < 0 || end > arr.length - 1){
//            throw Exception;
        for(int i = start, j = end; i <= j; i ++, j --){
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        String str1 = new String(arr);
        return str1;
    }
//    public String getStr(){
//        str = this.str;
//        return str;
//    }
}
class test{
    public static void main(String[] args) {
        reverseString test1 = new reverseString();
        System.out.println(test1.reverse(test1.str, 3, 5));
    }
}