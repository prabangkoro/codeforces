#include <bits/stdc++.h>

using namespace std;

void solve () {
  int n, k;
  cin >> n >> k;

  set<int> m;
  for (int i = 0; i < n; ++i) {
    int a;
    cin >> a;
    m.insert(a);
  }

  if (m.size() > k) {
    cout << -1 << endl;
    return;
  }

  cout << n * k << endl;
  for (int i = 0; i < n; ++i) {
    for (auto s: m) {
      cout << s << " ";
    }
    for (int j = m.size(); j < k; ++j) {
      cout << 1 << " ";
    }
  }
  cout << endl;
}

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;
  while (n--) {
    solve();
  }

  return 0;
}