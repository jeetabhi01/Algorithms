#include<iostream>
#include<chrono>

using namespace std;
using namespace chrono;

// template <typename T>
void sort(int * arr, int size);
void sortr(int * arr, int n);

int32_t main(){
    int num;
    cout<<"Enter the number of the elements in the array\n";
    cin>>num;
    int * arr = new int[num];
    srand(time(0));
    for(int i =0 ; i < num; i++){
        // arr[i]=rand();
        cin>>arr[i];
    }
    auto start = high_resolution_clock::now();
    sortr(arr,num);
    auto stop = high_resolution_clock::now();
    
    auto msec = duration_cast<microseconds>(stop-start);
    cout<<"The time taken for sorting the elements is "<<msec.count()<<"ms"<<endl;
    for(int i =0 ; i < num; i++)
    cout<<arr[i]<<" ";
    
    return 0;
}

void sort(int * arr, int size){
    
    for(int i = 1 ; i < size ; i++){
        int key = arr[i];
        int j = i-1;
        while(key < arr[j] && j >= 0 ){
            swap(arr[j],arr[j+1]);
            j--;
        }
    }
}

void sortr(int * arr, int n){
    if(n<=1){
        return;
    }

    sortr(arr,n-1);

    int j = n-2;
    int last = n-1;
    int key = arr[last];
    while(j>=0 && key < arr[j]){
        swap(arr[j],arr[j+1]);
        j--;
    }

}