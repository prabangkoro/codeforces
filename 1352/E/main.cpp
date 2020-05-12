#include <bits/stdc++.h>

using namespace std;

void solve () {
  int n;
  cin >> n;

  vector<int> a(n);
  vector<int> cnt(n+1, 0);
  for (auto& it: a) {
    cin >> it;
    ++cnt[it];
  }

  int ans=0;
  for (int l=0; l<n; ++l) {
    int sum = 0;
    for (int r=l; r<n; ++r) {
      sum += a[r];
      if (l == r) continue;
      if (sum <= n) {
        ans += cnt[sum];
        cnt[sum] = 0;
      }
    }
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
