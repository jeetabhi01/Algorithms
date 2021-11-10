public class Heap{

 
    private static int leftChildIndex(int index){
        return (index<<1) + 1;
    }
    
    private static int rightChildIndex(int index){

        return (index<<1)+ 2;
    }

    
    private  static void maxHeapify(int [] arr, int i, int size){
        int left = leftChildIndex(i);  
        int right = rightChildIndex(i);
        int largest = i;
        if(left < size && arr[largest] < arr[left]){
            largest = left;
        }
        if(right < size && arr[largest] < arr[right]){
            largest = right;
        }

        if(largest!=i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, largest, size);
        }
    }

    public  static void buildHeap(int [] arr,int size){
        for(int i = size/2-1 ; i >= 0 ; i-- ){
            maxHeapify(arr, i,size);
        }
    }
    public void insert(int element){

    }

    public int getMax(){

        return 0;
    } 

    public void heapSort(int [] arr){
        buildHeap(arr,arr.length);
        for(int i = arr.length ; i > 1; i--){
            maxHeapify(arr, 0, i);
            int temp = arr[0];
            arr[0] = arr[i-1];
            arr[i-1] = temp;
        }
    }
    public int extractMax(int []arr){


        return 0;
    }

}