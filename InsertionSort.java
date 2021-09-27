import java.util.*;

public class InsertionSort {
    public static void main(String [] args){
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
        sort(arr,arr.length);
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

    public static void sort(int[] arr, int n){
       if(n<=1)
       return;
       sort(arr,n-1);
       int last = arr[n-1];
       int j = n-2;

       while(j >= 0 && arr[j] > last){
           arr[j+1] = arr[j];
           j--;
        }
        arr[j+1] = last;
    }
}
