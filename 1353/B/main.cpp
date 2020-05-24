#include <bits/stdc++.h>

using namespace std;

void solve () {
  int n, k;
  cin >> n >> k;

  vector<int> a(n), b(n);
  for (auto& it: a) cin >> it;
  for (auto& it: b) cin >> it;

  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  int ca=0, cb=n-1;
  while (k--) {
    if (b[cb] > a[ca]) {
      a[ca] = b[cb];
    }
    ++ca, --cb;
  }
  int ans=0;
  for (auto it: a) ans+=it;
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
