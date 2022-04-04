package arraytest;

public class ErfenSearch {
	public static void main(String[] args){
		int imp = 40;
		int []arr1 = new int []{10,20,30,40,50,60,70,80,90,100,110};
		int head=0,mid,end=arr1.length;
		boolean isFound = true;
		while(head < end){
			mid=(head+end)/2;
			if(imp == arr1[mid]){
				isFound = false;
				System.out.println("找到了，找到的数序号是" + mid);
				break;
			}
			else if(arr1[mid] > imp){
				end = mid-1;
			}
			else head = mid+1;
		}
			if(isFound == true){
				System.out.println("没找到");
			}
	}

}
