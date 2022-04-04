public class trimRecursion1 {
    public String trim(String str){
        if(str == null){
            return null;
        }
        if(str.startsWith(" ")){
            char []arr = str.toCharArray();
            char []arr1 = new char[arr.length - 1];
            System.arraycopy(arr,1,arr1,0,arr.length - 1);
            str = new String(arr1);
            return trim(str);
        }
        if(str.endsWith(" ")){
            char []arr = str.toCharArray();
            char []arr1 = new char[arr.length - 1];
            System.arraycopy(arr,0,arr1,0,arr.length - 1);
            str = new String(arr1);
            return trim(str);
        }
        return str;
    }
    public static void main(String[] args) {
        trimRecursion1 test1 = new trimRecursion1();
        System.out.println(test1.trim("  abc adc "));
    }
}
