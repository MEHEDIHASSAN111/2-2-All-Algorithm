
/* Bubble Sort Algorithm in C++
 This program sorts an array using the bubble sort algorithm.*/
#include<bits/stdc++.h>
using namespace std;
void solve(){
    cout<<"Enter the number of elements N:";
    int n;
    cin>>n;
    vector<int>v(n);

// the basic idea of bubble sort is to repeatedly swap adjacent elements if they are in the wrong order.
// The algorithm continues to pass through the list until no swaps are needed, indicating that the list is sorted.
    cout<<"Enter the Elements:";

    for(int i=0;i<n;i++){
        cin>>v[i];
    }

    // sorting using bubble sort
      
      for (int i = 0; i < n - 1; i++) { 
        for (int j = 0; j < n - i - 1; j++) { // Perform multiple passes
            if (v[j] > v[j + 1]) {
                swap(v[j], v[j + 1]); // Swapping elements
            }
        }
    }

    // print the sorting array
    for (int i = 0; i < n; i++)
    {
        cout<<v[i]<<" ";
    }
    
    
}


 int main(){
    solve();

 }