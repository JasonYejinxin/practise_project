
    class Solution {
        public boolean isPalindrome(int x) {
            String str1 = String.valueOf(x);
            char []arr = str1.toCharArray();
            char []arr1 = new char[arr.length];
            for(int i = 0; i < arr.length; i++){
                arr1[i] = arr[i];
            }
            char temp;
            for(int start= 0, end = arr.length - 1; start < end; start ++, end --){
                temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            if((new String(arr1)).equals(new String(arr))){
                return true;
            }
            return false;
        }
    }

