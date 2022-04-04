package arraytest;

public class BubbleSort {
public static void main(String[] args) {
	int []arr1 = new int[]{10,2,80,12312,43,543,76,23};
	int temp=0;
	for(int i = 0;i < arr1.length;i++){
		for(int j = 0;j < arr1.length - 1 - i;j++){
			if(arr1[j+1] > arr1[j]){
				temp = arr1[j];
				arr1[j] = arr1[j+1];
				arr1[j+1] = temp;
			}
			
		}
	}
	for(int i = 0;i < arr1.length;i++){
		System.out.print(arr1[i] + "\t");
	}
}
}
