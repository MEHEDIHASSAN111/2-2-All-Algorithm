#include<bits/stdc++.h>
using namespace std;
void merge(vector<int>&v,int left,int mid,int right){
vector<int>temp;
  int i=left;
   int j=mid+1;
    while(i<=mid && j<=right){
      if(v[i]<v[j]){
        temp.push_back(v[i++]);
      }else{
        temp.push_back(v[j++]);
        }
    }
    while (i<=mid)
    {
        temp.push_back(v[i++]); 
    }
    while (j<=right)
    {
        temp.push_back(v[j++]); 
    }
    
    for( int k=left;k<=right;k++){
        v[k]=temp[k-left];
    }
    
}

void mergesort(vector<int>&v,int left ,int right){
    if(left<right){
        int mid=(left+right)/2;
        mergesort(v,left,mid);

        if(left==0 && right==v.size()-1){

       
        cout<<"1st half"<<endl;
        for(int i=left;i<=mid;i++){
            cout<<v[i]<<" ";
        }
        cout<<endl;
    }
     
        mergesort(v,mid+1,right);
        if(left==0 && right==v.size()-1){

        cout<<"2nd half"<<endl;
        for(int i=mid+1;i<=right;i++){
            cout<<v[i]<<" ";
        }
        cout<<endl;
    }



        merge(v,left,mid,right);
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
    
    mergesort(v,0,n-1);
    cout<<"print"<<endl;
    for(int num:v){
        cout<<num<<" ";
    }
    
 }