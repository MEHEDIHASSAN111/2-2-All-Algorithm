#include<bits/stdc++.h>
using namespace std;

int partition(vector<int>&v,int low,int high){
    int pivot=v[low];
    int i=low+1;
    for(int j=low;j<=high;j++){
        if(v[j]<pivot){
            swap(v[i],v[j]);
            i++;
        }
    }
    swap(v[i-1],v[low]);
    return i-1;
}


void quicksort(vector<int>&v,int low,int high){
    if(low<high){
        int pi= partition(v,low,high);
        quicksort(v,low,pi-1);
        quicksort(v,pi+1,high);

    }

}

 int main(){
    cout<<"entrer  the number of elements"<<endl;
    int n;
    cin>>n;
    vector<int>v(n);
    for(int i=0;i<n;i++){
        cin>>v[i];
    }
    quicksort(v,0,n-1);
    for(int num:v){
        cout<<num<<" ";
    }
    cout<<endl;
    
 }