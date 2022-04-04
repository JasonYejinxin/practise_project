public class MergeSort {

    public void Process(int[] a,int l,int r){
        if(l == r){
            return;
        }
       int mid = l + (r - l) >> 2;
       Process(a,l,mid);
       Process(a,r,mid);

       Merge(a,l,mid,r);
    }

    public void Merge(int[] a, int l, int mid, int r){
        int []help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <= r){
            help[i++] = (a[p1] <= a[p2]) ? a[p1++] : a[p2++];
        }
        while(p1 <= mid){
            help[i++] = a[p1++];
        }
        while(p2 <= r){
            help[i++] = a[p2++];
        }
        for (int j = 0; j < r - l + 1; i ++){
            a[j] = help[j];
        }
    }


    public static void main(String[] args) {
        MergeSort test1 = new MergeSort();
        int []a = new int[]{1,2,4,1,2,4,1,34,1,2};
        int l = 0;
        int r = a.length - 1;
        test1.Process(a,l,r);
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}
