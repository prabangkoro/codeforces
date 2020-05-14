#include <bits/stdc++.h>

using namespace std;

int sdv (int n) {
  if (n%2==0) return 2;
  int s = (int)sqrt(n);
  // cout << "s:" << s << endl;
  for (int i=3; i<=s; i+=2) {
    if (n%i==0) {
      return i;
      break;
    }
  }
  return n;
}

void solve () {
  long long n, k;
  cin >> n >> k;

  if (n%2==0) {
    cout << (n + k*2) << endl;
    return;
  }
  cout << (n + sdv(n) + (k-1)*2) << endl;
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
