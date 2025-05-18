#include<bits/stdc++.h>
using namespace std;
void selectionSort(vector<int>& arr) {
    int n = arr.size();
    for (int i = 0; i < n - 1; ++i) {
        int minIndex = i;
        for (int j = i + 1; j < n; ++j) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        swap(arr[i], arr[minIndex]);
    }
}


int main() {
    cout<<"Enter the number of element n:";
    int n;
    cin>>n;
    

     cout<<"Enter "<<n<<" elements:";
    vector<int>v(n);
     for(int i=0;i<n;i++){
        cin>>v[i];
     }

  
    selectionSort(v);

    cout << "Sorted array: ";
    for(int num : v) {
        cout << num << " ";
    }
    cout << endl;
    
    return 0;
}