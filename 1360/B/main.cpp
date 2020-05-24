#include <bits/stdc++.h>

using namespace std;

void solve () {
  int n;
  cin >> n;

  vector<int> s(n);
  for (auto& it: s) cin >> it;
  sort(s.begin(), s.end());

  int ans = 1000;
  for (int i=1; i<n; ++i) {
    ans = min(ans, abs(s[i] - s[i-1]));
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
