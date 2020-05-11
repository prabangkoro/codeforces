#include <bits/stdc++.h>

using namespace std;

void solve () {
  int n, k;
  cin >> n >> k;

  string s;
  cin >> s;
  sort(s.begin(), s.end());

  if (s[0] != s[k - 1]) {
    cout << s[k - 1] << endl;
    return;
  }
  cout << s[0];
  if (s[k] != s[n - 1]) {
    for (int i = k; i < n; ++i) {
      cout << s[i];
    }
  } else {
    for (int i = 0; i < (n - 1) / k; ++i) {
      cout << s[n - 1];
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