import java.util.*;
public class MergeSort{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int num = console.nextInt();
        Random rgn = new Random();
        
        int[] arr = new int[num];

        // System.out.println("Enter the elements in the array");        
        
        for(int i = 0; i <  arr.length; i++){
            // arr[i]=console.nextInt();
            int random = rgn.nextInt(Integer.MAX_VALUE);
            System.out.print("" + arr[i] +" ");
            arr[i] = random;
        }

        long start = System.nanoTime();
        long startms = System.currentTimeMillis();
        sort(arr,0,arr.length-1);
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

  public static void sort(int [] arr, int l , int r){
    if(l>=r){
        return;
    }

    int mid = l + (r-l)/2;
    sort(arr,l,mid);
    System.out.println("executed fine");
    sort(arr,mid+1,r);
    System.out.println("executed fine");
    merge(arr,l,mid,r);

  }

  private static void merge(int[] arr, int l , int m , int r){
      int leftsize=m-l+1;
      int rightsize=r-m;
      int[] leftsubarray = new int[m-l+1];
      int[] rightsubarray = new int[r-m];
      System.out.println("left size: " + leftsize + " right size: "+ rightsize);
      System.out.println("Index bound: " + m);
      for(int i = 0 ; i<leftsize; i++){
        leftsubarray[i]=arr[i+l];
      }
      System.out.println("Index bound exectured properly");
      for(int i=0; i<rightsize; i++){
          rightsubarray[i]=arr[i+m+1];
      }

      System.out.println("Index bound exectured properly");


      int leftsubarrayptr = 0;
      int rightsubarrayptr= 0;
      int mergedindex=l;
      while(leftsubarrayptr< leftsize && rightsubarrayptr<rightsize){
            arr[mergedindex++]=leftsubarray[leftsubarrayptr]<rightsubarray[rightsubarrayptr]?leftsubarray[leftsubarrayptr++]:rightsubarray[rightsubarrayptr++];
        }
        System.out.println("While loop executed both pointers");
     if(leftsubarrayptr>=leftsize){
         while(rightsubarrayptr<rightsize){
             arr[mergedindex++]=rightsubarray[rightsubarrayptr++];
         }
         System.out.println("While loop right pointer executed");
     }
    
     else{
         while(leftsubarrayptr<leftsize){
             arr[mergedindex++]=leftsubarray[leftsubarrayptr++];
         }
        System.out.println("While loop left pointer executed");

     }
}

}