#include<bits/stdc++.h>
using namespace std;



 int partition( vector<int>&v,int low,int high){
    int pivot =v[low];
    int i=low+1;
    for(int j=low;j<=high;j++){
        if(v[j]<pivot){
             swap(v[i],v[j]);
             i++;
            
        }
    }
    swap(v[low],v[i-1]);

    return i-1;
}

 void quicksort(vector<int>&v,int low , int high){

    if(low<high){
        int pi=partition(v,low,high);

        quicksort(v,low,pi-1);
        quicksort(v,pi+1,high);
    }

 }



int main(){

    cout<<"Enter the number of element n:";
    int n;
    cin>>n;
    

     cout<<"Enter "<<n<<" elements:";
    vector<int>v(n);
     for(int i=0;i<n;i++){
        cin>>v[i];
     }

     
     quicksort(v,0,n-1);
     cout << "Sorted array: ";
    for (int num:v) {
        cout<<num<<" ";
    }
    cout<<endl;

    return 0;

}
//A S M MEHEDI HASSAN,IIT_JU
//infernos.23