#include <bits/stdc++.h>

using namespace std;

void solve () {
  int n;
  cin >> n;
  vector<int> a(n + 1);
  for (int i = 1; i <= n; ++i) cin >> a[i];
  vector<int> cnt(n + 1);
  for (int i = 1; i <= n; ++i) cnt[i] = 1;

  for (int i = 1; i <= n; ++i) {
    for (int j = i*2; j <= n; j += i) {
      if (a[j] > a[i])
        cnt[j] = max(cnt[j], cnt[i] + 1);
    }
  } 
  int ans = 0;
  for (int i = 1; i <= n; ++i)
    ans = max(ans, cnt[i]);
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
