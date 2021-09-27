import java.util.*;
// import java.lang.Math;

public class BubbleSort{
    public static void main(String []args){
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

    public static void sort(int[] arr,int n){
        if(n==1)
        return;
        for(int i =0 ; i < n-1 ; i++){
            if(arr[i] > arr[i + 1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        sort(arr,n-1);
    }
}