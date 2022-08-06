#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin >> n;
    long long x[n + 2], y[n + 2];
    for(int i = 1; i <= n; i++)
        cin >> x[i] >> y[i];
    
    long long sum1 = x[n] * y[1], sum2 = y[n] * x[1];
    for(int i = 1; i < n; i++) 
        sum1 += x[i] * y[i + 1], sum2 +=
        
        
        
        
        
        y[i] * x[i + 1];
    double ans = abs(sum1 - sum2) * 1.0 / 2;
    if(ans == (long long)ans)
        cout << (long long)ans;
    else
        cout << (long long)ans << ".5";
}