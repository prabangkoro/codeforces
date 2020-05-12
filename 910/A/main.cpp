#include <bits/stdc++.h>

using namespace std;

void solve () {
  int n, d;
  cin >> n >> d;
  string s;
  cin >> s;

  vector<int> a(n);
  for (int i=0; i<n; ++i) {
    a[i] = s[i] - '0';
  }

  // for (auto it: a) cout << it << " ";
  // cout << endl;

  int l=0, prev=0;
  int step=0;
  while (l<n-1) {
    // cout << "start: " << (min(n-1, l+d)) << endl;
    for (int r=min(n-1, l+d); r>=l; --r) {
      if (a[r]) {
        l = r;
        ++step;
        break;
      }
    }
    // cout << "pr: " << prev << " l: " << l << " step: " << step << endl;
    if (prev==l) { // not found
      step = -1;
      break;
    }
    prev = l;
  }

  cout << step << endl;
}

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  solve();

  return 0;
}

