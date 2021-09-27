import java.util.*;
public class MergeSort{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int num = console.nextInt();
        Random rgn = new Random();
        
        int[] arr = new int[num];

        System.out.println("Enter the elements in the array");        
        
        for(int i = 0; i <  arr.length; i++){
            int random = rgn.nextInt(Integer.MAX_VALUE);
            // System.out.print("" + arr[i] +" ");
            arr[i] = random;
        }

        long start = System.nanoTime();
        long startms = System.currentTimeMillis();
        sort(arr,0,arr.length);
        long stop = System.nanoTime();
        long stopms = System.currentTimeMillis();
        long executionms = stopms - startms;
        long execution = stop -start;
        for(int i : arr){
            System.out.print("" + i +" ");
        }
        System.out.println();
        System.out.println("The total time of execution is " + execution + "ns or " + executionms + "ms");
        console.close();
    }

    public static void sort(int [] arr , int l , int r){
        if(l < r){
            int m  = (l + r)/2;
            sort(arr,l,m);
            sort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }

    private static void merge(int [] arr, int l, int m, int r){
        int n1 =  m - l + 1;
        int n2 =  r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i =0; i < n1 ; ++i){
            left[i] = arr[l+i];
        }

        for(int j = 0; j < n2 ; ++j){
                right[j] = arr[m+j+1];
        }

        int i = 0 , j = 0;

        int k = l;

        while(i < n1 && j < n2){
            if(left[i]<= right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
  
        
    }
}