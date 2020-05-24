#include <bits/stdc++.h>

using namespace std;

void solve () {
  int a, b;
  cin >> a >> b;

  int s = max(max(a, b), 2 * min(a, b));
  // cout << s << endl;

  cout << (s * s) << endl;
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
