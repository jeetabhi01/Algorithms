import java.util.Random;
import java.util.Scanner;
// import java.util.random.*;
public class HeapSort{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the number of the elements in the array");
        int size = console.nextInt();
        int arr[] = new int [size];
        Random rgn = new Random();
        for(int i = 0 ; i < size; i++){
            arr[i] = rgn.nextInt(Integer.MAX_VALUE);
            System.out.print(arr[i]+" ");              
        }
        System.out.println();
        console.close();
        Heap heap = new Heap();
        long start = System.nanoTime();
        heap.heapSort(arr);
        long stop = System.nanoTime();
        long execution = stop - start;

        System.out.println("The heap sort algorithm took " + execution + "ns");
        for(int i =0 ; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
