#include <iostream>
#include<climits>
using namespace std;
 
 
int coinsNeeded(int coins[],int amount,int n){
    //base case
    if(amount==0)return 0;
    int ans=INT_MAX;
 
    for(int i=0;i<n;i++){
        if(amount-coins[i]>=0){
            int smallerAns=coinsNeeded(coins,amount-coins[i],n);
 
            ans=min(ans,smallerAns+1);
        }
    }
    return ans;
}
int bottomUP(int coins[],int amount,int n){
    int *dp=new int[amount+1];
    dp[0]=0;
    for(int i=1;i<=amount;i++)dp[i]=-400000;
 
    for(int rs=1;rs<=amount;rs++){
        //Iterate over coins
        for(int i=0;i<n;i++){
            if(rs-coins[i]>=0){
                int smallerAns=dp[rs-coins[i]];
 
                dp[rs]=max(dp[rs],smallerAns+1);
            }
        }
    }
    return dp[amount];
}
 
int main() {
   int n;
   cin>>n;
   int length[3];
   for(int i=0;i<3;i++){
       cin>>length[i];
   }
   cout<<bottomUP(length,n,3);
}
