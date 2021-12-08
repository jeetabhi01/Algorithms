#include<bits/stdc++.h>
using namespace std;
using namespace chrono;
int binary_search(int * arr,int element, int start, int end);

int main(){
    cout<<"Enter the number of the elements in the array\n";
    int n;
    cin>>n;
    int * arr = new int[n];
    srand(time(0));
    cout<<"Enter the elements in the array\n";
    for(int i = 0 ; i < n ; i++){
        cin>>arr[i];
        // arr[i] = rand();
    }
    sort(arr,arr+n);
    cout<<"Enter the element to be searched in the array\n";
    int element;
    cin>>element;
    auto start = high_resolution_clock::now();
    int index = binary_search(arr,element,0,n-1);
    auto stop = high_resolution_clock::now();
    auto time = stop - start;
    if(index == -1){
        cout<<"Element is not present in the array\n";
    }
    else 
    cout<<"The element is present at array index "<<index<<endl;
    cout<<"The time for execution is "<<time.count()<<"ms"<<endl;
    return 0;

}

int binary_search(int * arr,int element, int start, int end){
    int mid = start + (end - start)/2;
    if(start <= end){
    if(arr[mid] == element){
        return mid;
    }
    
    else if(arr[mid]<element){
        return binary_search(arr,element,mid+1,end);
    }

    else
        return binary_search(arr,element,start,mid-1);
    }

    return -1;
}
