#include <bits/stdc++.h>

using namespace std;

void solve () {
  int n;
  cin >> n;
  vector<int> s(101);
  vector<int> a(n);
  int ev=0, od=0;
   
  for (auto& it: a) cin >> it;
  for (int i=0; i<n; ++i) {
    if (a[i]%2) ++od;
    else ++ev;
    ++s[a[i]];
  }

  if (ev%2==0 && od%2==0) {
    cout << "YES" << endl;
    return;
  }
  for (int i=2; i<=100; ++i) {
    if (s[i]>0 && s[i-1]>0) {
      cout << "YES" << endl;
      return;
    }
  }
  cout << "NO" << endl;
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
