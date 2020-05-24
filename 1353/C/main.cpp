#include <bits/stdc++.h>

using namespace std;

void solve () {
  long long n;
  cin >> n;
  if (n==1) {
    cout << 0 << endl;
    return;
  }
  long long ans = 0;
  for (long long i=3; i<=n; i+=2) {
    // cout << i << endl;
    ans += (4*i - 4)* (i/2);
  }
  cout << ans << endl;
}

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  int t; 
  cin >> t;
  while (t--) {
    solve();
  }

  return 0;
}
