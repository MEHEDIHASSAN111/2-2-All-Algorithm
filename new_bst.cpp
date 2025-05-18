#include<bits/stdc++.h>
using namespace std;
const int MAX_SIZE=100;
int tree[MAX_SIZE];
int size=0;

void initialization(){
    for(int i=0;i<=MAX_SIZE;i++){
        tree[i]==-1;
    }
}
void insert(int value){
     int index=0;
     while(index<MAX_SIZE){
        if(tree[index]==-1){
            tree[index]=value;
            size++;
        }
        if(value<tree[index]){
            index=2*index+1;
        }
        else{
            index=2*index+2;
        }
     }

}
void bst(vector<int>&v,int n){
    for(int i=0;i<n;i++){
        insert(v[i]);
    }
}

int main(){
    cout<<"Enter the number of elements:";
    int n;
    cin>>n;
    cout<<"Enter the elements:";
    vector<int>v(n);
    for(int i=0;i<n;i++){
        cin>>v[i];
    }
    initialization();
    bst(v,n);



}
    