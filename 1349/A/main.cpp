#include <bits/stdc++.h>

using namespace std;

void solve () {
  int n, m;
  cin >> n >> m;

  if (min(n, m) == 1) {
    cout << "YES" << endl;
  } else {
    if (n == 2 && m == 2) cout << "YES" << endl;
    else cout << "NO" << endl;
  }
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