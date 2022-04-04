public class getNumber {
    int count = 0;
    public int getNumber(String str, String need){
        char []arr = need.toCharArray();
        char []arr1 = str.toCharArray();
        for(int i = 0; i < arr1.length - arr.length + 1; i++){
            if(arr[0] == arr1[i]){
                for(int j = 0; j < arr.length; j++){
                    if(arr[j] != arr1[i + j]){
                        break;
                    }
                    if(j == arr.length - 1){
                        count ++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        getNumber test = new getNumber();
        System.out.println(test.getNumber("abchhjkabchjabcjkjk", "abc"));
    }
}
