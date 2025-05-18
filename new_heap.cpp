#include<bits/stdc++.h>
using namespace std;


void heapify(vector<int>&v,int n,int i){
    int largest=i;
    int left=2*i+1;
    int right=2*i+2;

    if(left<n && v[left]>v[largest]){
        largest=left;
    }
    if(right<n && v[right]>v[largest]){
        largest=right;
    }
    if(largest!=i){
        swap(v[i],v[largest]);
        heapify(v,n,largest);
    }
}

void heapsort(vector<int>&v,int n){
    for(int i=n/2-1;i>=0;i--){
        heapify(v,n,i);
    }
    for(int i=n-1;i>0;i--){
        swap(v[i],v[0]);
        heapify(v,i,0);
    }


}


int main(){
    cout<<" enter the number of elements:";
    int n;
    cin>>n;
    cout<<"ENTER THE VALUE"<<endl;
    vector<int>v(n);
    for(int i=0;i<n;i++){
        cin>>v[i];
    }


    heapsort(v,n);
    cout<<" printed array"<<endl;
    for(int num:v){
        cout<<num<<" ";
    }
    
}