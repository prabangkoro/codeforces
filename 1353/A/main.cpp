#include <bits/stdc++.h>

using namespace std;

void solve () {
  int n, m;
  cin >> n >> m;
  if (n == 1) {
    cout << 0 << endl;
    return;
  }
  if (n == 2) {
    cout << m << endl;
    return;
  }
  cout << m*2 << endl;
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
