#include <iostream>
#include <vector>
#include <set>

using namespace std;

void solve () {
  int n;
  cin >> n;
  int a[n];
  for (auto& it: a) cin >> it;

  vector<vector<int>> pref(26, vector<int>(n + 1));
  for (int i=0; i<n; ++i) {
    for (int j=0; j<26; ++j) pref[j][i+1] = pref[j][i];
    ++pref[a[i]-1][i+1];
  }

  int ans = 0;
  for (int i=0; i<26; ++i) ans = max(ans, pref[i][n]);

  for (int l=0; l<n; ++l) for (int r=l; r<n; ++r) {
    int cnt_in = 0, cnt_out = 0;
    for (int i=0; i<26; ++i) {
      cnt_in = max(cnt_in, pref[i][r+1] - pref[i][l]);
      cnt_out = max(cnt_out, min(pref[i][l], pref[i][n] - pref[i][r+1]));
    }
    ans = max(ans, cnt_in + 2*cnt_out);
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
