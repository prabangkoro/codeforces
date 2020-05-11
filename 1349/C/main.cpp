#include <bits/stdc++.h>

using namespace std;

int new_k (int k, int n) {
  int m = k % n;
  if (m < 0) m += n;
  return m;
}

void solve () {
  int n;
  cin >> n;

  int a[n];
  for (int i = 0; i < n; ++i) cin >> a[i];

  vector<bool> shuffled((long long)2e9 + 1, false);
  long long MID = (long long)1e9;
  bool possible = true;
  for (int i = 0; i < n; ++i) {
    // cout << "nwk: " << new_k(i, n) << endl;
    long long nw_k = (long long)i + (long long)a[new_k(i, n)] + MID;
    // cout << "nwk: " << (nw_k - MID) << endl;
    // cout << "new vacant: " << nw_k << " " << i << " " << a[i] << endl;
    if (shuffled[nw_k]) {
      possible = false;
      break;
    }
    shuffled[nw_k] = true;
  }
  cout << (possible ? "YES" : "NO") << endl;
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