#include<iostream>
#include<chrono>

using namespace std;
using namespace chrono;

void sort(int *arr,int start, int size);

int32_t main(){
    cout<<"Enter the number of elements in the array\n";
    int n;
    cin>>n;
    int * arr = new int [n];
    cout<<"Enter the elements in the array\n";
    srand(time(0));
    for(int i = 0 ; i <  n; i++){
        // cin>>arr[i];
        arr[i] = rand();
        cout<<arr[i]<<" ";
    }

    cout<<"\n";
    auto start = high_resolution_clock::now();
    sort(arr,0,n);
    auto stop = high_resolution_clock::now();
    auto time = stop -start;
    cout<<"The time taken for execution of the program is "<<time.count()<<" ms"<<endl;

    for(int i = 0 ; i < n; i++){
        cout<<arr[i]<<" ";
    }

}

void sort(int  * arr ,int start ,int size){
    if(start == size)
    return;
    int min = start;

    for(int i = start+1; i < size; i++){
        arr[i]<arr[min]?min=i:min;
    }

    swap(arr[min],arr[start]);
    sort(arr,start+1,size);
}